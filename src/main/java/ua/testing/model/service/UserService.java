package ua.testing.model.service;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.UserDao;
import ua.testing.model.entity.User;
import ua.testing.utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<User> login(String email, String password) {
        Optional<User> user;
        try (UserDao userDao = daoFactory.createUserDao()) {
            user = userDao.findByEmailAndPassword(email, password);
        }
        return user;
    }

    public List<User> getAllUsers(String lang) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll(lang);
        }
    }

    public void registrateUser(User user) {
        final String query = "insert into users(email, password, first_name, first_name_en, last_name, last_name_en, grade, role) " +
                "values ('" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getFirst_name() + "', '" +
                user.getFirst_name_en() + "', '" + user.getLast_name() + "', '" + user.getLast_name_en() + "', '" +
                user.getGrade() + "', '" + user.getRole() + "')";
        DatabaseConnection dbConn = new DatabaseConnection();
        PreparedStatement prepStat = dbConn.getPreparedStatement(query);
        try {
            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.create(user);
        }
    }

    public User getUserById(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        }
    }

    public void updateUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.update(user);
        }
    }

    public void deleteUser(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.delete(id);
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        String query = "select * from users where email=? and password=?";
        DatabaseConnection dbConn = new DatabaseConnection();
        PreparedStatement prepStat = dbConn.getPreparedStatement(query);
        try {
            prepStat.setString(1, email);
            prepStat.setString(2, password);
            ResultSet rs = prepStat.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirst_name(rs.getString("first_name"));
                user.setFirst_name_en(rs.getString("first_name_en"));
                user.setLast_name(rs.getString("last_name"));
                user.setLast_name_en(rs.getString("last_name_en"));
                user.setGrade(rs.getInt("grade"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
