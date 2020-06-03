package ua.testing.model.dao;

import ua.testing.model.entity.Answer;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface AnswerDao extends GenericDao<Answer> {
    List<Answer> findAllByQuestion(int question_id, String lang);

    Answer findById(int answer_id);
}
