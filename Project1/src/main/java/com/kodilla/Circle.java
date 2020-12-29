package com.kodilla;

import javafx.scene.image.Image;

public class Circle implements Shape {


    public static Image circle = new Image(("file:src/main/resources/circle.png"),80,80,false,false);

    @Override
    public Image getShape() {
        return circle;
    }
}