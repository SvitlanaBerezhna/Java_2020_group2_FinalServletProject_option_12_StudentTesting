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
public class AddAnswerCommand implements Command {
    private AnswerService answerService;

    public AddAnswerCommand(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            HttpSession session = request.getSession();
            String question_id = (String) request.getParameter("question_id");
            request.setAttribute("question_id", question_id);
            String question = (String) session.getAttribute("question");
            request.setAttribute("question", question);
            return "WEB-INF/jsp/answer_create.jsp";
        } else {
            Answer answer = new Answer();
            HttpSession session = request.getSession();
            int question_id = (int) session.getAttribute("question_id");
            answer.setQuestion_id(question_id);
            answer.setAnswer_option(request.getParameter("answer_option"));
            answer.setAnswer_option_en(request.getParameter("answer_option_en"));
            int is_correct = 0;
            if (request.getParameter("is_correct") != null) {
                is_correct = Integer.parseInt(request.getParameter("is_correct"));
            }
            answer.setIs_correct(is_correct);
            answerService.createAnswer(answer);
            request.setAttribute("question_id", question_id);
            return "WEB-INF/jsp/answers_read.jsp";
        }
    }
}
