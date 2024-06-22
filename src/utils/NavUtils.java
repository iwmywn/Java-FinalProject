/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javafx.scene.control.Button;
import java.util.List;

/**
 *
 * @author tuanh
 */
public class NavUtils {
    public static void handleNavButton(Button activeButton, List<Button> navButtons, Runnable clearAction) {
        if (activeButton.getStyleClass().contains("active")) {
            return;
        }
        for (Button button : navButtons) {
            if (button.getStyleClass().contains("active")) {
                button.getStyleClass().remove("active");
            }
        }
        activeButton.getStyleClass().add("active");
        clearAction.run();
    }
}
