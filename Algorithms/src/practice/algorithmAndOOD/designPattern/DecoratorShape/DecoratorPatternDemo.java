package practice.algorithmAndOOD.designPattern.DecoratorShape;

import practice.algorithmAndOOD.designPattern.DecoratorShape.Circle;
import practice.algorithmAndOOD.designPattern.DecoratorShape.Rectangle;
import practice.algorithmAndOOD.designPattern.DecoratorShape.RedShapeDecorator;
import practice.algorithmAndOOD.designPattern.DecoratorShape.Shape;

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
