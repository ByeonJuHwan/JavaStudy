package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

    private Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
    
        ExceptionMain03 app = new ExceptionMain03();
        
        int x = app.inputInteer();
        System.out.println("x = " + x);
        

    }

    
    private int inputInteer() {
        // TODO : Scanner를 사용해서 입력받은 정수를 리턴.
        // Integer.parseInt(), scanner.nextLine() 사용
        // NumberFormatException을 처리
        int x = 0;
        boolean run = true;
        while(run) {
        try {
            System.out.print("정수를 입력해주세요>> ");
            x= Integer.parseInt(sc.nextLine());
            run=false;
        }catch(NumberFormatException e) {
            System.out.println(e.getMessage());
        }
            
        }
        
        return x;
        
    }
    
    
}
