package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {
        // Rectangle, Circle 클래스를 구현 
        // Rectangle, Circle 타입의 객체에서 draw() 메서드동작 여부 테스트

        Shape rec = new Rectangle("사격형");
        rec.draw();
        System.out.println("\n------------\n");
        Shape cir = new Circle("원");
        cir.draw();
        
        
    }

}
