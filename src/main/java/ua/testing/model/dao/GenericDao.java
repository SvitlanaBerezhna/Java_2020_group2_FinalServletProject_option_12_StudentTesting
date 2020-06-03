package ua.testing.model.dao;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface GenericDao<T> extends AutoCloseable {
    void create(T entity);

    T findById(int id);

    List<T> findAll();

    void update(T entity);

    void delete(int id);

    void close();
}
