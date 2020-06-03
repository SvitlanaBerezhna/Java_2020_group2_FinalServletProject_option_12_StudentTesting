package ua.testing.controller.commands;

import ua.testing.model.entity.Answer;
import ua.testing.model.service.AnswerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class DeleteAnswerCommand implements Command {
    private AnswerService answerService;

    public DeleteAnswerCommand(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int answer_id = Integer.parseInt(request.getParameter("id"));
        Answer answer = answerService.getAnswerById(answer_id);
        if (answer != null) {
            answerService.deleteAnswer(answer_id);
        }
        HttpSession session = request.getSession();
        int question_id = (int) session.getAttribute("question_id");
        request.setAttribute("question_id", question_id);
        session.setAttribute("question_id", question_id);
        return "WEB-INF/jsp/answers_read.jsp";
    }
}
