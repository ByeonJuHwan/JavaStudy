package edu.java.class03;

public class ClassMain03 {

    public static void main(String[] args) {
        // Rectangle 타입 변수 선언, Rectangle 객체 생성 저장.
        // 1) 기본 생성자 이용
        Rectangle rt = new Rectangle();
        
        System.out.println("rt 가로 = " + rt.가로 );
        System.out.println("rt 세로 = " + rt.세로 );
        
        // Rectangle 객체의 메서드 테스트.
        System.out.println("rt 둘레 = " + rt.둘레());
        System.out.println("rt 넓이 = " + rt.넓이());
        
        // 2) argument 2개를 갖는 생성자를 이용.
        Rectangle rt1 = new Rectangle(3,4);
        
        System.out.println("rt1 가로 = " + rt1.가로 );
        System.out.println("rt1 세로 = " + rt1.세로 );
        
        // Rectangle 객체의 메서드 테스트.
        System.out.println("rt1 둘레 = " + rt1.둘레());
        System.out.println("rt1 넓이 = " + rt1.넓이());
        
       
        
    }

}
