package com.crescendo.dao;

import com.crescendo.models.Course;
import com.crescendo.models.CourseAndTeacher;
import com.crescendo.models.UserPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private DatabaseConnection db = new DatabaseConnection();

    public void createCourse(Course course) {
        String sql = "INSERT INTO course(course_name, description, teacher_id) VALUES (?, ?, ?);";
        try (Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, course.getCourse_name());
            ps.setString(2, course.getCourse_description());
            ps.setString(3, String.valueOf(course.getAssigned_teacher()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<CourseAndTeacher> showAllCourses() {
        List<CourseAndTeacher> courseAndTeacherList = new ArrayList<>();
        String sql = "SELECT c.id, c.course_name, c.description, u.name, u.email FROM course c JOIN user u ON c.teacher_id = u.id;";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                courseAndTeacherList.add(new CourseAndTeacher(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseAndTeacherList;
    }

    public List<CourseAndTeacher> showAllCourses(int userId) {
        List<CourseAndTeacher> courseAndTeacherList = new ArrayList<>();
        String sql = "SELECT\n" +
                "    ce.course_id,\n" +
                "    c.course_name,\n" +
                "    c.description,\n" +
                "    t.name AS teacher_name,\n" +
                "    t.email AS teacher_email\n" +
                "FROM\n" +
                "    course_enrolled ce\n" +
                "        JOIN\n" +
                "    course c ON ce.course_id = c.id\n" +
                "        JOIN\n" +
                "    user t ON c.teacher_id = t.id\n" +
                "WHERE\n" +
                "    ce.user_id = ?;";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(userId));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                courseAndTeacherList.add(new CourseAndTeacher(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseAndTeacherList;
    }

    public List<CourseAndTeacher> showAllCourses(String email) {
        List<CourseAndTeacher> courseAndTeacherList = new ArrayList<>();
        String sql = "SELECT c.id, c.course_name, c.description, u.name, u.email FROM course c JOIN user u ON c.teacher_id = u.id AND u.email = ?;";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                courseAndTeacherList.add(new CourseAndTeacher(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseAndTeacherList;
    }

    public CourseAndTeacher showCourse(String courseId) {
        CourseAndTeacher course = new CourseAndTeacher();
        String sql = "SELECT c.id, c.course_name, c.description, u.name, u.email FROM course c JOIN user u ON c.teacher_id = u.id AND c.id=?;";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, courseId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                course.setCourseId(Integer.parseInt(rs.getString(1)));
                course.setCourseName(rs.getString(2));
                course.setCourseDescription(rs.getString(3));
                course.setTeacherName(rs.getString(4));
                course.setTeacherEmail(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public void deleteCourse(String courseId) {
        String sql = "DELETE FROM course WHERE id = ?;";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean isEnrolled(String courseId, String userId) {
        String sql = "SELECT user_id, course_id FROM course_enrolled WHERE course_id=? AND user_id=?;";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, courseId);
            ps.setString(2, userId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<UserPub> showEnrolledStudents(String courseId) {
        String sql = "SELECT DISTINCT id, name, email FROM user WHERE id IN (SELECT user_id FROM course_enrolled WHERE course_id = ?);\n;";
        List<UserPub> users = new ArrayList<>();
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, courseId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                users.add(new UserPub(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), "Student"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void enrollCourse(String courseId, String userId) {
        String sql = "INSERT INTO course_enrolled(course_id, user_id) VALUES (?, ?);";
        try(Connection con = db.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, courseId);
            ps.setString(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
