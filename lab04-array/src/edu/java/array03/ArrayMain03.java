package edu.java.array03;

import java.util.Random;

public class ArrayMain03 {

    public static void main(String[] args) {
        // Random 객체를 선언, 생성
        Random rd = new Random();
        // 정수 10개를 저장할 수 있는 배열(scores)
        int [] scores = new int[10];
        // 배열 scores에 0 이상 10이하의 난수 10개를 저장.
        for(int i=0; i<scores.length; i++ ) {    
            scores[i]=rd.nextInt(11);
        }
        // 배열 scores에 저장된 모든 점수들의 합계를 계산하고 출력.
        int sum=0;     // 합계
        int count=0;   // 배열의 원소의 개수
        for(int i=0; i<scores.length; i++) {
            sum+=scores[i];                   //합계 계산
            count++;
        }
        System.out.println("합계 = "+ sum);   //합계 출력 
        // 배열 scores에 저장된 모든 점수들의 평균을 소수점까지 계산 후 출력.
        double avg =(double)sum/count;        //평균 계산
        System.out.println("평균 = " + avg);  //평균 출력

    }

}
