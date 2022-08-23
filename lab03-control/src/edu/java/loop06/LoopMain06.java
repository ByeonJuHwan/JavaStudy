package edu.java.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // for 반복문
        for (int i=1; i<=5; i++) {
            System.out.println(i);
        }
        System.out.println("------");
        
        //while 반복문
        
        int i =1;
        while(i<=5) {
            System.out.println(i);
            i++;
        }
        
        System.out.println("----");
        //10부터 1까지 정수들을 내림차순으로 한 줄에 출력하세요
       int n=10;
        while(n>0) {
            System.out.print(n+"\t");
            n--;
        }
        System.out.println();
        System.out.println("--------");
        // 10이하의 양의 홀수들을 한 줄에 출력하세요. (1 3 5 7 9)
            int a=1;
            while(a<10) {
            System.out.print(a+"\t");
            a+=2;
        }
        
    }

}
