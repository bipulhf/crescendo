package com.crescendo.models;

import java.io.Serializable;

public class Course implements Serializable {
    private int ID;
    private String course_name;
    private String course_description;
    private int assigned_teacher;

    public Course() { }

    public Course(int ID, String course_name, String course_description, int assigned_teacher) {
        this.ID = ID;
        this.course_name = course_name;
        this.course_description = course_description;
        this.assigned_teacher = assigned_teacher;
    }

    public Course(String course_name, String course_description, int assigned_teacher) {
        this.course_name = course_name;
        this.course_description = course_description;
        this.assigned_teacher = assigned_teacher;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public int getAssigned_teacher() {
        return assigned_teacher;
    }

    public void setAssigned_teacher(int assigned_teacher) {
        this.assigned_teacher = assigned_teacher;
    }
}
