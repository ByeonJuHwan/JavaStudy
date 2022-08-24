package edu.java.array07;

import java.util.Random;

public class ArrayMain07 {

    public static void main(String[] args) {
        // Chapter 6-2 Ex. 4 (p.200)
        
        // 정수 10개를 저장하는 배열 (array)을 선언
        int [] array = new int [10];
        
        // 배열에 난수( 0~ 10 ) 10개를 저장.
        Random rd = new Random();
        for(int i=0; i<array.length; i++) {
            array[i]=rd.nextInt(11);
        }
        for(int x : array) {
            System.out.print(x+"\t");   //배열 출력
        }
        System.out.println();
       
        // 배열에서 최댓값을 찾으세요. 
        int max = array[0];
        for(int i=0; i<array.length; i++) {
            if(max<array[i]) {      // 배열 비교
                max=array[i];       // max 초기화  
            }
        }
        
        System.out.println("최댓값은 : " + max);   //최댓값 출력
    }

}
