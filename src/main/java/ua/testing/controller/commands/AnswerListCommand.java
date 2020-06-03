package ua.testing.controller.commands;

import ua.testing.model.entity.Answer;
import ua.testing.model.service.AnswerService;

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
public class AnswerListCommand implements Command {
    private AnswerService answerService;

    public AnswerListCommand(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int question_id = 0;
        if (session.getAttribute("question_id") != null) {
            question_id = (int) session.getAttribute("question_id");
        } else {
            if (request.getParameter("id") != null) {
                question_id = Integer.parseInt(request.getParameter("id"));
                session.setAttribute("question_id", question_id);
            }
        }
        String question = "";
        if (request.getParameter("question") == null) {
            question = (String) session.getAttribute("question");
        } else {
            question = request.getParameter("question");
            session.setAttribute("question", question);
        }
        String lang = (String) session.getAttribute("lang");
        List<Answer> answers = answerService.getAllAnswersByQuestion(question_id, lang);
        request.setAttribute("answerList", answers);
        return "/WEB-INF/jsp/answers_read.jsp";
    }
}
