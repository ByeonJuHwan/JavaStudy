package edu.java.modifier01;

public class ModifierMain01 {

    // 클래스 멤버 (필드, 생성자, 메서드)의 접근제한 수식어(access modifier)
    // 1. private : 선언된 클래스 내부에서만 직접 접근 (사용) 가능.
    // 2. (package) : 수식어가 없는 경우. 같은 패키지에 있는 클래스에서 직접 접근 (사용) 가능.
    // 3. protected : 같은 패키지에 있거나 또는 상속을 받는 하위 클래스에서 직접 접근 (사용) 가능.
    // 4. public : 어디서든 직접 접근 (사용) 가능.
    // 가시성(visibility) 범위 : private < (package) < protected < public
    public static void main(String[] args) {
        // AccessTest 타입 변수 선언, AccessTest 객체 생성.
        AccessTest test = new AccessTest(1,2,3,4);
        //test.a = 10; // private은 다른 클래스에서 보이지 않음 . 직접 접근 안됨!
        test.b=20; // package 멤버는 같은 패키지의 클래스에서 보임. 직접 접근가능
        test.printMembers(); // public 메서드를 이용해서 private 멤버 변수를 간접적으로 사용.

    }

}
