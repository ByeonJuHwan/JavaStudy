package edu.java.lambda01;


// 인터페이스를 구현하는 구현 클래스 (외부)클래스
public class Adder implements Calculable {

    @Override
    public double calculate(double x, double y) {
        
        return x+y;
    }

}
