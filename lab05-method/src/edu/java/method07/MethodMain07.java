package edu.java.method07;

public class MethodMain07 {

    public static void main(String[] args) {
        // 재귀 메서드 : 메서드 안에서 자기 자신을 다시 호출하는 경우.
        for(long n = 0; n<6; n++) {
            System.out.println(n + " != " + factorial(n)+" , "+factorial2(n));
        }
        

    }
    public static long factorial(long n) {
        long result = -1;
        if(n == 0) {
            result = 1;
        }else if (n>0) {
            result = factorial(n-1)*n;
        }
        
        
        return result;
    }

    public static long factorial2(long n) {
        long result = -1;
        if(n == 0) {
            result = 1;
        }else if(n>0) {
            result =1;
            for(long i =1; i<=n; i++) {
                result *=i;
            }
        }
        
        return result;
    }
}
