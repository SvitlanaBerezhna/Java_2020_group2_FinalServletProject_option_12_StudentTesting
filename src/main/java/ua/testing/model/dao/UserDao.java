package ua.testing.model.dao;

import ua.testing.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface UserDao extends GenericDao<User> {
    Optional<User> findByName(String name);

    List<User> findAll(String lang);

    User findById(int id);

    Optional<User> findByEmailAndPassword(String email, String password);
}
