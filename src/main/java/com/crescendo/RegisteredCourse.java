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
import java.util.List;

@WebServlet("/dashboard/registered-course")
public class RegisteredCourse extends HttpServlet {
    CourseDAO courseDAO = new CourseDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseAndTeacher> courseAndTeacherList = courseDAO.showAllCourses(Integer.parseInt(req.getSession().getAttribute("userId").toString()));
        req.setAttribute("registeredCourseList", courseAndTeacherList);
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/user/registered_course.jsp");
        view.forward(req, resp);
    }
}
