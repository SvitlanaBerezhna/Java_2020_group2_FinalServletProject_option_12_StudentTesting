package ua.testing.model.service;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.AnswerDao;
import ua.testing.model.entity.Answer;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class AnswerService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Answer> getAllAnswersByQuestion(int question_id, String lang) {
        try (AnswerDao dao = daoFactory.createAnswerDao()) {
            return dao.findAllByQuestion(question_id, lang);
        }
    }

    public void createAnswer(Answer answer) {
        try (AnswerDao dao = daoFactory.createAnswerDao()) {
            dao.create(answer);
        }
    }

    public Answer getAnswerById(int answer_id) {
        try (AnswerDao dao = daoFactory.createAnswerDao()) {
            return dao.findById(answer_id);
        }
    }

    public void updateAnswer(Answer answer) {
        try (AnswerDao dao = daoFactory.createAnswerDao()) {
            dao.update(answer);
        }
    }

    public void deleteAnswer(int answer_id) {
        try (AnswerDao dao = daoFactory.createAnswerDao()) {
            dao.delete(answer_id);
        }
    }
}
