package ua.testing.model.dao.mapper;

import ua.testing.model.entity.Theme;

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
public class ThemeMapper implements ObjectMapper<Theme> {

    @Override
    public Theme extractFromResultSet(ResultSet rs) throws SQLException {
        Theme theme = new Theme();
        theme.setId(rs.getInt("id"));
        theme.setTheme(rs.getString("theme"));
        theme.setTheme_en(rs.getString("theme_en"));
        theme.setDescription(rs.getString("description"));
        theme.setDescription_en(rs.getString("description_en"));
        theme.setTime(rs.getInt("time"));
        theme.setPassing_grade(rs.getInt("passing_grade"));
        return theme;
    }

    @Override
    public Theme makeUnique(Map<Integer, Theme> cache, Theme theme) {
        cache.putIfAbsent(theme.getId(), theme);
        return cache.get(theme.getId());
    }
}
