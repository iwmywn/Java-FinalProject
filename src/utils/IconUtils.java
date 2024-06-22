/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javafx.scene.image.Image;

/**
 *
 * @author tuanh
 */
public class IconUtils {
    public static Image loadIcon() {
        return new Image(IconUtils.class.getResourceAsStream("/images/university.png"));
    }
}
