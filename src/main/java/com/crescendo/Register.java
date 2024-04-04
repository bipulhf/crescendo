package com.crescendo;

import com.crescendo.dao.UserDAO;
import com.crescendo.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/register/register.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User user = new User(name, email, password, role);
        if(userDAO.addUser(user)) {
            RequestDispatcher view = req.getRequestDispatcher("WEB-INF/register/register_success.jsp");
            view.forward(req, resp);
        } else {
            RequestDispatcher view = req.getRequestDispatcher("WEB-INF/register/register_error.jsp");
            view.forward(req, resp);
        }
    }
}
