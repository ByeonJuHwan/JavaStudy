package edu.java.wrapper;

import java.math.BigDecimal;

// Wrapper 클래스 : 자바의 기본 데이터 타입의 값을 하나만 저장하는(감싸는) 클래스.
// 자바의 기본 타입 : boolean, byte, short, int ,long , char, float, double
// wrapper 클래스 : Boolean, Byte, Short, Integer, Long, Character, Float, Double
// wrapper 클래스들은 java.lang 패키지에 포함되어 있음 -> import 문장 없이 사용 가능.
// wrapper 클래스를 사용하는 목적 : 
// 1. 기본 타입 데이터들을 이용하는 메서드를 제공.
// 2. 상속/다형성을 사용하기 위해서.
// 3. generic 클래스에서 사용하기 위해서.


public class WrapperMain {

    public static void main(String[] args) {
        // Integer 타입의 객체 생성 
        Integer number1 = Integer.valueOf(100); // int --> Integer (Wrapper 클래스)
        System.out.println(number1);
        
        Integer number2 = Integer.valueOf("10"); // String -> Integer
        System.out.println(number2);
        
        int x = Integer.parseInt("123"); // String -> int (기본 타입)
        System.out.println(x);
        
        
        // auto-boxing , auto-unboxing
        Integer number3 = 1;  // auto - boxing: int 타입의 값을 Integer 타입의 객체로 자동변환.
        System.out.println(number3);
        
        int add = number1 + number2; // auto - unboxing : Integer 타입 객체를 int 타입으로 자동변환.
        System.out.println(add);
        
        // float, double 타입은 소수점 이하 오차가 생길 수 있음.
        double d1 = 1.1;
        double d2 = 0.9;
        System.out.println(d1-d2); // 0.2
        
        // double 타입의 오차를 원하는 수준까지 작게 줄일 수 있는 클래스 - BigDecimal
        BigDecimal big1 = new BigDecimal("1.1"); // 생성자 호출 -> 객체생성
        BigDecimal big2 = new BigDecimal("0.9");
        System.out.println("big1 = " + big1);
        System.out.println("big2 = " + big2);
        System.out.println(big1.subtract(big2)); // 메서드 호출 -> 산술 연산(+,-,*,/)
        // BigDecimal 클래스는 wrapper 클래스(Double) 의 auto-boxing/unboxing 기능이 없음.
        

    }

}
