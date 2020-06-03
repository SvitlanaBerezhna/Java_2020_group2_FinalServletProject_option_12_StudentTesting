package ua.testing.controller.commands;

import ua.testing.model.entity.Statistics;
import ua.testing.model.service.StatisticsService;

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
public class StatisticsListCommand implements Command {
    private StatisticsService statisticsService;

    public StatisticsListCommand(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String lang = (String) session.getAttribute("lang");
        List<Statistics> statistics = statisticsService.getAllStatistics(lang);
        request.setAttribute("statisticsList", statistics);
        return "/WEB-INF/jsp/test_statistics.jsp";
    }
}
