package edu.java.class03;


// class = field + constructor + method ==> data type
public class Rectangle {
    // field - 가로 , 세로
    double 가로; // 직사각형의 가로 길이
    double 세로; // 직사각혀의 세로 길이
    // constructor - 기본 생성자, argument 2개를 갖는 생성자
    public Rectangle() {
        
    }
    
    public Rectangle(double 가로, double 세로) {
        this.가로 = 가로;
        this.세로 = 세로;
    }
    // method - 둘레 길이, 넓이 
    
    public double 둘레() {
        double 둘레 = 2*(this.가로+this.세로);
        return 둘레;
    }
    
    public double 넓이() {
        double 넓이 = this.가로*this.세로;
        return 넓이;
    }
}
