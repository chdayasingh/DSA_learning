package Inheritance;

public abstract class Vehicle {
    String name = "Not given";
    String color;
    int maxSpeed;

    public void print() {
        System.out.println();
        System.out.println(name);
        System.out.println("color: " + color);
        System.out.println("Max Speed: " + maxSpeed);
    }

    public abstract boolean isMotorised();
}
