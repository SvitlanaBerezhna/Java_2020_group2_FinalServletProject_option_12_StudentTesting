package ua.testing.model.dao;

import ua.testing.model.entity.Statistics;
import ua.testing.model.entity.Test;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface TestDao extends GenericDao<Test> {
    void delete(int user_id, int theme);

    void create(List<Test> testList);

    List<Test> findAllByUser_idAndTheme(int user_id, int theme_id, String lang);

    void sendEmail(Statistics statistics, String lang);
}
