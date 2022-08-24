package edu.java.array06;

public class ArrayMain06 {

    public static void main(String[] args) {
        // 2차원 배열 선언과 생성
        // 타입[][] 배열 이름 = new 타입[행의 개수][열의 개수];
        // 이때 열의 개수는 생량해도 되지만, 행의 개수는 생량하면 안됨!
        
        int[][] arr1 = new int [2][3];  //배열을 생성할때, 행과 열의 개수 모두 결정돈 경우
        for(int i=0; i<arr1.length; i++) {
            for(int j = 0; j<arr1[i].length; j++) {
                arr1[i][j] = i+j;
            }
            
        }
        for(int[] arr : arr1) {
            for( int x : arr) {
                System.out.print(x+"\t");
            }
            
        }
        System.out.println();
        System.out.println("----");
        // 2차원 배열을 만들때 , 행의 개수는 정해져 있으나 열의 개수가 결정되지 않은 경우
        int [][] arr2=new int [2][];
        
        arr2[0] = new int [2];
        arr2[0][0] = 1;
        arr2[0][1] = 2;
        
        arr2[1] = new int [3];
        arr2[1][0] = 3;
        arr2[1][1] = 4;
        arr2[1][2] = 5;
        
        for(int[] arr : arr2) {
            for(int x : arr) {
                System.out.print(x+"\t");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("----");
        
        // 정수들의 1차원 배열 2개를 원소로 갖는 2차원 배열을 선언.
        // 첫번째 1차원 배열에는 1,3,5,7,9 를 저장.
        // 2번째 1차원 배열에는 0,2,4,6,8,10을 저장.
        // 2차원 배열의 내용을 출력
        int [][] arr3 = new int [2][];
        
        arr3[0] = new int [5];
        
        int a = 1;
        for(int i=0; i<arr3[0].length; i++) {  // arr3[0][] 원소 입력
            arr3[0][i]= a;
            a+=2;
        }
        
        int b=0;
        arr3[1] = new int [6];
        for(int i=0; i<arr3[1].length; i++) {  // arr3[1][] 원소 입력
            arr3[1][i]= b;
            b+=2;
        }
        
        for(int[] arr : arr3) {              //arr3[][] 배열 출력
            for(int x : arr) {
                System.out.print(x+"\t");
            }
            System.out.println();
        }
        
    }

}
