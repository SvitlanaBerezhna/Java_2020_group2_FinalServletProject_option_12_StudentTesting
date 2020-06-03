package ua.testing.model.dao.mapper;

import ua.testing.model.entity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class TestMapper implements ObjectMapper<Test> {

    @Override
    public Test extractFromResultSet(ResultSet rs) throws SQLException {
        Test test = new Test();
        test.setId(rs.getInt("id"));
        test.setQuestion_id(rs.getInt("question_id"));
        test.setQuestion(rs.getString("question"));
        test.setExplanation(rs.getString("explanation"));
        test.setAnswer_id(rs.getInt("answer_id"));
        test.setAnswer_option(rs.getString("answer_option"));
        test.setIs_correct(rs.getInt("is_correct"));
        test.setAnswer(rs.getInt("answer"));
        test.setUser_id(rs.getInt("user_id"));
        test.setTheme_id(rs.getInt("theme_id"));
        test.setTheme(rs.getString("theme"));
        test.setAnswers_count(rs.getInt("answers_count"));
        return test;
    }

    @Override
    public Test makeUnique(Map<Integer, Test> cache, Test test) {
        cache.putIfAbsent(test.getQuestion_id(), test);
        return cache.get(test.getQuestion_id());
    }
}
