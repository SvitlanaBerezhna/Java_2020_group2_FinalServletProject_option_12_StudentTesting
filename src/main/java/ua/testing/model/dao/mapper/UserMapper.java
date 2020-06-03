package ua.testing.model.dao.mapper;

import ua.testing.model.entity.User;

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
public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFirst_name(rs.getString("first_name"));
        user.setFirst_name_en(rs.getString("first_name_en"));
        user.setLast_name(rs.getString("last_name"));
        user.setLast_name_en(rs.getString("last_name_en"));
        user.setGrade(rs.getInt("grade"));
        user.setRole(rs.getString("role"));
        return user;
    }

    public User makeUnique(Map<Integer, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }
}
