package edu.java.condition02;

public class ConditionMain02 {

    public static void main(String[] args) {
        // 중첩 조건문
        
        double x = 0;
        
        // if-else if -else 문장
        if(x>0) {
            System.out.println("양수");
        } else if(x<0) {
            System.out.println("음수");
        } else {
            System.out.println("0");
        }
        
        if(x>0) {
            System.out.println("양수");
        } else {
            if(x<0) {
              System.out.println("음수");  
            } else {
                System.out.println("0");
            }
        }
        
        System.out.println("===end===");
    }

}
