package edu.java.class04;

public class ClassMain04 {

    public static void main(String[] args) {
        // 기본 생성자
        Circle circle = new Circle();
        System.out.println("반지름 = " + circle.r);
        
        // method 사용
        System.out.println("원의 둘레 = " + circle.둘레());
        System.out.println("원의 넓이 = " + circle.넓이());
        
        // argument를 갖는 생성자
        Circle circle1 = new Circle(5);
        System.out.println("반지름 = " + circle1.r);
        
     // method 사용
        System.out.println("원의 둘레 = " + circle1.둘레());
        System.out.println("원의 넓이 = " + circle1.넓이());
        
    }

}
