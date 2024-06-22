/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tuanh
 */
public class Score {
    private final IntegerProperty scoreID;
    private final IntegerProperty studentID;
    private final StringProperty fullName;
    private final FloatProperty score;
    private final StringProperty description;
    
    public Score(float score, String description) {
        this.scoreID = new SimpleIntegerProperty();
        this.studentID = new SimpleIntegerProperty();
        this.fullName = new SimpleStringProperty();
        this.score = new SimpleFloatProperty(score);
        this.description = new SimpleStringProperty(description);
    }
    
    public Score(String fullName, float score, String description) {
        this.scoreID = new SimpleIntegerProperty();
        this.studentID = new SimpleIntegerProperty();
        this.fullName = new SimpleStringProperty(fullName);
        this.score = new SimpleFloatProperty(score);
        this.description = new SimpleStringProperty(description);
    }
        
    public int getScoreID() {
        return scoreID.get();
    }

    public void setScoreID(int scoreID) {
        this.scoreID.set(scoreID);
    }

    public IntegerProperty scoreIDProperty() {
        return scoreID;
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
    
    public float getScore() {
        return score.get();
    }
    
    public void setScore(float score) {
        this.score.set(score);
    }
    
    public FloatProperty scoreProperty() {
        return score;
    }
    
    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }
}
