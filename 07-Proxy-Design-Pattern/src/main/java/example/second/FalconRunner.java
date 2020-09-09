package example.second;

public class FalconRunner {
    public static void main(String[] args){
        Spaceship falcon1 = new MillenniumFalconProxy(new Pilot("Raj Bhatta"));
        falcon1.fly();

        Spaceship falcon2 = new MillenniumFalconProxy(new Pilot("Programmer Bhatta"));
        falcon2.fly();
    }
}
