package com.crescendo;

import com.crescendo.dao.CourseDAO;
import com.crescendo.models.CourseAndTeacher;
import com.crescendo.models.UserPub;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/course/*")
public class GetCourse extends HttpServlet {
    CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wildPaths = req.getPathInfo();
        String[] paths = wildPaths.split("/");
        String courseId = paths[1];
        CourseAndTeacher course = courseDAO.showCourse(courseId);
        req.setAttribute("courseId", courseId);
        req.setAttribute("courseName", course.getCourseName());
        req.setAttribute("courseDescription", course.getCourseDescription());
        req.setAttribute("courseTeacher", course.getTeacherName());
        req.setAttribute("courseTeacherEmail", course.getTeacherEmail());

        if(paths.length == 2) {
            if (Objects.equals(req.getSession().getAttribute("role").toString(), "student") && courseDAO.isEnrolled(courseId, req.getSession().getAttribute("userId").toString()))
                req.setAttribute("isEnrolled", true);
            else if (Objects.equals(req.getSession().getAttribute("role").toString(), "student") && !courseDAO.isEnrolled(courseId, req.getSession().getAttribute("userId").toString()))
                req.setAttribute("isEnrolled", false);

            req.getRequestDispatcher("/WEB-INF/user/course.jsp").include(req, resp);
        }
        else if("enroll".equals(paths[2])){
            List<UserPub> users = courseDAO.showEnrolledStudents(courseId);
            req.setAttribute("enrolledStudents", users);
            req.getRequestDispatcher("/WEB-INF/user/enrolled_students.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wildPaths = req.getPathInfo();
        String[] paths = wildPaths.split("/");
        String courseId = paths[1];
        if(paths.length == 2) {
            courseDAO.deleteCourse(courseId);
            resp.sendRedirect("/dashboard");
        }
        else if("enroll".equals(paths[2])){
            String userId = req.getSession().getAttribute("userId").toString();
            courseDAO.enrollCourse(courseId, userId);
            resp.sendRedirect("/course/" + courseId);
        }
    }
}
