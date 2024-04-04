package com.crescendo;

import com.crescendo.dao.CourseDAO;
import com.crescendo.dao.UserDAO;
import com.crescendo.models.Course;
import com.crescendo.models.UserPub;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/add-course")
public class AddCourse extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    CourseDAO courseDAO = new CourseDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserPub> teacherList = userDAO.getUserList("teacher");
        req.setAttribute("teachers", teacherList);
        req.getRequestDispatcher("/WEB-INF/user/add_course.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_name = req.getParameter("course_name");
        String course_description = req.getParameter("course_description");
        int assignedTeacher = Integer.parseInt(req.getParameter("assigned_teacher"));
        Course course = new Course(course_name, course_description, assignedTeacher);
        courseDAO.createCourse(course);
        resp.sendRedirect("/dashboard");
    }
}
