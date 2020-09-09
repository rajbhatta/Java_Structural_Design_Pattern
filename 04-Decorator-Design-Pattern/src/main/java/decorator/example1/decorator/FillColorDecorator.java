package decorator.example1.decorator;

import decorator.example1.core.Shape;

public class FillColorDecorator extends ShapeDecorator {

    protected Color color;
    public FillColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Fill Color: " + color);
    }
    // no change in the functionality
    // we can add in the functionality if we like. there is no restriction
    // except we need to maintain the structure of the Shape APIs
    @Override
    public void resize() {
        decoratedShape.resize();
    }
    @Override
    public String description() {
        return decoratedShape.description() + " filled with " + color + " color.";
    }
    // no change in the functionality
    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
