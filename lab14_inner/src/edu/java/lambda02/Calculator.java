package edu.java.lambda02;

public class Calculator {
    @FunctionalInterface
    interface Calculable{
        double calculate(double x, double y);
    }
    
    private double x;
    private double y;
    
    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double calculate(Calculable calc) {
        return calc.calculate(x, y);
    }

}
