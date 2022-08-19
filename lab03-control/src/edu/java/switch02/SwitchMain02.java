package edu.java.switch02;

public class SwitchMain02 {

    public static void main(String[] args) {
       
        int n = 123;
        
        switch (n % 2) {
        case 0:
            System.out.println("짝수");
            break;
        case 1:
            System.out.println("홀수");
            break;
        }
        
        switch (n % 2) {
        case 0:
            System.out.println("짝수");
            break;
        default:
            System.out.println("홀수");
        }

    }

}
