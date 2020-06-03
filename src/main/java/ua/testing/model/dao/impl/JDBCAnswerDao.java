package ua.testing.model.dao.impl;

import ua.testing.model.dao.AnswerDao;
import ua.testing.model.dao.mapper.AnswerMapper;
import ua.testing.model.entity.Answer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class JDBCAnswerDao implements AnswerDao {
    private Connection connection;

    public JDBCAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Answer entity) {
        final String query = "insert into answers(question_id, answer_option, answer_option_en, is_correct) " +
                "values ('" + entity.getQuestion_id() + "', '" + entity.getAnswer_option() + "', '" +
                entity.getAnswer_option_en() + "', '" + entity.getIs_correct() + "')";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Answer findById(int answer_id) {
        final String query = "select a.answer_id, a.question_id, q.question, a.answer_option, a.is_correct, " +
                "'' as question_en, a.answer_option_en, 0 as grade, 0 as answer " +
                "from answers a " +
                "left join questions q on a.question_id = q.question_id " +
                "where a.answer_id = '" + answer_id + "'";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            AnswerMapper answerMapper = new AnswerMapper();
            rs.next();
            Answer answer = answerMapper
                    .extractFromResultSet(rs);
            return answer;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Answer> findAll() {
        return null;
    }

    @Override
    public List<Answer> findAllByQuestion(int question_id, String lang) {
        Map<Integer, Answer> answers = new HashMap<>();
        String query = "";
        if (lang.equals("ua")) {
            query = "select a.answer_id, q.question_id, q.question, a.answer_option, a.is_correct, " +
                    "'' as question_en, '' as answer_option_en, 0 as grade, 0 as answer " +
                    "from answers a " +
                    "left join questions q on a.question_id = q.question_id ";
        } else {
            query = "select a.answer_id, q.question_id, q.question_en as question, a.answer_option_en as answer_option, " +
                    "a.is_correct, '' as question_en, '' as answer_option_en, 0 as grade, 0 as answer " +
                    "from answers a " +
                    "left join questions q on a.question_id = q.question_id ";
        }
        if (question_id != 0) {
            query += "where q.question_id = '" + question_id + "' ";
        }
        query += "order by a.question_id, a.answer_id";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            AnswerMapper answerMapper = new AnswerMapper();
            while (rs.next()) {
                Answer answer = answerMapper
                        .extractFromResultSet(rs);
                answer = answerMapper
                        .makeUnique(answers, answer);
            }
            rs.close();
            return new ArrayList<>(answers.values());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(Answer entity) {
        final String query = "update answers set question_id='" + entity.getQuestion_id() +
                "', answer_option='" + entity.getAnswer_option() + "', is_correct='" + entity.getIs_correct() +
                "', answer_option_en='" + entity.getAnswer_option_en() + "' " +
                "where answer_id='" + entity.getAnswer_id() + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int answer_id) {
        final String query = "delete from answers " +
                "where answer_id='" + answer_id + "'";
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
