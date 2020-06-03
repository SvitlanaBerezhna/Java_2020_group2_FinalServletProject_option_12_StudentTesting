package ua.testing.model.dao.mapper;

import ua.testing.model.entity.Question;

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
public class QuestionMapper implements ObjectMapper<Question> {

    @Override
    public Question extractFromResultSet(ResultSet rs) throws SQLException {
        Question question = new Question();
        question.setTheme_id(rs.getInt("theme_id"));
        question.setQuestion_id(rs.getInt("question_id"));
        question.setTheme(rs.getString("theme"));
        question.setQuestion(rs.getString("question"));
        question.setExplanation(rs.getString("explanation"));
        question.setQuestion_en(rs.getString("question_en"));
        question.setExplanation_en(rs.getString("explanation_en"));
        question.setAnswers_count(rs.getInt("answers_count"));
        question.setTime(rs.getInt("time"));
        return question;
    }

    @Override
    public Question makeUnique(Map<Integer, Question> cache, Question question) {
        cache.putIfAbsent(question.getQuestion_id(), question);
        return cache.get(question.getQuestion_id());
    }
}
