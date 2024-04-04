# CHANGE USERNAME AND PASSWORD IN THE DatabaseConnection.java FILE (src/main/java/com/crescendo/dao/DatabaseConnection.java)
# Three types of User : admin, student, teacher. Student and teacher can sign up from the website. admin should be added via sql command.

DROP DATABASE IF EXISTS course_management;

CREATE DATABASE course_management;
USE course_management;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS course_enrolled;
DROP TABLE IF EXISTS course;

CREATE TABLE user (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      role ENUM('student', 'admin', 'teacher') NOT NULL
);

CREATE TABLE course (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        course_name VARCHAR(255) NOT NULL,
                        description VARCHAR(400) NOT NULL,
                        teacher_id INT NOT NULL,

                        CONSTRAINT instructor_fk FOREIGN KEY(teacher_id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE course_enrolled (
                                 user_id INT NOT NULL,
                                 course_id INT NOT NULL,

                                 CONSTRAINT course_enrolled_user_fk FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                                 CONSTRAINT course_enrolled_course_fk FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE,
                                 PRIMARY KEY (user_id, course_id)
);

INSERT INTO user(name, email, password, role) VALUES ('yourName', 'yourmail@mail.com', '123456', 'admin');
