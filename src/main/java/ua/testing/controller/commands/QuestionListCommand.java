package ua.testing.controller.commands;

import ua.testing.model.entity.Question;
import ua.testing.model.service.QuestionService;

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
public class QuestionListCommand implements Command {
    private QuestionService questionService;

    public QuestionListCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int theme_id = 0;
        if (request.getParameter("id") != null) {
            theme_id = Integer.parseInt(request.getParameter("id"));
        }
        String lang = (String) session.getAttribute("lang");
        List<Question> questions = questionService.getAllQuestionsByTheme(theme_id, lang);
        request.setAttribute("questionList", questions);
        return "/WEB-INF/jsp/questions_read.jsp";
    }
}
