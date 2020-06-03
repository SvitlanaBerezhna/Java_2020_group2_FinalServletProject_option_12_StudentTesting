package ua.testing.model.dao;

import ua.testing.model.entity.Question;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface QuestionDao extends GenericDao<Question> {
    List<Question> findAllByTheme(int theme_id, String lang);

    Question findById(int id);
}
