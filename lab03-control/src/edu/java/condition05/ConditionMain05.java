package edu.java.condition05;

import java.util.Random;

public class ConditionMain05 {

    public static void main(String[] args) {
        //Random 타입 변수를 선언하고, 초기화
        Random random = new Random();
        // Java 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int java = random.nextInt(101);
        // SQL 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int sql = random.nextInt(101);
        // JSP 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int jsp = random.nextInt(101);
        // 세 과목의 평균을 계산.
        int sum = java+sql+jsp;
        double avg = sum/3.0;
        
        
        System.out.println("java = " + java);
        System.out.println("sql = " + sql);
        System.out.println("jsp = " + jsp);
        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
        
        
        
        
        // 모든 과목의 점수가 40점 이상이고, 평균이 60점 이상이면 '합격', 그렇지 않다면 '불합격' 출력.
        if((java>=40 && sql>=40 && jsp>=40) && (avg>=60)) {
            System.out.println("합 격");
        }else {
            System.out.println("불 합격");
        }
        
    }

}
