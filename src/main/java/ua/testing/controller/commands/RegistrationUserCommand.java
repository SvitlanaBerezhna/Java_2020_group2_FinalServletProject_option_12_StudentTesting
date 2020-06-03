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
public class RegistrationUserCommand implements Command {
    private UserService userService;

    public RegistrationUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return "WEB-INF/jsp/user_registration.jsp";
        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (userService.getUserByEmailAndPassword(email, password) == null) {
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setFirst_name(request.getParameter("first_name"));
                user.setLast_name(request.getParameter("last_name"));
                user.setGrade(0);
                user.setRole("user");
                user.setFirst_name_en(request.getParameter("first_name_en"));
                user.setLast_name_en(request.getParameter("last_name_en"));
                userService.registrateUser(user);
            }
            return "/";
        }
    }
}
