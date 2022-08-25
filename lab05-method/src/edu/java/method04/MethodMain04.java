package edu.java.method04;

public class MethodMain04 {
    
    
    public static void newLine() {
        System.out.println("*");
    }
    public static void newLine(int n) {
        for(int i=0; i<n; i++) {
            System.out.println("#");
        }
    }
    
//    int newLine() {
//        return 0;
//    }
    
    public static void main(String[] args) {
        // 메서드 오버로딩 (method overloading):
        // 메서드의 파라미터 타입, 개수가 다르면 같은 이름으로 메서드를 여러개 정의할 수 있음.
        // (주의) 파라미터는 동일하고 리턴 타입만 다르게 오버로딩할 수는 없음

        
        newLine(2);
        newLine();
    }

}
