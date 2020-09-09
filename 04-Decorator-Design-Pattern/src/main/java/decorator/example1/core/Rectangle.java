package decorator.example1.core;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
    @Override
    public void resize() {
        System.out.println("Resizing Rectangle");
    }
    @Override
    public String description() {
        return "Rectangle object";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
