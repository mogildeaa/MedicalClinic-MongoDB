package com.sda.oop;

public class Main {
    public static void printShape (AShape shape) {
        // %s o sa primesc un string;
        // &f o sa primesc un double, si afiseaza doar primele 2 zecimale;
        // 3 placeholder - 3 parametrii
        String message = String.format("%s received has perimeter: %.2f and area : %.2f",
                shape.getClass().getSimpleName(),
                shape.getPerimeter(), shape.getArea());

        System.out.println(message);
    }

    public static void main(String[] args) {
        AShape circle = new Circle(2);
        AShape square = new Square(3);
        AShape rectangle = new Rectangle(4,2);

        printShape(circle);
        printShape(square);
        printShape(rectangle);
    }
}


