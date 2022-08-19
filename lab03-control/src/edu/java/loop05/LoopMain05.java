package edu.java.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 1~100 까지 삼육구 한줄에 10개씩 출력 박수부분에서는 * 출력
      
        for(int i=1; i<101; i++) {
            if(i%10==0) {
                if(i%30==0) {
                    System.out.print("*"+"\n");
                    continue;
                }
                System.out.print(i);
                System.out.println();
            }else if(i%10 ==3) {
                System.out.print("*"+"\t");
            }else if(i%10 == 6){
                System.out.print("*"+"\t");
            }else if(i%10 ==9) {
                System.out.print("*"+"\t");
            }else if (i%30 <10) {
                if(i>10) {
                    System.out.print("*"+"\t");
                }else {
                    System.out.print(i+"\t");
                }
            }
               
            
            else {
                System.out.print(i+"\t");
            }
        }
        
        
    }

}
