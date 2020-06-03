package ua.testing.controller.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface Command {
    String execute(HttpServletRequest request) throws ServletException;
}
