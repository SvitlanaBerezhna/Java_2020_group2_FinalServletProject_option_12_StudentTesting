package ua.testing.model.service;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.QuestionDao;
import ua.testing.model.entity.Question;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class QuestionService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Question> getAllQuestionsByTheme(int theme_id, String lang) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            return dao.findAllByTheme(theme_id, lang);
        }
    }

    public void createQuestion(Question question) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            dao.create(question);
        }
    }

    public Question getQuestionById(int id) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            return dao.findById(id);
        }
    }

    public void updateQuestion(Question question) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            dao.update(question);
        }
    }

    public void deleteQuestion(int id) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            dao.delete(id);
        }
    }
}
