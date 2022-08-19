package edu.java.loop04;

public class LoopMain04 {

    public static void main(String[] args) {
        // 반복문에서 break vs continue
        // break : 반복문 블록을 실행 중에 break를 만나면, break가 포함된 가장 가까운 반복문블록을 종료한다.
        // continue : 반복문 블록을 실행 중에 continue를 만나면, continue 아래의 코드는 무시하고 그 다음 반복 과정을 계속 수행
        
        for(int i =1; i<=5; i++) {
            if(i == 3) {
                break;
            }
            System.out.println(i);
        }
        
        System.out.println("------------");
        
        for(int i=1; i<=5; i++) {
            if(i==3) {
                continue;
            }
            System.out.println(i);
        }
        
    }

}
