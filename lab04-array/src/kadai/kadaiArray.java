package kadai;

import java.util.Scanner;

public class kadaiArray {

    public static void main(String[] args) {
        boolean run =true;
        int studentNum = 0;
        int [] scores = null;
        Scanner scanner = new Scanner(System.in);
        
        while(run) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4. 분석 | 5.종료");
            System.out.println("--------------------------------------------------------------");
            System.out.print("선택> ");
            
            int selectNo = Integer.parseInt(scanner.nextLine());
            
            if(selectNo==1) {
                System.out.print("학생수> ");
                String studentNum1 = scanner.nextLine();
                studentNum = Integer.parseInt(studentNum1);
            }else if (selectNo == 2) {
                scores = new int [studentNum];
                for(int i=0; i<scores.length;i++) {
                    System.out.print("scores["+i+"]> ");
                    scores[i]=Integer.parseInt(scanner.nextLine());
                }
            }else if(selectNo==3) {
                for(int i=0; i<scores.length;i++) {
                    System.out.println("scores["+i+"]> "+ scores[i]);
                }
            }else if(selectNo==4) {
                int max =scores[0];
                for(int i=0; i<scores.length; i++) {
                    if(max<scores[i]) {
                        max=scores[i];
                    }                    
                }
                int sum=0;
                double avg=0;
                for(int i=0; i<scores.length; i++) {
                    sum+=scores[i];
                }
                avg=(double)sum/studentNum;
                
                System.out.println("최고점수 : " + max);
                System.out.println("평균점수 : " + avg);
            }else if (selectNo==5) {
                run = false;
                
            }
            
        }
        scanner.close();
        System.out.println("프로그램 종료");
    }

}
