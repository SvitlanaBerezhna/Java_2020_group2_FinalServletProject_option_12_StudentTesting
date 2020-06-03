package ua.testing.controller.commands;

import ua.testing.model.entity.Test;
import ua.testing.model.entity.User;
import ua.testing.model.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class TestResultCommand implements Command {
    private TestService testService;

    public TestResultCommand(TestService testService) {
        this.testService = testService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        int theme_id = (int) session.getAttribute("theme_id");
        String lang = (String) session.getAttribute("lang");
        int totalQuestions = (int) session.getAttribute("totalQuestions");
        testService.deletePreviousTestResult(user_id, theme_id);
        List<Test> testList = new ArrayList<Test>();
        for (int i = 1; i <= totalQuestions; i++) {
            int question_id = Integer.parseInt(request.getParameter("question_id_" + i));
            int answers_count = Integer.parseInt(request.getParameter("answers_count"));
            for (int j = 1; j <= answers_count; j++) {
                String answerStr = request.getParameter("answer_" + question_id + "_" + j);
                if (answerStr != null) {
                    int answer = Integer.parseInt(answerStr);
                    Test test = new Test();
                    test.setUser_id(user_id);
                    test.setTheme_id(theme_id);
                    test.setQuestion_id(question_id);
                    test.setAnswer(answer);
                    testList.add(test);
                }
            }
        }
        testService.addCurrentTestResult(testList);
        List<Test> resultList = testService.getResultTest(user_id, theme_id, lang);
        request.setAttribute("resultList", resultList);
        return "/WEB-INF/jsp/test_result.jsp";
    }
}
