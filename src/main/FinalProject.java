/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package main;

import utils.WindowUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.IconUtils;

/**
 *
 * @author tuanh
 */
public class FinalProject extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image icon = IconUtils.loadIcon();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignIn.fxml"));
        stage.getIcons().add(icon);
        Scene scene = new Scene(root);

        WindowUtils.setupDraggableWindow(stage, scene);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
