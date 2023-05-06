package Inheritance;

public class VehicleUse {
    public static void main(String[] args) {

//        Vehicle v1 = new Vehicle();
//        v1.color = "Red";
//        v1.print();

        Car c = new Car();
        c.name = "BMW 450";
        c.color = "Black";
        c.maxSpeed = 190;
        c.numDoors = 4;
        c.print();
        System.out.println(c.isMotorised());
//
//        Bicycle b = new Bicycle();
//        b.print();
    }
}
