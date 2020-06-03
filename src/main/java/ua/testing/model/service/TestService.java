package ua.testing.model.service;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.TestDao;
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
public class TestService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void deletePreviousTestResult(int user_id, int theme) {
        try (TestDao dao = daoFactory.createTestDao()) {
            dao.delete(user_id, theme);
        }
    }

    public void addCurrentTestResult(List<Test> testList) {
        try (TestDao dao = daoFactory.createTestDao()) {
            dao.create(testList);
        }
    }

    public List<Test> getResultTest(int user_id, int theme_id, String lang) {
        try (TestDao dao = daoFactory.createTestDao()) {
            return dao.findAllByUser_idAndTheme(user_id, theme_id, lang);
        }
    }

    public void sendEmail(Statistics statistics, String lang) {
        try (TestDao dao = daoFactory.createTestDao()) {
            dao.sendEmail(statistics, lang);
        }
    }
}
