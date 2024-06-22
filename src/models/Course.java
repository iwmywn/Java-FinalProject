/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tuanh
 */
public class Course {
    private final IntegerProperty courseID;
    private final StringProperty courseCode;
    private final StringProperty courseName;
    private final IntegerProperty credits;
    private final IntegerProperty teacherID;

    public Course(String courseCode, String courseName, int credits, int teacherID) {
        this.courseID = new SimpleIntegerProperty();
        this.courseCode = new SimpleStringProperty(courseCode);
        this.courseName = new SimpleStringProperty(courseName);
        this.credits = new SimpleIntegerProperty(credits);
        this.teacherID = new SimpleIntegerProperty(teacherID);
    }

    public int getCourseID() {
        return courseID.get();
    }

    public void setCourseID(int courseID) {
        this.courseID.set(courseID);
    }

    public IntegerProperty courseIDProperty() {
        return courseID;
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public void setCourseCode(String courseCode) {
        this.courseCode.set(courseCode);
    }

    public StringProperty courseCodeProperty() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName.get();
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public StringProperty courseNameProperty() {
        return courseName;
    }

    public int getCredits() {
        return credits.get();
    }

    public void setCredits(int credits) {
        this.credits.set(credits);
    }

    public IntegerProperty creditsProperty() {
        return credits;
    }

    public int getTeacherID() {
        return teacherID.get();
    }

    public void setTeacherID(int teacherID) {
        this.teacherID.set(teacherID);
    }

    public IntegerProperty teacherIDProperty() {
        return teacherID;
    }
}
