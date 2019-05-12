package com.sda.oop;

public class Square extends AShape {

    private double side;

    public double getSide() {
        return side;
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
