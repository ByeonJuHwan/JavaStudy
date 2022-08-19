package edu.java.loop01;

public class LoopMain01 {

    public static void main(String[] args) {
        // 반복문
        for(int i=0; i<3; i++) {
            System.out.println(i);
        }
        
        // 증가 연산자 (++), 감소 연산자(--) : 변수의 값을 1증가/감소.
        
        // 10 부터 1까지 내림차순으로 출력
        for(int i=10; 0<i; i--) {
            System.out.println(i);
        }
        
        // 지역 변수 (local variable) : 메서드 안에서 선언한 변수.
        // 지역 변수는 선언된 곳에서부터 변수가 속한 블록({...}) 안에서만 사용 가능.
        
    }

}
