package ua.testing.model.service;

import ua.testing.model.dao.DaoFactory;
import ua.testing.model.dao.ThemeDao;
import ua.testing.model.entity.Theme;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class ThemeService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Theme> getAllThemes(String lang) {
        try (ThemeDao dao = daoFactory.createThemeDao()) {
            return dao.findAll(lang);
        }
    }

    public void createTheme(Theme theme) {
        try (ThemeDao dao = daoFactory.createThemeDao()) {
            dao.create(theme);
        }
    }

    public Theme getThemeById(int id) {
        try (ThemeDao dao = daoFactory.createThemeDao()) {
            return dao.findById(id);
        }
    }

    public void updateTheme(Theme theme) {
        try (ThemeDao dao = daoFactory.createThemeDao()) {
            dao.update(theme);
        }
    }

    public void deleteTheme(int id) {
        try (ThemeDao dao = daoFactory.createThemeDao()) {
            dao.delete(id);
        }
    }
}
