/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author tuanh
 */
public class AlertUtils {
    public Optional<ButtonType> showAlert(Alert.AlertType alertType, String message, Stage ownerStage) {
       Alert alert = new Alert(alertType);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setHeaderText("");
        if (alertType != Alert.AlertType.CONFIRMATION) {
            alert.getButtonTypes().setAll(ButtonType.CLOSE);
        }
        alert.setGraphic(null);
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        dialogPane.getStyleClass().add("alert");
        dialogPane.getScene().setFill(Color.TRANSPARENT);
        
        switch (alertType) {
            case INFORMATION -> dialogPane.getStyleClass().add("alert-information");
            case WARNING -> dialogPane.getStyleClass().add("alert-warning");
            case ERROR -> dialogPane.getStyleClass().add("alert-error");
            case CONFIRMATION -> dialogPane.getStyleClass().add("alert-confirmation");
            default -> {
            }
        }
        
        Platform.runLater(() -> {
            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.setWidth(370);
            alertStage.setX(ownerStage.getX() + (ownerStage.getWidth() - alertStage.getWidth()) / 2);
            alertStage.setY(ownerStage.getY() + (ownerStage.getHeight() - alertStage.getHeight()) / 2);
        });
                
        if (alertType == Alert.AlertType.CONFIRMATION) {
            return alert.showAndWait();
        }
        alert.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event) -> {
            alert.close();
        }));
        timeline.setCycleCount(1);
        timeline.play();
        return Optional.empty();
    }
}
