package edu.java.lambda02;

import edu.java.lambda02.Calculator.Calculable;

public class LambdaMain02 {

    public static void main(String[] args) {
       
        Calculator adder = new Calculator(1, 2);
        double result = adder.calculate(new Calculable() {
            
            public double calculate(double x, double y) {
                
                return x+y;
            }
        });
        
        System.out.println("adder result = " + result);
        
        
        // 뺄샘을 계산하는 기능
        Calculator.Calculable subtracter = (x,y)->{return x-y;};
        result = subtracter.calculate(1, 2);
        System.out.println("subtracter result = " + result);
    
        
        
        // 곱셈을 계산하는 기능
        Calculator.Calculable multiplier = (x,y)->{return x*y;};
        result =  multiplier.calculate(1, 2);
        System.out.println("multiplier result = " + result);
        
        
        // 나눗셈을 계산하는 계산기
        Calculator.Calculable divider = (x,y)->{return x/y;};
        result = divider.calculate(1,2);
        System.out.println("divider result = " + result);
        
        // 두 숫자 중에서 더 크거나 같은 수를 찾는 계산기
        Calculator.Calculable greater = (x,y)->{return (x>=y) ? x :y;};
        result = greater.calculate(1, 2);
        System.out.println("greater result = " + result);
    }

}
