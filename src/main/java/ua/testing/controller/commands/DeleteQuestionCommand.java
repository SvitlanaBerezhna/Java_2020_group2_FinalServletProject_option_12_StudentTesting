package ua.testing.controller.commands;

import ua.testing.model.entity.Question;
import ua.testing.model.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class DeleteQuestionCommand implements Command {
    private QuestionService questionService;

    public DeleteQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Question question = questionService.getQuestionById(id);
        if (question != null) {
            questionService.deleteQuestion(id);
        }
        return "WEB-INF/jsp/questions_read.jsp";
    }
}
