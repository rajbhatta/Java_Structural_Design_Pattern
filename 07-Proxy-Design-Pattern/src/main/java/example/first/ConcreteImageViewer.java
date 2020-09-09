package example.first;

public class ConcreteImageViewer implements ImageViewer {

    public ConcreteImageViewer(String path) {
        // Costly operation
        loadImage();
    }

    @Override
    public void displayImage() {
        // Costly operation
        display();
    }

    private void loadImage(){
        System.out.print("Load image here");
    }

    private void display(){
        System.out.print("Display image here");
    }
}
