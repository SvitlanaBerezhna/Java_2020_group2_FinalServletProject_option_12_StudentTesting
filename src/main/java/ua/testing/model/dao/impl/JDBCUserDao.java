package ua.testing.model.dao.impl;

import ua.testing.model.dao.UserDao;
import ua.testing.model.dao.mapper.UserMapper;
import ua.testing.model.entity.User;

import java.sql.*;
import java.util.*;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        final String query = "insert into users(email, password, first_name, first_name_en, last_name, last_name_en, grade, role) " +
                "values ('" + entity.getEmail() + "', '" + entity.getPassword() + "', '" + entity.getFirst_name() + "', '" +
                entity.getFirst_name_en() + "', '" + entity.getLast_name() + "', '" + entity.getLast_name_en() + "', '" +
                entity.getGrade() + "', '" + entity.getRole() + "')";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        final String query = "select * from users where id='" + id + "'";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            UserMapper userMapper = new UserMapper();
            rs.next();
            User user = userMapper
                    .extractFromResultSet(rs);
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        Optional<User> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall("select * from users where email = ? and password = ?")) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(String lang) {
        Map<Integer, User> users = new HashMap<>();
        String query = "";
        if (lang.equals("ua")) {
            query = "select id, email, password, first_name, last_name, grade, role, '' as first_name_en, " +
                    "'' as last_name_en " +
                    "from users";
        } else {
            query = "select id, email, password, first_name_en as first_name, last_name_en as last_name, grade, role, " +
                    "'' as first_name_en, '' as last_name_en " +
                    "from users";
        }
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            UserMapper userMapper = new UserMapper();
            while (rs.next()) {
                User user = userMapper
                        .extractFromResultSet(rs);
                user = userMapper
                        .makeUnique(users, user);
            }
            return new ArrayList<>(users.values());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(User entity) {
        final String query = "update users set email='" + entity.getEmail() + "', password='" + entity.getPassword() +
                "', first_name='" + entity.getFirst_name() + "', last_name='" + entity.getLast_name() + "', grade='" +
                entity.getGrade() + "', role='" + entity.getRole() + "', first_name_en='" +
                entity.getFirst_name_en() + "', last_name_en='" + entity.getLast_name_en() + "' " +
                "where id='" + entity.getId() + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String query = "delete from users " +
                "where id='" + id + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByName(String name) {
        Optional<User> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall("select * from users where name = ?")) {
            ps.setString(1, name);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
