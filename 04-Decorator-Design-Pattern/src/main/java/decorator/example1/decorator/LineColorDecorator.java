package decorator.example1.decorator;

import decorator.example1.core.Shape;

public class LineColorDecorator extends ShapeDecorator {
    protected Color color;
    public LineColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Line Color: " + color);
    }
    // no change in the functionality
    @Override
    public void resize() {
        decoratedShape.resize();
    }
    @Override
    public String description() {
        return decoratedShape.description() + " drawn with " + color + " color.";
    }
    // no change in the functionality
    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
