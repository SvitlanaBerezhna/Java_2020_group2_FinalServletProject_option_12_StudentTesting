package ua.testing.controller;

import ua.testing.controller.commands.Command;
import ua.testing.controller.commands.*;
import ua.testing.model.service.UserService;
import ua.testing.model.service.ThemeService;
import ua.testing.model.service.QuestionService;
import ua.testing.model.service.AnswerService;
import ua.testing.model.service.TestService;
import ua.testing.model.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class Servlet extends HttpServlet {
    private UserService userService = new UserService();
    private ThemeService themeService = new ThemeService();
    private QuestionService questionService = new QuestionService();
    private AnswerService answerService = new AnswerService();
    private TestService testService = new TestService();
    private StatisticsService statisticsService = new StatisticsService();

    private Map<String, Command> commands = new HashMap<>();

    public void init() {
        commands.put("userList", new UserListCommand(userService));
        commands.put("add-user", new AddUserCommand(userService));
        commands.put("edit-user", new EditUserCommand(userService));
        commands.put("delete-user", new DeleteUserCommand(userService));

        commands.put("registration", new RegistrationUserCommand(userService));
        commands.put("login", new LoginUserCommand(userService));
        commands.put("logout", new LogoutUserCommand(userService));

        commands.put("themeList", new ThemeListCommand(themeService));
        commands.put("add-theme", new AddThemeCommand(themeService));
        commands.put("edit-theme", new EditThemeCommand(themeService));
        commands.put("delete-theme", new DeleteThemeCommand(themeService));

        commands.put("questionList", new QuestionListCommand(questionService));
        commands.put("add-question", new AddQuestionCommand(questionService));
        commands.put("edit-question", new EditQuestionCommand(questionService));
        commands.put("delete-question", new DeleteQuestionCommand(questionService));

        commands.put("answerList", new AnswerListCommand(answerService));
        commands.put("add-answer", new AddAnswerCommand(answerService));
        commands.put("edit-answer", new EditAnswerCommand(answerService));
        commands.put("delete-answer", new DeleteAnswerCommand(answerService));

        commands.put("testChoice", new TestChoiceCommand(testService));
        commands.put("test", new TestPassingCommand(questionService));
        commands.put("result", new TestResultCommand(testService));

        commands.put("statisticsList", new StatisticsListCommand(statisticsService));

        commands.put("exception", new ExceptionCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, " +
                "pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);

        String path = request.getRequestURI();
        path = path.replaceAll(".*/TestingSystem_war_exploded/", "");
        Command command = commands.getOrDefault(path, (r) -> "/index.jsp)");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
        } else {
            String page = command.execute(request);
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, " +
                "pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        String action = request.getParameter("action");
        Command command = commands.getOrDefault(action, (r) -> "/index.jsp)");
        command.execute(request);

        String path = request.getRequestURI();
        path = path.replaceAll(".*/TestingSystem_war_exploded/", "");
        command = commands.getOrDefault(path, (r) -> "/index.jsp)");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
        } else {
            String page = command.execute(request);
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
