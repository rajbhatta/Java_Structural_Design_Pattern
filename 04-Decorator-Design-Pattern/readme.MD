## Why decorate design pattern ##
- The decorator design pattern allows us to dynamically add functionality and behavior to an object without affecting the behavior of other existing objects in the same class.
- We use inheritance to extend the behavior of the class. This takes place at compile time, and all of the instances of that class get the extended behavior.
- Decorator design pattern uses abstract classes or interfaces with the composition to implement the wrapper.
- Decorator design patterns create decorator classes, which wrap the original class and provide additional functionality by keeping the class methods' signature unchanged.

## Example of decorator design pattern from Java (InputStream) ##
```js
File file = new File("./output.txt");
file.createNewFile();

OutputStream ostream=new FileOutputStream(file);
DataOutputStream doStream=new DataOutputStream(oStream);
doStream.writeChars("text");

```

### Example 1: How to design decorator design pattern ? ### 
Suppose, we have a Shape interface, which can includedraw(), resize() ,  isHide(), anddescription().
```java
package decorator.example1.core;

public interface Shape {
    void draw();
    void resize();
    String description();
    boolean isHide();
}

```
- Now, we have two concrete classes of Shape  — Circle and Rectangle — to define a specific shape.

```java
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

```

```java
package decorator.example1.core;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
    @Override
    public void resize() {
        System.out.println("Resizing Circle");
    }
    @Override
    public String description() {
        return "Circle object";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
```

- Now, let's take a look at the decoration portion. So far, all is good, and we can draw Circle and Rectangle.
 But, we would like to have some additional functionalities for the Shape, like Fill-Color, Line-Color,  Line-Thinkness, Line-Style, and so on.

- First, we will create an abstract wrapper (decorator) class that implements the Shape. I will use theShapeDecorator for this example.
```java
package decorator.example1.decorator;

import decorator.example1.core.Shape;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape) {
        super();
        this.decoratedShape = decoratedShape;
    }
}
```

- I kept this abstract to avoid any direct instantiation since this is just a wrapper and does not add any functionality into the shape. 
Also, I have implemented Shape to allow adding additional functionalities to all of the defined, concrete Shape classes — Circle andRectanagle — for this case.

- Create enums for  Color and LineStyle for shapes. Below is the enum for  Color:
```java
package design.decorator;
public enum Color {
      RED,
      GREEN,
      BLUE,
      YELLOW,
      WHITE,
      BLACK,
      ORANGE,
      MAROON
}
```

```java
package design.decorator;
public enum LineStyle {
      SOLID,
      DASH,
      DOT,
      DOUBLE_DASH,
      DASH_SPACE
}
```

- Create the FillColorDecorator to add the functionality of the fill-color in the shape.
```java
package design.decorator;
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
```

- Create the  LineColorDecorator to add the functionality of line-color in the shape.
```java
package design.decorator;
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
```

- Create the  LineThicknessDecorator to add the functionality of the custom line thickness in the shape.
```java
package design.decorator;
public class LineThinknessDecorator extends ShapeDecorator {
      protected double thickness;
      public LineThinknessDecorator(Shape decoratedShape, double thickness) {
                super(decoratedShape);
                this.thickness = thickness;
      }
      @Override
      public void draw() {
                decoratedShape.draw();
                System.out.println("Line thickness: " + thickness);
      }
      // no change in the functionality
      @Override
      public void resize() {
      decoratedShape.resize();
      }
      @Override
      public String description() {
      return decoratedShape.description() + " drawn with line thickness " + thickness + ".";
      }
      // no change in the functionality
      @Override
      public boolean isHide() {
      return decoratedShape.isHide();
      }
}
```

- Create LineStyleDecorator to add functionality of custom line styles in the shape.

```java
package design.decorator;
public class LineStyleDecorator extends ShapeDecorator {
        protected LineStyle style;
        public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
        super(decoratedShape);
        this.style = style;
        }
        @Override
        public void draw() {
        decoratedShape.draw();
        System.out.println("Line Style: " + style);
        }
        // no change in the functionality
        @Override
        public void resize() {
        decoratedShape.resize();
        }
        @Override
        public String description() {
        return decoratedShape.description() + " drawn with " + style + " lines.";
        }
        // no change in the functionality
        @Override
        public boolean isHide() {
        return decoratedShape.isHide();
        }
}
```

Now it's time to run the application

```java
ackage design.decorator;
public class Main {
  public static void main(String[] args) {
            System.out.println("Creating Simple Shape Objects...");
            Shape rectangle = new Rectangle();
            Shape circle = new Circle();
            System.out.println("Drawing Simple Shape Objects...");
            rectangle.draw();
            System.out.println();
            circle.draw();
            System.out.println();
            System.out.println("Creating Decorated Circle with Red Color, Blue Lines in dash pattern and thickness of 2 ...");
            Shape circle1 = new FillColorDecorator(new LineColorDecorator(new LineStyleDecorator(
            new LineThinknessDecorator(new Circle(), 2.0d), LineStyle.DASH), Color.BLUE), Color.RED);
            circle1.draw();
            System.out.println();
            // order of decorator is also not much important here since all are unique functionalities.
            // we can also do this nesting of functionalities in separate statements.
            System.out.println("creating object with similar functionalities in separate statements.");
            Circle c = new Circle();
            LineThinknessDecorator lt = new LineThinknessDecorator(c, 2.0d);
            LineStyleDecorator ls = new LineStyleDecorator(lt, LineStyle.DASH);
            LineColorDecorator lc = new LineColorDecorator(ls, Color.BLUE);
            FillColorDecorator fc = new FillColorDecorator(lc, Color.RED);
            Shape circle3 = fc;
            circle3.draw();
            System.out.println();
            System.out.println("Creating Decorated Circle with Green Color, Black Lines ...");
            Shape circle2 = new FillColorDecorator(new LineColorDecorator(new Circle(), Color.BLACK), Color.GREEN);
            circle2.draw();
            System.out.println();
            System.out.println("Creating Decorated Rectange with Yellow Color, Red Lines in double dash pattern...");
            Shape rectangle1 = new FillColorDecorator(new LineColorDecorator(new Rectangle(), Color.RED), Color.YELLOW);
            rectangle1.draw();
            System.out.println();
      }
}
```