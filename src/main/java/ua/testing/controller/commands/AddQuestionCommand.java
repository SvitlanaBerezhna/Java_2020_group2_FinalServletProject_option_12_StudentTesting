package ua.testing.controller.commands;

import ua.testing.model.entity.Question;
import ua.testing.model.entity.Theme;
import ua.testing.model.service.QuestionService;
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
public class AddQuestionCommand implements Command {
    private QuestionService questionService;

    public AddQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            HttpSession session = request.getSession();
            String lang = (String) session.getAttribute("lang");
            ThemeService themeService = new ThemeService();
            List<Theme> themes = themeService.getAllThemes(lang);
            request.setAttribute("themeList", themes);
            return "WEB-INF/jsp/question_create.jsp";
        } else {
            Question question = new Question();
            question.setTheme_id(Integer.parseInt(request.getParameter("theme_id")));
            question.setQuestion(request.getParameter("question"));
            question.setQuestion_en(request.getParameter("question_en"));
            question.setExplanation(request.getParameter("explanation"));
            question.setExplanation_en(request.getParameter("explanation_en"));
            questionService.createQuestion(question);
            return "WEB-INF/jsp/questions_read.jsp";
        }
    }
}
