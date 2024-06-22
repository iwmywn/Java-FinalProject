/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tuanh
 */
public class SigninController {

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private ImageView btnClose;

    @FXML
    private void handleSigninAction() {
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        AlertUtils alertUtils = new AlertUtils();
        Stage loginStage = (Stage) tfUsername.getScene().getWindow();

        if (username.isEmpty() || password.isEmpty()) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please enter username and password!", loginStage);
            return;
        }

        String query = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        try (Connection conn = DatabaseUtils.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("UserID");
                String role = rs.getString("Role");
                FXMLLoader loader;
                
                if ("admin".equalsIgnoreCase(role)) {
                    loader = new FXMLLoader(getClass().getResource("/fxml/Admin.fxml"));
                } else if ("manager".equalsIgnoreCase(role)) {
                    loader = new FXMLLoader(getClass().getResource("/fxml/Manager.fxml"));
                } else if ("teacher".equalsIgnoreCase(role)) {
                    loader = new FXMLLoader(getClass().getResource("/fxml/Teacher.fxml"));
                } else {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Unknown role: " + role, loginStage);
                    return;
                }
                Image icon = IconUtils.loadIcon();
                Parent root = loader.load();
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);

                MainController controller = loader.getController();
                controller.setRole(role, id);
                
                mainStage.setScene(scene);
                mainStage.getIcons().add(icon);
                WindowUtils.setupDraggableWindow(mainStage, scene);
                loginStage.close();
                mainStage.show();

                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Sign in successful!", mainStage);
            } else {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Invalid username or password!", loginStage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCloseSigninPage() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
