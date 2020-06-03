package ua.testing.controller.commands;

import ua.testing.model.entity.Theme;
import ua.testing.model.service.ThemeService;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class AddThemeCommand implements Command {
    private ThemeService themeService;

    public AddThemeCommand(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return "WEB-INF/jsp/theme_create.jsp";
        } else {
            Theme theme = new Theme();
            theme.setTheme(request.getParameter("theme"));
            theme.setTheme_en(request.getParameter("theme_en"));
            theme.setDescription(request.getParameter("description"));
            theme.setDescription_en(request.getParameter("description_en"));
            String time = request.getParameter("time");
            if (time.trim().length() != 0) {
                theme.setTime(Integer.parseInt(time));
            }
            String passing_grade = request.getParameter("passing_grade");
            if (passing_grade.trim().length() != 0) {
                theme.setPassing_grade(Integer.parseInt(passing_grade));
            }
            themeService.createTheme(theme);
            return "WEB-INF/jsp/themes_read.jsp";
        }
    }
}
