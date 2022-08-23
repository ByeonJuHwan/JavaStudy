package edu.java.array01;

public class ArrayMain01 {

    public static void main(String[] args) {
        // 배열(array) : 같은 타입의 데이터 여러개를 하나의 변수 이름으로 저장하기 위한 메모리 공간.
        // 인덱스(index) : 배열에 데이터를 저장하거나, 저장된 값을 읽어올 때 사용하는 정수.
        // 배열의 인덱스는 0부터 시작하는 연속된 정수.
        // 배열의 마지막 인덱스는 (배열의 원소 개수 -1).
        
        // 배열 선언 / 사용 방법 1 : 
        // 어떤 타입의 값들을 몇 개까지 저장하는 배열인 지 선언.
        int[] scores = new int [4];
        scores[0] = 10; //배열이름[인덱스] = 값;
        scores[1] = 5;
        scores[2] = 8;
        scores[3] = 3;
        System.out.println(scores[0]); // 배역이름[인덱스]
        System.out.println("------");
        for(int i =0; i<scores.length; i++) {
            System.out.println(scores[i]);
        }
        System.out.println("------");
        // 배열 선언 / 사용 방법 2 : 배열의 원소들을 나열하면서 배열을 초기화.
        // 타입[] 배열이름 = { .... };
        int [] numbers = {1,3,4,5,6};
        for(int i =0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("------");
        // 향상된 for 문 (enhanced for statement). for - each 문장.
        for(int n : numbers) {
            System.out.println(n);
        }
    }

}
