package edu.java.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        
        //중첩 반복문
        //for 중첩문
        for(int i=2; i<10; i++) {
            for(int n=1; n<10; n++) {
                System.out.println(i + " x " + n + " = " + i*n);
            }
            System.out.println("------");
        }
        
        // while 중첩문
       
        int i=2;
        while(i<10) {
            int j=1;
            while(j<10) {
                System.out.println(i+" x "+ j+ " = "+(i*j));
                j++;
            }
            i++;
            System.out.println("----");
        }
        
        System.out.println();
        
        // 2단은 2x2 까지, 3단은 3x3까지, 4단은 4x4까지 ... 9단은 9x9까지 출력
        int x=2;
        while(x<10) {
            int y = 1;
            while(y<=x) {
                System.out.println(x + " x " + y + " = " + (x*y));
                y++;  
            }
            x++;
            System.out.println("----");
        }
        
        //for문 사용 방법
        System.out.println("---for문 사용---");
        
        for(int z=2; z<10; z++) {
            for(int c=1; c<=z; c++) {
                System.out.println(z + " x " + c + " = " + (z*c));
            }
            System.out.println("----");
        }
        
        // for문에 break를 넣는법
        System.out.println("---for문 + break문---");
        System.out.println();
        for(int z =2; z<10; z++) {
            for(int c=1; c<10; c++) {
                System.out.println(z + " x " + c + " = " + (z*c));
                if(z==c) {
                    break;
                }
            }
            System.out.println("----");
        }
    
    }

}
