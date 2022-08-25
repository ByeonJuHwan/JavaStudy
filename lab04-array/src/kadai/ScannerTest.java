package kadai;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // 시스텀의 입력장치를 이용하는 Scanner 객체를 만듦
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("점수 입력> ");
        int n = scanner.nextInt();       // 시스템 입력장치 (콘솔창) 에서 정수를 읽음.
        // nextInt() : 토큰(공백, 탭, 줄바꿈 으로 구분되는 문자열) 단위로 읽어서 정수로 변환.
        scanner.nextLine();
        System.out.println("n = "+ n);
        
        System.out.print("정수 입력> ");
        n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("n = "+ n);
        
        System.out.print("문자열 입력> ");
        String s = scanner.next();
        // next() : 토큰(공백, 탭, 줄바꿈 으로 구분되는 문자열) 단위로 읽어서 문자열로 변환.
        scanner.nextLine();
        System.out.println("s = "+s);
        
        System.out.print("문자열 입력> ");
        s = scanner.nextLine();
        // nextLint() : 줄바꿈까지 읽음. 입력 버퍼를 지움.
        System.out.println("s = " + s);
        
        
        
        // 입력버퍼에서는 줄바꿈까지 문자열로 읽고,
        // 읽어들인 문자열을 원하는 타입(int, double, ...) 으로 변환.
        
        System.out.print("정수 입력> ");
        s = scanner.nextLine();   // 줄바꿈까지 문자열 읽음.
        n = Integer.parseInt(s);  // 문자열을 정수 (int)로 변환.
        System.out.println("n = " + n);
        // 해결 방법 : nextInt() 뒤에 nextLine() 으로 뒤에 남아있는 엔터를 버려벼린다.
        scanner.close();
    }

}
