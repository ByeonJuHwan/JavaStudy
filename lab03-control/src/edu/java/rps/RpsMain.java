package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain {

    public static void main(String[] args) {
        
        // 가위바위보 게임
        // 0 : 가위
        // 1 : 바위
        // 2 : 보
        
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        
        int x = rd.nextInt(3); // 상대
        
        System.out.println("0~2까지의 숫자를 입력해주세요.");
        int y = sc.nextInt();
        
        
        if(x==0) {
            if(y==0) {
                System.out.println("상대 : 가위");
                System.out.println("나 : 가위");
                System.out.println("비겼습니다.");
            }else if(y==1) {
                System.out.println("상대 : 가위");
                System.out.println("나 : 바위");
                System.out.println("이겼습니다.");
            }else if(y==2) {
                System.out.println("상대 : 가위");
                System.out.println("나 : 보");
                System.out.println("졌습니다.");
            }
        }else if (x==1) {
            if(y==0) {
                System.out.println("상대 : 바위");
                System.out.println("나 : 가위");
                System.out.println("졌습니다.");
            }else if(y==1) {
                System.out.println("상대 : 바위");
                System.out.println("나 : 바위");
                System.out.println("비겼습니다.");
            }else if(y==2) {
                System.out.println("상대 : 바위");
                System.out.println("나 : 보");
                System.out.println("이겼습니다.");
            }
        }else {
            if(y==0) {
                System.out.println("상대 : 보");
                System.out.println("나 : 가위");
                System.out.println("이겼습니다.");
            }else if(y==1) {
                System.out.println("상대 : 보");
                System.out.println("나 : 바위");
                System.out.println("졌습니다.");
            }else if(y==2) {
                System.out.println("상대 : 보");
                System.out.println("나 : 보");
                System.out.println("비겼습니다.");
            }
        }
    }

}
