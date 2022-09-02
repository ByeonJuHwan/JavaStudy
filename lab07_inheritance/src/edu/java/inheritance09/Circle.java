package edu.java.inheritance09;

import java.util.Scanner;

public class Circle extends Shape {

    private double radius; // 반지름
    
    Scanner sc = new Scanner(System.in);
    
    protected Circle(String type) {
        super(type);
        System.out.print("반지름의 길이를 입력하세요>> ");
        this.radius=sc.nextDouble();
    }

    @Override
    public double area() {
        double area = this.radius * this.radius * Math.PI;
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = this.radius*2*Math.PI;
        return perimeter;
    }

}
