## Introduction ##
- This design pattern is based on interface
- In proxy design pattern, a class represents functionality of another class.

## Why we need proxy design pattern ##
### Scenario 1: ###
<br/>
<img src="Proxy1.png"/>

### Scenario 2: ###
One example of a virtual proxy is loading images. Let's imagine that we're building a file manager. 
Like any other file manager, this one should be able to display images in a folder that a user decides to open.

If we assume there exists a class, ImageViewer, responsible for loading and displaying images - we might implement our file manager by using this class directly.
 This kind of approach seems logical and straight-forward but it contains a subtle problem.

If we implement the file manager as described above, we're going to be loading images every time they appear in the folder. 
If the user only wishes to see the name or size of an image, this kind of approach would still load the entire image into memory.
 Since loading and displaying images are expensive operations, this can cause performance issues.

A better solution would be to display images only when actually needed. 
In this sense, we can use a proxy to wrap the existing ImageViewer object. 
This way, the actual image viewer will only get called when the image needs to be rendered.
 All other operations (such as obtaining the image name, size, date of creation, etc.) don't require the actual image and can therefore be obtained through a much lighter proxy object instead.




### Example in Java ##
```java
java.lang.reflect.Proxy
java.rmi.*

```