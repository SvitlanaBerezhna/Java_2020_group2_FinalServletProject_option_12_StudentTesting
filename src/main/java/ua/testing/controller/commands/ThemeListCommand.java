package ua.testing.controller.commands;

import ua.testing.model.entity.Theme;
import ua.testing.model.service.ThemeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class ThemeListCommand implements Command {
    private ThemeService themeService;

    public ThemeListCommand(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String lang = (String) session.getAttribute("lang");
        List<Theme> themes = themeService.getAllThemes(lang);
        request.setAttribute("themeList", themes);
        return "/WEB-INF/jsp/themes_read.jsp";
    }
}
