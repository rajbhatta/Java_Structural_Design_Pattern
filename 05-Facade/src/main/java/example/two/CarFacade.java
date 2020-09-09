package example.two;

public class CarFacade {

    private CarEngine engine;
    private CarBody body;
    private CarAccessories accessories;
    public CarFacade(){
        this.engine = new CarEngine();
        this.body = new CarBody();
        this.accessories = new CarAccessories();
    }
    public void createCar(){
        System.out.println("Creating a car...");
        engine.setCarEngine();
        body.setCarBody();
        accessories.setCarAccessories();
        System.out.println("Your car is ready.");
    }
}
