package ua.testing.model.dao;

import ua.testing.model.entity.Theme;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface ThemeDao extends GenericDao<Theme> {
    List<Theme> findAll(String lang);

    Theme findById(int id);
}
