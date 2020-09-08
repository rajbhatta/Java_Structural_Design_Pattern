package solution;

public class Shape2Bridge {
    public static void main(String [] args){
        Color blue=new Blue();

        Shape square=new Sqaure(blue);

        Color red=new Red();
        Shape circle=new Circle(red);

        square.applyColor();
        circle.applyColor();

    }
}
