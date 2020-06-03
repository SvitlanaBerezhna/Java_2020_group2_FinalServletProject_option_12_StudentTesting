package ua.testing.controller.commands;

import ua.testing.config.Regex;
import ua.testing.model.entity.User;
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
public class LoginUserCommand implements Command {
    private UserService userService;

    public LoginUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("POST")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.getUserById(id);
            request.setAttribute("user", user);
            return "WEB-INF/jsp/user_update.jsp";
        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            boolean correct = true;
            if (!email.matches(Regex.EMAIL_REGEX)) {
                request.setAttribute("msg_email", "Invalid email");
                correct = false;
            }
            if (!correct) {
                return "";
            }
            User user = userService.getUserByEmailAndPassword(email, password);
            if (user == null) {
                request.setAttribute("msg", "Invalid email or password");
                return "";
            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                session.setAttribute("email", email);
                request.setAttribute("userName", email);
                String lang = request.getParameter("lang");
                session.setAttribute("lang", lang);
                request.setAttribute("email", "");
                request.setAttribute("msg", "");
                return "WEB-INF/jsp/home.jsp";
            }
        }
    }
}
