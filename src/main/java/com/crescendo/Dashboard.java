package com.crescendo;

import com.crescendo.dao.CourseDAO;
import com.crescendo.models.CourseAndTeacher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
    CourseDAO courseDAO = new CourseDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String role = (String) httpSession.getAttribute("role");
        String email = (String) httpSession.getAttribute("email");
        if(role != null) {
            List<CourseAndTeacher> courseAndTeacherList;
            if("admin".equals(role) || "student".equals(role))
                courseAndTeacherList = courseDAO.showAllCourses();
            else
                courseAndTeacherList = courseDAO.showAllCourses(email);
            req.setAttribute("courseList", courseAndTeacherList);
            RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/user/user.jsp");
            view.forward(req, resp);
        }
        else {
            resp.sendRedirect("/login");
        }
    }
}
