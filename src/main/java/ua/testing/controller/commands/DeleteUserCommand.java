package ua.testing.controller.commands;

import ua.testing.model.entity.User;
import ua.testing.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class DeleteUserCommand implements Command {
    private UserService userService;

    public DeleteUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
        }
        return "WEB-INF/jsp/users_read.jsp";
    }
}
