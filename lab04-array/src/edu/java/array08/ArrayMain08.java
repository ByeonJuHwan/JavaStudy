package edu.java.array08;

import java.util.Random;

public class ArrayMain08 {

    public static void main(String[] args) {
        // Ch. 6-2 Ex.5 (p.201)
        // 1차원 정수 배열 3개를 갖는 2차원 배열 선언
        int [][]array = new int [3][];
        
        Random rd = new Random();
        
        // 첫 번째 배열에는 난수 2개, 2번째 배열에는 난수 3개, 3번째 배열에는 난수 4개를 저장
        // 난수의 범위는 [70,100) 70이상 100미만
        
        for(int i=0 ; i<array.length; i++) {
            array[i] = new int [i+2];
            for(int j=0; j<array[i].length;j++) {
                array[i][j]= rd.nextInt(70, 101);
            }
        }
        System.out.println(array[0][0]);
        // 2차원 배열 array 의 모든 원소들 합 (sum)을 계산하고 출력.
        int sum=0;
        int count=0;
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length;j++) {
                sum+=array[i][j];
                count++;
            }
        }
        System.out.println("합계 : " +sum);
        System.out.println(count);
        // 2차원 배열 array의 모든 원소들의 평균(double)을 계산하고 출력. 
        double avg =0;
        avg=(double)sum/count;
        System.out.println("평균 : " + avg);
        
    }

}
