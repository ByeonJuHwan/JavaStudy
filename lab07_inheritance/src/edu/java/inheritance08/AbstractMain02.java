package edu.java.inheritance08;

abstract class Vehicle{
    public abstract void run();
}

class Bus extends Vehicle{
    @Override
    public void run() {
        System.out.println("버스 fun");
        
    }
}

class Taxi extends Vehicle{
    @Override
    public void run() {
        System.out.println("택시는 달린다");
        
    }
}

class Driver{
    public void drive(Vehicle v) {
        v.run();
    }
}

public class AbstractMain02 {

    public static void main(String[] args) {
        Driver busDriver = new Driver();
        busDriver.drive(new Bus());
        
        
        Driver taxiDriver = new Driver();
        taxiDriver.drive(new Taxi());

    }

}
