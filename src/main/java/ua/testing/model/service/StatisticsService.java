package ua.testing.model.service;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.StatisticsDao;
import ua.testing.model.entity.Statistics;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class StatisticsService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Statistics> getAllStatistics(String lang) {
        try (StatisticsDao dao = daoFactory.createStatisticsDao()) {
            return dao.findAll(lang);
        }
    }

    public void createStatistics(Statistics statistics) {
        try (StatisticsDao dao = daoFactory.createStatisticsDao()) {
            dao.create(statistics);
        }
    }

    public void deletePreviousStatistics(int user_id, int theme) {
        try (StatisticsDao dao = daoFactory.createStatisticsDao()) {
            dao.delete(user_id, theme);
        }
    }
}
