package ua.testing.controller.commands;

import ua.testing.model.entity.Answer;
import ua.testing.model.entity.Question;
import ua.testing.model.service.AnswerService;
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
public class EditAnswerCommand implements Command {
    private AnswerService answerService;

    public EditAnswerCommand(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            int answer_id = Integer.parseInt(request.getParameter("id"));
            Answer answer = answerService.getAnswerById(answer_id);
            request.setAttribute("answer", answer);
            HttpSession session = request.getSession();
            String lang = (String) session.getAttribute("lang");
            QuestionService questionService = new QuestionService();
            List<Question> questions = questionService.getAllQuestionsByTheme(0, lang);
            request.setAttribute("questionList", questions);
            return "WEB-INF/jsp/answer_update.jsp";
        } else {
            Answer answer = new Answer();
            answer.setQuestion_id(Integer.parseInt(request.getParameter("question_id")));
            answer.setAnswer_id(Integer.parseInt(request.getParameter("answer_id")));
            answer.setAnswer_option(request.getParameter("answer_option"));
            answer.setAnswer_option_en(request.getParameter("answer_option_en"));
            int is_correct = 0;
            String is_correctStr = request.getParameter("is_correct");
            if (is_correctStr != null) {
                is_correct = Integer.parseInt(is_correctStr);
            }
            answer.setIs_correct(is_correct);
            answerService.updateAnswer(answer);
            return "WEB-INF/jsp/answers_read.jsp";
        }
    }
}
