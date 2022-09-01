package edu.java.inheritance03;

public class Car {
    // field
    private double fuel; // 연료
    private double speed; // 속력
    
    // constructor
    public Car(double fuel, double speed) {
        this.fuel = fuel;
        this.speed = speed;
    }
    
    public void drive() {
        System.out.println("speed : " + speed + ", " + "fuel : " + fuel);
    }
    
    // getter
    public double getFuel() {
        return fuel;
    }

    public double getSpeed() {
        return speed;
    }
    
    
}
