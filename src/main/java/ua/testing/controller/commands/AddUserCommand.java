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
public class AddUserCommand implements Command {
    private UserService userService;

    public AddUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return "WEB-INF/jsp/user_create.jsp";
        } else {
            User user = new User();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setFirst_name(request.getParameter("first_name"));
            user.setLast_name(request.getParameter("last_name"));
            user.setGrade(Integer.parseInt(request.getParameter("grade")));
            user.setRole(request.getParameter("role"));
            user.setFirst_name_en(request.getParameter("first_name_en"));
            user.setLast_name_en(request.getParameter("last_name_en"));
            userService.createUser(user);
            return "WEB-INF/jsp/users_read.jsp";
        }
    }
}
