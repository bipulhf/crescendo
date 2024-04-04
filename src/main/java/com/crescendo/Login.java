package com.crescendo;

import com.crescendo.dao.UserDAO;
import com.crescendo.models.User;
import com.crescendo.models.UserPub;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("name") == null && session.getAttribute("role") == null) {
            RequestDispatcher view = req.getRequestDispatcher("WEB-INF/login/login.jsp");
            view.forward(req, resp);
        }
        else {
            resp.sendRedirect("/dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserPub user = userDAO.login(req.getParameter("email"), req.getParameter("password"));
        if(user.getRole() != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getID());
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole());
            resp.sendRedirect("/dashboard");
        }
        else {
            RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/login/login_error.jsp");
            view.forward(req, resp);
        }
    }
}
