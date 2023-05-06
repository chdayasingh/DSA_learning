package Inheritance;

import Generics.PrintInterface;

public class Car extends Vehicle implements PrintInterface {
    int numDoors;
    public void print(){
        super.print();
        System.out.println("No of Doors: " + numDoors);
    }

    @Override
    public boolean isMotorised() {
        return true;
    }


}
