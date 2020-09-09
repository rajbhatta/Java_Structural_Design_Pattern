package decorator.example1.decorator;

import decorator.example1.core.Shape;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape) {
        super();
        this.decoratedShape = decoratedShape;
    }
}
