## Major Consideration ##
- Decouple abstraction and implementation by utilization of encapsulation, compositation and inheritance
- Changes in abstraction wont affect client
- Targeted for new code


##  Example of Bridge Design Pattern (JDBC): ## 
```java
DriverManager.registeredDriver(new org.apache.derby.jdbc.EmbeddedDriver());
String dbUrl="jdbc:derby:memory:codejava/weddb;create=true";
Connection connection=DriverManager.getConnection(DbUrl);
Statement sta=con.createStatement();
```

## Problems ##
Say you have a geometric Shape class with a pair of subclasses: Circle and Square. 
You want to extend this class hierarchy to incorporate colors, so you plan to create Red and Blue shape subclasses.
 However, since you already have two subclasses, you’ll need to create four class combinations such as BlueCircle and RedSquare.

Number of class combinations grows in geometric progression.Adding new shape types and colors to the hierarchy will grow it exponentially. For example, to add a triangle shape you’d need to introduce two subclasses, one for each color. And after that, adding a new color would require creating three subclasses, one for each shape type. The further we go, the worse it becomes.

<img src="Bridge-Pattern-Problem.png"/>

```js
package problem;

public abstract class Shape {
    public Shape() {
    }

    abstract public void applyColor();
}
```

```js
package problem;

public abstract class Square extends Shape {
}

```

```js
package problem;

public abstract class Circle extends Shape {
}

```
```js
package problem;

public class RedCircle extends Circle {
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

```

```js
package problem;

public class RedSquare extends Square {
    public void applyColor() {
        System.out.println("Applying red color");
    }
}
```

```js
package problem;

public class BlueCircle extends Circle {

    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

```

```js
package problem;

public class BlueSquare extends Square {
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

```

```js
package problem;

public class BridgeDemo {
    public static void main(String [] args){

        Circle circle=new BlueCircle();
        Square square=new RedSquare();

        circle.applyColor();
        square.applyColor();

    }
}
```

## How composition is used in Bridge Design Pattern? ##
Java composition is achieved by using instance variables that refers to other objects. 
For example, a Person has a Job. Let’s see this with a java composition example code.

```js
package com.journaldev.composition;

public class Person {

    //composition has-a relationship
    private Job job;
   
    public Person(){
        this.job=new Job();
        job.setSalary(1000L);
    }
    public long getSalary() {
        return job.getSalary();
    }

}
```

## Solution ## 
<img src="Bridge-Pattern-Solution.png"/>

```js
package solution;

public interface Color {
    public void applyColor();
}

```

```js
package solution;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}

```

```js
package solution;

public class Blue implements Color {
    public void applyColor() {
        System.out.println("Apply blue color");
    }
}
```

```js
package solution;

public class Red implements Color{
    public void applyColor() {

    }
}

```

```js
package solution;

public class Sqaure extends Shape {
    public Sqaure(Color color) {
        super(color);
    }

    public void applyColor() {

    }
}
```

```js
package solution;

public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    public void applyColor() {

    }
}

```

```js
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

```
