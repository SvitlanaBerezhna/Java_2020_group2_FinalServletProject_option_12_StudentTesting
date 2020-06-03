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
public class DeleteThemeCommand implements Command {
    private ThemeService themeService;

    public DeleteThemeCommand(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Theme theme = themeService.getThemeById(id);
        if (theme != null) {
            themeService.deleteTheme(id);
        }
        return "WEB-INF/jsp/themes_read.jsp";
    }
}
