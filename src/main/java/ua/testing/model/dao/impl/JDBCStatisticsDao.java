package ua.testing.model.dao.impl;

import ua.testing.model.dao.StatisticsDao;
import ua.testing.model.dao.mapper.StatisticsMapper;
import ua.testing.model.entity.Statistics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class JDBCStatisticsDao implements StatisticsDao {
    private Connection connection;

    public JDBCStatisticsDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Statistics entity) {
        final String query = "insert into statistics(user_id, theme_id, correct_answers, total_questions, grade, test_date) " +
                "values ('" + entity.getUser_id() + "', '" + entity.getTheme_id() + "', '" + entity.getCorrect_answers() +
                "', '" + entity.getTotal_questions() + "', '" + entity.getGrade() + "', '" + entity.getTest_date() + "')";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Statistics findById(int id) {
        return null;
    }

    @Override
    public List<Statistics> findAll() {
        return null;
    }

    @Override
    public List<Statistics> findAll(String lang) {
        Map<Integer, Statistics> statisticsList = new HashMap<>();
        String query = "";
        if (lang.equals("ua")) {
            query = "select s.id, s.user_id, s.theme_id, t.theme, s.correct_answers, s.total_questions, s.grade, " +
                    "s.test_date, u.email, u.first_name, u.last_name, u.grade " +
                    "from statistics s left join themes t on s.theme_id = t.id " +
                    "left join users u on s.user_id = u.id " +
                    "order by u.email";
        } else {
            query = "select s.id, s.user_id, s.theme_id, t.theme_en as theme, s.correct_answers, s.total_questions, " +
                    "s.grade, s.test_date, u.email, u.first_name_en as first_name, u.last_name_en as last_name, u.grade " +
                    "from statistics s left join themes t on s.theme_id = t.id " +
                    "left join users u on s.user_id = u.id " +
                    "order by u.email";
        }
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            StatisticsMapper statisticsMapper = new StatisticsMapper();
            while (rs.next()) {
                Statistics statistics = statisticsMapper
                        .extractFromResultSet(rs);
                statistics = statisticsMapper
                        .makeUnique(statisticsList, statistics);
            }
            rs.close();
            return new ArrayList<>(statisticsList.values());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void delete(int user_id, int theme) {
        final String query = "delete from statistics " +
                "where user_id='" + user_id + "' and theme_id='" + theme + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Statistics entity) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
