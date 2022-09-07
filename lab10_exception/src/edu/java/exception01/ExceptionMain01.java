package edu.java.exception01;

import java.util.Scanner;

// 오류(error) vs 예외(exception)
// 오루(error)의 종류 :
// 1. 시스템에러 : 예)  OOM(Out-Of-Memory, 메모리 부족) -> 수정 불가능. 수정 힘듦.
// 2. 컴파일(compile) 에러 : 문법 오류. -> 반드시 수정!
// 3. 논리적인 오류 : 프로그램이 정상적으로 컴파일되고 실행/종료가 되지만 원하는 결과가 나오지 않는 경우
//    -> 반드시 수정. 수정 힘듦.
// 4. 예외(exception) : 프로그램 실행 중에 발생할 수 있는 비정상적인 상황 -> 반드시 수정.
//    -> (1) if - else 문장
//    -> (2) try - catch 문장

public class ExceptionMain01 {

    public static void main(String[] args) {
        
        String s = null;
        if(s == null) {
            System.out.println("null 문자열");
        }else {
            System.out.println("s의 길이 = " + s.length());
        }
        
        
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("x = ");
        int x = Integer.parseInt(sc.nextLine());
        
        System.out.print("y = ");
        int y = Integer.parseInt(sc.nextLine());
        
        if(y == 0) {
            System.out.println("0으로는 나눌수 없습니다.");
        }else {
            int result = x/y;
            System.out.println("몫 = " + result);
        }
        
        

    }

}
