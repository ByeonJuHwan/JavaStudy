package edu.java.method05;

public class MethodMain05 {

    public static int sum(int [] scores) {
        int sum =0;
        for(int i=0; i<scores.length; i++) {
            sum+=scores[i];
        }
        return sum;
    }
    public static double mean(int [] scores) {
        int sum =sum(scores);
        
        double avg =0;
        avg=(double)sum/scores.length;
        return avg;
    }
    
    public static int max(int [] scores) {
        int max = scores[0];
        for(int i=0; i<scores.length; i++) {
            if(max<scores[i]) {
                max=scores[i];
            }
        }
        return max;
    }
    
    public static int min(int [] scores) {
        int min = scores[0];
        for(int i=0; i<scores.length; i++) {
            if(min>scores[i]) {
                min=scores[i];
            }
        }
        return min;
    }
    
    public static double bs (int [] scores) {
        double avg = mean(scores);
        double bbs;  //(값 -평균)
        double bbbs; //(값 -평균) 2제곱
        double sum = 0;
        for(int i=0; i<scores.length; i++) {
            bbs=(scores[i]-avg);    //(값 -평균)
            bbbs = Math.pow(bbs,2); //(값 -평균) 2제곱
            sum+=bbbs;              //(값 -평균) 2제곱 의 합
        }
        double bs = (double)sum/scores.length;  // 거듭제곱 / 배열의 길이
        return bs;
    }
    
    public static double ps (double bs) {
        double ps = Math.sqrt(bs);   // 분산의 제곱근
        return ps;
    }
    
    
    
    
    public static void main(String[] args) {
       // 메서드 작성 연습
    
        int[] scores = {70,60,100,50,80};
        
        int sum = sum(scores);
        System.out.println("총점 = " + sum);  // 360
        
        double avg = mean(scores);
        System.out.println("평균 = " + avg);  //72.0
        
        int max = max(scores);
        System.out.println("최댓값 = " + max); //100
        
        int min = min(scores);
        System.out.println("최솟값 = " + min); //50
        
        double bs = bs(scores);
        System.out.println("분산 = " + bs);
        
        double ps = ps(bs);
        System.out.println("표준편차 = " + ps);
        
    }

}
