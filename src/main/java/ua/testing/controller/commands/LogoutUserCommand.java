package ua.testing.controller.commands;

import ua.testing.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class LogoutUserCommand implements Command {
    private UserService userService;

    public LogoutUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("msg", "");
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "WEB-INF/index.jsp";
    }
}
