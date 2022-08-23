package kadai;

import java.util.Random;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

public class kadai0822 {

    public static void main(String[] args) {
        
        // 2번 문제
        int sum=0;
        for(int i=1; i<101; i++) {
            if(i%3==0) {
                sum+=i;
            }
        }
        System.out.println("3의배수의합은 ="+sum);
        
        System.out.println("-----");
        
        //3번
        Random rd = new Random();
        
        while(true) {
            int a = rd.nextInt(7);
            int b = rd.nextInt(7);
            if(a+b==5) {
                System.out.println("눈1 :" + a + ", " + "눈2 :" + b);
                break;
            }else {
                System.out.println("눈1 :" + a + ", " + "눈2 :" + b);
            }
        }
        
        System.out.println("-----");
        
        // 4번
        
        for(int i=1; i<11;i++) {
            for(int j=1; j<11; j++) {
                if((4*i)+(5*j)==60) {
                   System.out.println("("+i+","+j+")"); 
                }
            }
        }
        
        System.out.println("-----");
        //5번
        for(int i=1; i<5; i++) {
            for(int j=1; j<5; j++) {
                System.out.print("*");
                if(i==j) {
                    break;
                }
            }
            System.out.println();
        }
        
        System.out.println("-----");
        
        //6번
        for(int i=4; i>0; i--) {
            for(int j=1; j<5; j++) {
                if(j<i) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        // 7번
        boolean run =true;
        int balance =0;
        Scanner scanner = new Scanner (System.in);
        while(run) {
            System.out.println("-------------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> ");
            balance = scanner.nextInt();
            switch (balance) {
            case 1:
                System.out.println("예금액>10000");
                break;
            case 2:
                System.out.println("출금액>2000");
                break;
            case 3:
                System.out.println("잔고>8000");
                break;
            case 4:
                run=false;
                break;
            }
            System.out.println();
        
        }
        scanner.close();
        System.out.println("프로그램 종료");
    }

}
