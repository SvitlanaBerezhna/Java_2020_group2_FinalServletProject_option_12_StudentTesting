package ua.testing.model.dao.mapper;

import ua.testing.model.entity.Answer;

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
public class AnswerMapper implements ObjectMapper<Answer> {

    @Override
    public Answer extractFromResultSet(ResultSet rs) throws SQLException {
        Answer answer = new Answer();
        answer.setQuestion_id(rs.getInt("question_id"));
        answer.setAnswer_id(rs.getInt("answer_id"));
        answer.setQuestion(rs.getString("question"));
        answer.setQuestion_en(rs.getString("question_en"));
        answer.setAnswer_option(rs.getString("answer_option"));
        answer.setIs_correct(rs.getInt("is_correct"));
        answer.setGrade(rs.getInt("grade"));
        answer.setAnswer_option_en(rs.getString("answer_option_en"));
        answer.setAnswer(rs.getInt("answer"));
        return answer;
    }

    @Override
    public Answer makeUnique(Map<Integer, Answer> cache, Answer answer) {
        cache.putIfAbsent(answer.getAnswer_id(), answer);
        return cache.get(answer.getAnswer_id());
    }
}
