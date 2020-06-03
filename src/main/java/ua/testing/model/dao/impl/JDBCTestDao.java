package ua.testing.model.dao.impl;

import ua.testing.model.dao.TestDao;
import ua.testing.model.dao.mapper.TestMapper;
import ua.testing.model.entity.Answer;
import ua.testing.model.entity.Email;
import ua.testing.model.entity.Statistics;
import ua.testing.model.entity.Test;
import ua.testing.model.service.StatisticsService;
import ua.testing.model.service.TestService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class JDBCTestDao implements TestDao {
    private Connection connection;

    public JDBCTestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void delete(int user_id, int theme) {
        final String query = "delete from tests " +
                "where user_id = '" + user_id + "' and theme_id = '" + theme + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(List<Test> testList) {
        for (Test test : testList) {
            String query = "insert into tests (user_id, theme_id, question_id, answer) " +
                    "values ('" + test.getUser_id() + "', '" + test.getTheme_id() + "', '" + test.getQuestion_id() +
                    "', '" + test.getAnswer() + "')";
            try (Statement st = connection.createStatement()) {
                st.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Test> findAllByUser_idAndTheme(int user_id, int theme_id, String lang) {
        Map<Integer, Test> tests = new HashMap<>();
        String query = "";
        if (lang.equals("ua")) {
            query = "select q.question_id, q.question, q.explanation, a.answer_id, a.answer_option, a.is_correct, " +
                    "t.id, case when t.answer is not null then 1 else 0 end as answer, " +
                    "case when a.is_correct = (case when t.answer is not null then 1 else 0 end) then 1 else 0 end as grade, " +
                    "t.user_id, q.theme_id, '' as theme, 0 as answers_count " +
                    "from answers a left outer join tests t on(a.question_id = t.question_id " +
                    "and a.answer_id = t.answer and t.user_id = '" + user_id + "') " +
                    "left outer join questions q on q.question_id = a.question_id " +
                    "where q.theme_id = '" + theme_id + "' " +
                    "order by a.question_id, a.answer_id";
        } else {
            query = "select q.question_id, q.question_en as question, q.explanation_en as explanation, " +
                    "a.answer_id, a.answer_option_en as answer_option, a.is_correct, " +
                    "t.id, case when t.answer is not null then 1 else 0 end as answer, " +
                    "case when a.is_correct = (case when t.answer is not null then 1 else 0 end) then 1 else 0 end as grade, " +
                    "t.user_id, q.theme_id, '' as theme, 0 as answers_count " +
                    "from answers a left outer join tests t on(a.question_id = t.question_id " +
                    "and a.answer_id = t.answer and t.user_id = '" + user_id + "') " +
                    "left outer join questions q on q.question_id = a.question_id " +
                    "where q.theme_id = '" + theme_id + "' " +
                    "order by a.question_id, a.answer_id";
        }
        int correct_answers = 0;
        int total_questions = 0;
        Test test = null;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            TestMapper testMapper = new TestMapper();
            while (rs.next()) {
                test = testMapper
                        .extractFromResultSet(rs);
                test = testMapper
                        .makeUnique(tests, test);
                total_questions++;

                List<Answer> answers = test.getAnswers();
                if (answers == null) {
                    answers = new ArrayList<Answer>();
                    test.setAnswers(answers);
                }
                if (rs.getInt("answer_id") != 0) {
                    Answer answer = new Answer();
                    answer.setQuestion_id(rs.getInt("question_id"));
                    answer.setAnswer_id(rs.getInt("answer_id"));
                    answer.setAnswer_option(rs.getString("answer_option"));
                    answer.setIs_correct(rs.getInt("is_correct"));
                    int grade = rs.getInt("grade");
                    answer.setGrade(grade);
                    answer.setAnswer(rs.getInt("answer"));
                    correct_answers += grade;

                    Test t = tests.get(rs.getInt("question_id"));
                    if (t != null) {
                        t.getAnswers().add(answer);
                        int answers_count = t.getAnswers_count();
                        answers_count++;
                        t.setAnswers_count(answers_count);
                    }
                }
            }
            rs.close();

            Statistics statistics = new Statistics();
            statistics.setUser_id(user_id);
            statistics.setTheme_id(theme_id);
            statistics.setTheme(test.getTheme());
            statistics.setCorrect_answers(correct_answers);
            statistics.setTotal_questions(total_questions);
            int total_grade = (int) Math.round((float) correct_answers * 100 / total_questions);
            statistics.setGrade(total_grade);
            java.util.Date date = new java.util.Date();
            SimpleDateFormat date_format = new SimpleDateFormat(" yyyy-MM-dd hh:mm:ss");
            statistics.setTest_date(date_format.format(date));
            StatisticsService statisticsService = new StatisticsService();
            statisticsService.deletePreviousStatistics(user_id, theme_id);
            statisticsService.createStatistics(statistics);

            TestService testService = new TestService();
            testService.sendEmail(statistics, lang);
            return new ArrayList<>(tests.values());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void sendEmail(Statistics statistics, String lang) {
        int user_id = statistics.getUser_id();
        int theme_id = statistics.getTheme_id();
        String subject = "";
        String text = "";
        if (lang.equals("ua")) {
            subject = "Результат тесту по темі \"" + statistics.getTheme() + "\"";
            text = "Шановний студент! \n\nВаш результат тесту по темі \"" + theme + "\":\n" +
                    "Правильних відповідей: " + statistics.getCorrect_answers() + "\n" +
                    "Всього питань: " + statistics.getTotal_questions() + "\n" +
                    "Оцінка: " + statistics.getGrade() + "%.";
        } else {
            subject = "Test result on the theme \"" + statistics.getTheme() + "\"";
            text = "Dear student! \n\nYour test result on the theme \"" + theme + "\" is:\n" +
                    "Correct answers: " + statistics.getCorrect_answers() + "\n" +
                    "Total questions: " + statistics.getTotal_questions() + "\n" +
                    "Grade: " + statistics.getGrade() + "%.";
        }
        Email email = new Email(to, subject, text);
        email.sendEmail();
    }

    @Override
    public void create(Test entity) {
    }

    @Override
    public Test findById(int id) {
        return null;
    }

    @Override
    public List<Test> findAll() {
        return null;
    }

    @Override
    public void update(Test entity) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
