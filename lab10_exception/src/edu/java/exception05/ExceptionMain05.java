package edu.java.exception05;

public class ExceptionMain05 {

    public static void main(String[] args) {
        // multi - catch 블록 (Java 7 버전) :
        // 하나의 catch 구문에서 여러개의 Exception 클래스를 선언하고 예외를 처리하는 방법.
        // catch (Exception 1 | Exception2 | ... 변수이름){...}
        // nulti - cathch를 사용할 때는 상속 관계가 있는 클래스들을 함께 사용할 수 없음!
        // (예) catch(NullPointerException | Exception e ) - 컴파일에러!
        
        try {
            int x = 100;
            int y = 0;
            System.out.println("몫 = " + (x/y));
            
            String[] names = new String[0];
            names[0] = "변주환";
            System.out.println(names[0]);
        }catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
