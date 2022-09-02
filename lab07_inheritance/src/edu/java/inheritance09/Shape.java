package edu.java.inheritance09;

public abstract class Shape {
    // field
    protected String type; // 사각형, 원, ...
    
    
    // 생성자
    protected Shape(String type) {
        this.type=type;
    }
    
    
    // 추상 메서드
    public abstract double area();  // 도형의 넓이를 리턴
    public abstract double perimeter(); // 도형의 둘레를 리턴
    
    
    // final 메서드
    public final void draw() {
        String info =  String.format("%s(넓이=%f, 둘레=%f)",type,area(),perimeter());
        System.out.println(info);
    }


    
}
