package edu.java.method03;

public class MethodMain03 {

    public static void countdown(int n) {
        
        if(n<0) {
            System.out.println("n은 0이상의 정수여야함.");
            return; // 메서드 종료
        }
        
        for(int i=n; 0<=i; i--) {
            System.out.println(i);
        }
    }
    
    
    public static void main(String[] args) {
        countdown(-15);

    }

}
