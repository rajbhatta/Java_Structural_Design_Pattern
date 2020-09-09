package example.first;

public class NexusRunner {
    public static void main(String[] args) {
        ImageViewer flowers = new ConcreteImageViewer("./photos/flowers.png");
        ImageViewer trees = new ConcreteImageViewer("./photos/trees.png");
        ImageViewer grass = new ConcreteImageViewer("./photos/grass.png");

        ImageViewer sky = new ImageViewerProxy("./photos/sky.png");
        ImageViewer sun = new ImageViewerProxy("./photos/sun.png");
        ImageViewer clouds = new ImageViewerProxy("./photos/clouds.png");

        sky.displayImage();
    }
}
