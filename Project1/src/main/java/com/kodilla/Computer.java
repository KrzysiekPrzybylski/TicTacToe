package com.kodilla;

public class Computer  implements Player{

    private Shape actualShape;

    @Override
    public void setActualShape(Shape shape) {
        actualShape = shape;
    }

    @Override
    public Shape getActualShape() {
        return actualShape;
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
