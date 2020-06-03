package ua.testing.model.dao.impl;

import ua.testing.model.dao.ThemeDao;
import ua.testing.model.dao.mapper.ThemeMapper;
import ua.testing.model.entity.Theme;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class JDBCThemeDao implements ThemeDao {
    private Connection connection;

    public JDBCThemeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Theme entity) {
        final String query = "insert into themes(theme, theme_en, description, description_en, time, passing_grade) " +
                "values ('" + entity.getTheme() + "', '" + entity.getTheme_en() + "', '" + entity.getDescription() + "', '" +
                entity.getDescription_en() + "', '" + entity.getTime() + "', '" + entity.getPassing_grade() + "')";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Theme findById(int id) {
        final String query = "select * from themes where id='" + id + "'";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            ThemeMapper themeMapper = new ThemeMapper();
            rs.next();
            Theme theme = themeMapper
                    .extractFromResultSet(rs);
            return theme;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Theme> findAll() {
        return null;
    }

    @Override
    public List<Theme> findAll(String lang) {
        Map<Integer, Theme> themes = new HashMap<>();
        String query = "";
        if (lang.equals("ua")) {
            query = "select id, theme, description, time, passing_grade, '' as theme_en, '' as description_en " +
                    "from themes " +
                    "order by theme";
        } else {
            query = "select id, theme_en as theme, description_en as description, time, passing_grade, " +
                    "'' as theme_en, '' as description_en " +
                    "from themes " +
                    "order by theme_en";
        }
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            ThemeMapper themeMapper = new ThemeMapper();
            while (rs.next()) {
                Theme theme = themeMapper
                        .extractFromResultSet(rs);
                theme = themeMapper
                        .makeUnique(themes, theme);
            }
            rs.close();
            return new ArrayList<>(themes.values());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(Theme entity) {
        final String query = "update themes set theme='" + entity.getTheme() + "', theme_en='" + entity.getTheme_en() +
                "', description='" + entity.getDescription() + "', description_en='" + entity.getDescription_en() +
                "', time='" + entity.getTime() + "', passing_grade='" + entity.getPassing_grade() + "' " +
                "where id='" + entity.getId() + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String query = "delete from themes " +
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
}
