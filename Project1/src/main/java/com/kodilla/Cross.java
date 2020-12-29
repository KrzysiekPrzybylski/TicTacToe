package com.kodilla;

import javafx.scene.image.Image;

public class Cross implements Shape {

    public static Image Cross = new Image(("file:src/main/resources/cross.png"),80,80,false,false);

    @Override
    public Image getShape() {
        return Cross;
    }
}