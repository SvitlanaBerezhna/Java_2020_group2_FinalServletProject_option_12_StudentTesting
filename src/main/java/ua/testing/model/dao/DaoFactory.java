package ua.testing.model.dao;

import ua.testing.model.dao.impl.JDBCDaoFactory;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public abstract ThemeDao createThemeDao();

    public abstract QuestionDao createQuestionDao();

    public abstract AnswerDao createAnswerDao();

    public abstract TestDao createTestDao();

    public abstract StatisticsDao createStatisticsDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
