package edu.java.method02;

public class MethodMain02 {
    /**
     * 숫자 두개를 전달받아서, 두 숫자의 뎃셈 결과를 반환.
     * @param x double
     * @param y double
     * @return 뎃셈 결과.
     */
    public static double add(double x, double y) {
        return x+y;
    }
    /**
     * 숫자 두개를 전달받아서, 두 숫자의 뺄셈 결과를 반환.
     * @param x double
     * @param y double
     * @return 뺄셈 결과.
     */
    public static double subtract(double x, double y) {
        return x-y;
    }
    /**
     * 숫자 두개를 전달받아서, 두 숫자의 곱셈 결과를 반환.
     * @param x double
     * @param y double
     * @return 곱셈 결과
     */
    public static double multiply(double x, double y) {
        return x*y;
    }
    /**
     * 숫자 두개를 전달받아서, 두 숫자의 나눗셈 결과를 반환.
     * @param x double
     * @param y double
     * @return 나눗셈 결과
     */
    public static double devide(double x, double y) {
        return x/y;
    }
    
    public static void main(String[] args) {
        // 리턴 타입과 argument를 갖는 메서드 작성/호출 연습
        double result = add(2,3);
        // return : (1) 메서드를 호출한 곳에 값을 반환. (2) 메서드 종료.
        System.out.println(result);
        
        result = subtract(2,3);
        System.out.println(result);
        
        result = multiply(2,3);
        System.out.println(result);
        
        result = devide(2,3);
        System.out.println(result);
    }

}
