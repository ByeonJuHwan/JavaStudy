package edu.java.inheritance09;

import java.util.Scanner;

public class Rectangle extends Shape {
    private double width;  //가로
    private double height; // 세로
   
    Scanner sc = new Scanner(System.in);
    
    protected Rectangle(String type) {
        super(type);
        System.out.print("가로길이를 입력하세요>> ");
        this.width = sc.nextDouble();
        System.out.print("세로길이를 입력하세요>> ");
        this.height = sc.nextDouble();
        
    }


    @Override
    public double perimeter() {
        
        double perimeter = 2*(this.width+this.height);
        return perimeter;
    }



    @Override
    public double area() {
        
        double area = this.height * this.width;
        return area;
    }

}
