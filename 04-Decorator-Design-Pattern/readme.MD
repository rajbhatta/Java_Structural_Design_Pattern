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
