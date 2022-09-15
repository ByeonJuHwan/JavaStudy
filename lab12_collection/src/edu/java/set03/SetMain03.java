package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet을 사용해서 0이상 10미만 범위의 정수 난수 5개를 저장. set 내용 출력
        HashSet<Integer> set = new HashSet<>();
        Random rd = new Random();
        
        while(set.size()<5) {
            set.add(rd.nextInt(0,10));
        }
        
        System.out.println(set);
        
    

    }

}
