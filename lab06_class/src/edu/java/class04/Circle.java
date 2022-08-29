package edu.java.class04;

public class Circle {
    // field - 반지름
    double r;
   
    // constructor - 기본 생성자, argument를 갖는 생성자
    public Circle() {
        
    }
    public Circle(double r) {
        this.r = r;
    }
    
    // method - 둘레 길이(2*3.14*r), 넓이(3.14*r*r)
    public double 둘레() {
        return 2*Math.PI*this.r;
    }
    
    public double 넓이() {
        return Math.PI*this.r*this.r;
    }
}
