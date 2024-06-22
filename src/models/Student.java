/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

/**
 *
 * @author tuanh
 */
public class Student {
    private final IntegerProperty studentID;
    private final StringProperty fullName;
    private final StringProperty gender;
    private final ObjectProperty<LocalDate> dateOfBirth;
    private final StringProperty phoneNumber;
    private final StringProperty address;
    private final IntegerProperty courseID;

    public Student(String fullName, String gender, LocalDate dateOfBirth, String phoneNumber, String address, int courseID) {
        this.studentID = new SimpleIntegerProperty();
        this.fullName = new SimpleStringProperty(fullName);
        this.gender = new SimpleStringProperty(gender);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.courseID = new SimpleIntegerProperty(courseID);
    }

    public int getStudentID() {
        return studentID.get();
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
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
}
