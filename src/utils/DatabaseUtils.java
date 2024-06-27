/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

/**
 *
 * @author tuanh
 */
public class DatabaseUtils {

    public static Connection connect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=java;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean isUsernameExists(String username, String currentUsername, boolean isAdd) throws SQLException {
        String query;
        if (isAdd) {
            query = "SELECT COUNT(*) FROM Users WHERE username = ?";
        } else {
            query = "SELECT COUNT(*) FROM Users WHERE username = ? AND username != ?";
        }
        try (Connection conn = DatabaseUtils.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            if (!isAdd) {
                stmt.setString(2, currentUsername);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public static boolean isEmailExists(String email, String currentEmail, boolean isAdd) throws SQLException {
        String query;
        if (isAdd) {
            query = "SELECT COUNT(*) FROM Users WHERE email = ?";
        } else {
            query = "SELECT COUNT(*) FROM Users WHERE email = ? AND email != ?";
        }
        try (Connection conn = DatabaseUtils.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            if (!isAdd) {
                stmt.setString(2, currentEmail);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public static boolean isCourseExists(String courseCode, String currentCourseCode, boolean isAdd) throws SQLException {
        String query;
        if (isAdd) {
            query = "SELECT COUNT(*) FROM Courses WHERE CourseCode = ?";
        } else {
            query = "SELECT COUNT(*) FROM Courses WHERE CourseCode = ? AND CourseCode != ?";
        }
        try (Connection conn = DatabaseUtils.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseCode);
            if (!isAdd) {
                stmt.setString(2, currentCourseCode);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public static boolean isTeacherWithCourses(Connection conn, int userID) throws SQLException {
        String checkTeacherIDQuery = "SELECT COUNT(*) FROM Courses WHERE TeacherID = ?";
        try (PreparedStatement checkTeacherIDStmt = conn.prepareStatement(checkTeacherIDQuery)) {
            checkTeacherIDStmt.setInt(1, userID);
            try (ResultSet rs = checkTeacherIDStmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public static boolean isCourseWithStudents(Connection conn, int courseID) throws SQLException {
        String checkCourseIDQuery = "SELECT COUNT(*) FROM Students WHERE CourseID = ?";
        try (PreparedStatement checkCourseIDStmt = conn.prepareStatement(checkCourseIDQuery)) {
            checkCourseIDStmt.setInt(1, courseID);
            try (ResultSet rs = checkCourseIDStmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public static ObservableList<User> getUsersByRole(String role) {
        ObservableList<User> userList = FXCollections.observableArrayList();
        String query;
        if ("All".equals(role)) {
            query = "SELECT * FROM Users WHERE Role IN ('Manager', 'Teacher')";
        } else {
            query = "SELECT * FROM Users WHERE Role = ?";
        }
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (!"All".equals(role)) {
                pstmt.setString(1, role);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("UserID");
                String username = rs.getString("Username");
                String email = rs.getString("Email");
                String fullName = rs.getString("FullName");
                String password = rs.getString("Password");
                String userRole = rs.getString("Role");

                User user = new User(username, email, fullName, password, userRole);
                user.setUserID(id);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static ObservableList<Course> getCoursesByCredits(String credits) {
        ObservableList<Course> courseList = FXCollections.observableArrayList();
        String query;
        if ("All".equals(credits)) {
            query = "SELECT * FROM Courses";
        } else {
            query = "SELECT * FROM Courses WHERE Credits = ?";
        }
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (!"All".equals(credits)) {
                pstmt.setInt(1, Integer.parseInt(credits));
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("CourseID");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("CourseName");
                Integer creditss = rs.getInt("Credits");
                Integer teacherID = rs.getInt("TeacherID");

                Course course = new Course(courseCode, courseName, creditss, teacherID);
                course.setCourseID(id);
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public static ObservableList<Student> getStudentsByGender(String gender) {
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        String query;
        if ("All".equals(gender)) {
            query = "SELECT * FROM Students";
        } else {
            query = "SELECT * FROM Students WHERE Gender = ?";
        }
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (!"All".equals(gender)) {
                pstmt.setString(1, gender);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("StudentID");
                String fullName = rs.getString("FullName");
                String genderr = rs.getString("Gender");
                LocalDate dateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
                String phoneNumber = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                Integer courseId = rs.getInt("CourseID");

                Student student = new Student(fullName, genderr, dateOfBirth, phoneNumber, address, courseId);
                student.setStudentID(id);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static ObservableList<Score> getStudentsByCourse(int courseID) {
        ObservableList<Score> scoresList = FXCollections.observableArrayList();
        String getStudentsQuery = "SELECT * FROM Students WHERE CourseID = ?";
        String getScoresQuery = "SELECT * FROM Scores WHERE StudentID = ?";

        try (Connection conn = DatabaseUtils.connect(); PreparedStatement getStudentsStmt = conn.prepareStatement(getStudentsQuery)) {

            getStudentsStmt.setInt(1, courseID);
            ResultSet studentsRS = getStudentsStmt.executeQuery();

            while (studentsRS.next()) {
                int studentID = studentsRS.getInt("StudentID");
                String fullName = studentsRS.getString("FullName");

                try (PreparedStatement getScoresStmt = conn.prepareStatement(getScoresQuery)) {
                    getScoresStmt.setInt(1, studentID);
                    ResultSet scoresRS = getScoresStmt.executeQuery();

                    while (scoresRS.next()) {
                        float scoreValue = scoresRS.getFloat("Score");
                        String description = scoresRS.getString("Description");
                        System.out.println("FullName: " + fullName + " Score: " + scoreValue);

                        Score score = new Score(fullName, scoreValue, description);
                        score.setStudentID(studentID);
                        scoresList.add(score);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scoresList;
    }

    public static ObservableList<Score> getStudentsByTeacher(int teacherID) {
        ObservableList<Score> scoresList = FXCollections.observableArrayList();
        String getCourseIDQuery = "SELECT CourseID FROM Courses WHERE TeacherID = ?";
        String getStudentsQuery = "SELECT * FROM Students WHERE CourseID = ?";
        String getScoresQuery = "SELECT * FROM Scores WHERE StudentID = ?";

        try (Connection conn = DatabaseUtils.connect(); PreparedStatement getCourseIDStmt = conn.prepareStatement(getCourseIDQuery)) {

            getCourseIDStmt.setInt(1, teacherID);
            ResultSet coursesRS = getCourseIDStmt.executeQuery();

            while (coursesRS.next()) {
                int courseID = coursesRS.getInt("CourseID");

                try (PreparedStatement getStudentsStmt = conn.prepareStatement(getStudentsQuery)) {
                    getStudentsStmt.setInt(1, courseID);
                    ResultSet studentsRS = getStudentsStmt.executeQuery();

                    while (studentsRS.next()) {
                        int studentID = studentsRS.getInt("StudentID");
                        String fullName = studentsRS.getString("FullName");

                        try (PreparedStatement getScoresStmt = conn.prepareStatement(getScoresQuery)) {
                            getScoresStmt.setInt(1, studentID);
                            ResultSet scoresRS = getScoresStmt.executeQuery();

                            while (scoresRS.next()) {
                                float scoreValue = scoresRS.getFloat("Score");
                                String description = scoresRS.getString("Description");
                                System.out.println("FullName: " + fullName + " Score: " + scoreValue);

                                Score score = new Score(fullName, scoreValue, description);
                                score.setStudentID(studentID);
                                scoresList.add(score);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scoresList;
    }
}
