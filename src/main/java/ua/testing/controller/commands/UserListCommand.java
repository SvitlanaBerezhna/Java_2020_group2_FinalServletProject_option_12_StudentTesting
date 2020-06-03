package ua.testing.controller.commands;

import ua.testing.model.entity.User;
import ua.testing.model.service.UserService;

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
public class UserListCommand implements Command {
    private UserService userService;

    public UserListCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String lang = (String) session.getAttribute("lang");
        List<User> users = userService.getAllUsers(lang);
        request.setAttribute("userList", users);
        return "/WEB-INF/jsp/users_read.jsp";
    }
}
