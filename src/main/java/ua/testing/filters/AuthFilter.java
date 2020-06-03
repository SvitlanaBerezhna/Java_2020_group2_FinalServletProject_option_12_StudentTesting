package ua.testing.filters;

import ua.testing.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, " +
                "pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);

        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
        } else {
            User user = (User) session.getAttribute("user");
            if (action == null || user == null && !action.equals(("login"))) {
                request.setAttribute("msg", "Please login");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
