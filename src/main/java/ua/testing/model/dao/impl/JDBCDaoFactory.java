package ua.testing.model.dao.impl;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.UserDao;
import ua.testing.model.dao.ThemeDao;
import ua.testing.model.dao.QuestionDao;
import ua.testing.model.dao.AnswerDao;
import ua.testing.model.dao.TestDao;
import ua.testing.model.dao.StatisticsDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public ThemeDao createThemeDao() {
        return new JDBCThemeDao(getConnection());
    }

    @Override
    public QuestionDao createQuestionDao() {
        return new JDBCQuestionDao(getConnection());
    }

    public AnswerDao createAnswerDao() {
        return new JDBCAnswerDao(getConnection());
    }

    @Override
    public TestDao createTestDao() {
        return new JDBCTestDao(getConnection());
    }

    @Override
    public StatisticsDao createStatisticsDao() {
        return new JDBCStatisticsDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
