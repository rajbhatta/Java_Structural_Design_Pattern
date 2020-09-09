package example.first;

public class ImageViewerProxy implements ImageViewer {

    private String path;
    private ImageViewer viewer;

    public ImageViewerProxy(String path) {
        this.path = path;
    }

    @Override
    public void displayImage() {
        if (this.viewer == null) {
            this.viewer = new ConcreteImageViewer(this.path);
        }
        this.viewer.displayImage();
    }
}