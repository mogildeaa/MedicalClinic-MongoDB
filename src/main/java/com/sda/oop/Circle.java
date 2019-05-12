package com.sda.oop;

public class Circle extends AShape {

    private static final double PI = 3.14;
    // Math.PI

    private double radius;

    @Override
    public double getArea() {
        return PI * radius * radius;
        //echivalent cu MATH.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
        //echivalent cu MATH.PI * 2 * radius;
    }

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
