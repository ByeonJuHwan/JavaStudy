package edu.java.switch01;

public class SwitchMain01 {

    public static void main(String[] args) {
        
        String weekday = "월";
        switch (weekday) {
        case "월":
            System.out.println("ㅠㅠ");
            break;
        case "화":
        case "수":
        case "목":
            System.out.println("..ㅠㅠ");
            break;
        case "금":
            System.out.println("!!!!");
            break;
        case "토":
        case "일":
            System.out.println("^^");
            break;
        default:            
            System.out.println("><");
        }
        
        // switch - case 구문은 해당 케이스 위치로 이동해서 break를 만날 때까지 실행.
        // case에서 사용가능한 값의 타입은
        // (1) 정수 : byte, short, int, long, char
        // (2) 문자열 : String
        // (3) enum
        // (주의) 실수 타입 (float, double)은 switch - case 에서 사용할 수 없음.
    }
}
