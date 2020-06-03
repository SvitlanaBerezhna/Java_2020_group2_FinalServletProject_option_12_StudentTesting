package ua.testing.model.dao.mapper;

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
public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet rs) throws SQLException;

    T makeUnique(Map<Integer, T> cache, T teacher);
}
