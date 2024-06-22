/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tuanh
 */
public class DateTimeUtils {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void startDateTimeUpdater(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateDateTime(label))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private static void updateDateTime(Label label) {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DEFAULT_FORMATTER);
        label.setText(formattedDateTime);
    }
}
