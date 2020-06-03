package ua.testing.model.dao.mapper;

import ua.testing.model.entity.Statistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class StatisticsMapper implements ObjectMapper<Statistics> {

    @Override
    public Statistics extractFromResultSet(ResultSet rs) throws SQLException {
        Statistics statistics = new Statistics();
        statistics.setId(rs.getInt("id"));
        statistics.setUser_id(rs.getInt("user_id"));
        statistics.setTheme_id(rs.getInt("theme_id"));
        statistics.setTheme(rs.getString("theme"));
        statistics.setCorrect_answers(rs.getInt("correct_answers"));
        statistics.setTotal_questions(rs.getInt("total_questions"));
        statistics.setGrade(rs.getInt("grade"));
        statistics.setTest_date(rs.getString("test_date"));
        statistics.setEmail(rs.getString("email"));
        statistics.setFirst_name(rs.getString("first_name"));
        statistics.setLast_name(rs.getString("last_name"));
        return statistics;
    }

    @Override
    public Statistics makeUnique(Map<Integer, Statistics> cache, Statistics statistics) {
        cache.putIfAbsent(statistics.getId(), statistics);
        return cache.get(statistics.getId());
    }
}
