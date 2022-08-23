package edu.java.loop07;

public class LoopMain07 {

    public static void main(String[] args) {
        // do-while 반복문
        int n=1;
        do {
            System.out.print(n+"\t");
            n++;;
        }while(n<=5);
        
        System.out.println();
        // while 문은 반복을 시작하기 전에 (반복) 조건을 먼저 검사하기 때문에,
        //실행 블록[,,,]이 한 번도 실행되지 않는 경우가 있을 수 있음.
        
        //do-while 문에서는 무조건 실행 블록을 먼저 한 번 실행하고 난 후 
        // 반복을 계속할 지 조건 검사를함.
        n=5;
        do {
            System.out.println(n);
            n--;
        }while(n<0);
            System.out.println("end do-while");
        

    }

}
