package edu.java.method06;

public class MethodMain06 {

    public static void main(String[] args) {
        // 가변인수 (variable argument) : 개수가 정해져 있지 않은 argument.
        
        System.out.printf("scores[%d] \n",1);
        System.out.printf("scores[%d]> %d \n",2,100);
        System.out.printf("%s[%d]> %f \n","scores",3,12.3);
        
        
        // 가변 인수를 갖는 메서드 정의 :
        // 가변 인수를 저장하는 파라마터는 "변수타입 ... 변수이름" 형식으로 선언.
        // 가변 인수는 메서드 안에서는 배열처럼 취급.
        // (주의) 가변 인수를 저장하는 파라미터는 반드시 가장 마지막 파라미터로 선언.
        // (주의) 가변 인수는 2개 이상 정의할 수 없음.
        
        System.out.println();
        System.out.println(addAllIntegers());
        System.out.println(addAllIntegers(1));
        System.out.println(addAllIntegers(1,2,3));
        
        
        System.out.println();
        System.out.println(caculate("%"));
        System.out.println(caculate("+", 1,2,3));
        System.out.println(caculate("*", 2,3,4));
    }
    public static int addAllIntegers(int...args) {
        int sum =0;
        for(int x : args) {
            sum+=x;
        }
        return sum;
    }

    /**
     * op가 "+"인 경우에는 모든 가변 인수들의 합계를 반환하고,
     * op가 "*"인 경우에는 모든 가변 인수들의 곱을 반환.
     * 만약 op가 "+" 또는 "*" 가 아닌 경우에는 무조건 0을 반환
     * @param op "+" 또는 "*"
     * @param args 슷자(double)
     * @return 
     */
    public static double caculate(String op, double...args) {
        if(op=="+") {
            double sum=0;
            for(double x : args) {
                sum+=x;
            }
            return sum;
        }else if(op=="*") {
            double multiply=1;
            for (double x : args) {
                multiply *= x;
            }
            return multiply;
        }else {
            return 0;
        }
    }
}
