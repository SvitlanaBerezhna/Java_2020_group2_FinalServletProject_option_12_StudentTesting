package ua.testing.model.dao.impl;

import ua.testing.model.dao.QuestionDao;
import ua.testing.model.dao.mapper.QuestionMapper;
import ua.testing.model.entity.Answer;
import ua.testing.model.entity.Question;

import java.sql.*;
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
public class JDBCQuestionDao implements QuestionDao {
    private Connection connection;

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Question entity) {
        final String query = "insert into questions(theme_id, question, " +
                "question_en, explanation, explanation_en) " +
                "values ('" + entity.getTheme_id() + "', '" + entity.getQuestion() + "', '" +
                entity.getQuestion_en() + "', '" +
                entity.getExplanation() + "', '" + entity.getExplanation_en() + "')";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Question findById(int id) {
        final String query = "select q.question_id, t.id as theme_id, t.theme, q.question, q.explanation, " +
                "q.explanation_en, q.question_en, t.theme_en, 0 as answers_count, 0 as time " +
                "from questions q " +
                "left join themes t on q.theme_id = t.id " +
                "where q.question_id = '" + id + "'";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            QuestionMapper questionMapper = new QuestionMapper();
            rs.next();
            Question question = questionMapper
                    .extractFromResultSet(rs);
            return question;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public List<Question> findAllByTheme(int theme_id, String lang) {
        Map<Integer, Question> questions = new HashMap<>();
        String query = "";
        if (lang.equals("ua")) {
            query = "select q.question_id, t.id as theme_id, t.theme, q.question, q.explanation, '' as question_en, " +
                    "'' as explanation_en, a.answer_id, a.answer_option, a.is_correct, '' as theme_en, " +
                    "'' as answer_option_en, 0 as answers_count, t.time " +
                    "from questions q " +
                    "left join themes t on q.theme_id = t.id " +
                    "left join answers a on a.question_id=q.question_id ";
        } else {
            query = "select q.question_id, t.id as theme_id, t.theme_en as theme, q.question_en as question, " +
                    "q.explanation_en as explanation, '' as question_en, '' as explanation_en, a.answer_id, " +
                    "a.answer_option_en as answer_option, a.is_correct, '' as theme_en, '' as answer_option_en, " +
                    "0 as answers_count, t.time " +
                    "from questions q " +
                    "left join themes t on q.theme_id = t.id " +
                    "left join answers a on a.question_id=q.question_id ";
        }
        if (theme_id != 0) {
            query += "where q.theme_id = '" + theme_id + "' ";
        }
        query += "order by q.theme_id asc, q.question_id, a.answer_id";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            QuestionMapper questionMapper = new QuestionMapper();
            while (rs.next()) {
                Question question = questionMapper
                        .extractFromResultSet(rs);
                question = questionMapper
                        .makeUnique(questions, question);
                List<Answer> answers = question.getAnswers();
                if (answers == null) {
                    answers = new ArrayList<Answer>();
                    question.setAnswers(answers);
                }
                if (rs.getInt("answer_id") != 0) {
                    Answer answer = new Answer();
                    answer.setQuestion_id(rs.getInt("question_id"));
                    answer.setAnswer_id(rs.getInt("answer_id"));
                    answer.setAnswer_option(rs.getString("answer_option"));
                    answer.setIs_correct(rs.getInt("is_correct"));

                    Question q = questions.get(rs.getInt("question_id"));
                    if (q != null) {
                        q.getAnswers().add(answer);
                        int answers_count = q.getAnswers_count();
                        answers_count++;
                        q.setAnswers_count(answers_count);
                    }
                }
            }
            rs.close();
            return new ArrayList<>(questions.values());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(Question entity) {
        final String query = "update questions set theme_id='" + entity.getTheme_id() + "', question='" +
                entity.getQuestion() + "', question_en='" + entity.getQuestion_en() + "', explanation='" +
                entity.getExplanation() + "', explanation_en='" + entity.getExplanation_en() + "' " +
                "where question_id='" + entity.getQuestion_id() + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String query = "delete from questions " +
                "where question_id='" + id + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
