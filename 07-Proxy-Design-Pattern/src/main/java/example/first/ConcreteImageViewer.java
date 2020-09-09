package example.first;

import com.sun.prism.Image;

public class ConcreteImageViewer implements ImageViewer {

    private Image image;

    public ConcreteImageViewer(String path) {
        // Costly operation
        this.image = Image.load(path);
    }

    @Override
    public void displayImage() {
        // Costly operation
        image.display();
    }
}
