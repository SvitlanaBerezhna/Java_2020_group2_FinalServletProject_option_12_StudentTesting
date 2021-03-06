package ua.testing.controller.commands;

import ua.testing.config.Regex;
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
public class EditUserCommand implements Command {
    private UserService userService;

    public EditUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.getUserById(id);
            request.setAttribute("user", user);
            return "WEB-INF/jsp/user_update.jsp";
        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            boolean correct = true;
            if (email.trim().isEmpty()) {
                request.setAttribute("msg_email", "Email is empty");
                correct = false;
            } else if (!email.matches(Regex.EMAIL_REGEX)) {
                request.setAttribute("msg_email", "Invalid email");
                correct = false;
            }
            if (password.trim().isEmpty()) {
                request.setAttribute("msg_password", "Password is empty");
                correct = false;
            }
            if (correct) {
                User user = new User();
                user.setId(Integer.parseInt(request.getParameter("id")));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                user.setFirst_name(request.getParameter("first_name"));
                user.setLast_name(request.getParameter("last_name"));
                user.setGrade(Integer.parseInt(request.getParameter("grade")));
                user.setRole(request.getParameter("role"));
                user.setFirst_name_en(request.getParameter("first_name_en"));
                user.setLast_name_en(request.getParameter("last_name_en"));
                userService.updateUser(user);
                return "WEB-INF/jsp/users_read.jsp";
            }
            return "WEB-INF/jsp/user_update.jsp";
        }
    }
}
