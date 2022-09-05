package edu.java.interface02;

// 인터페이스가 가질 수 있는 멤버들 - Java 8 버전 이후의 변경.
// 1. [public static final] 필드(멤버 변수)
// 2. [public abstract] 메서드 : body가 없는 추상 메서드.
// 3. [public] default 메서드 : body({...}) 가 구현된 메서드 . Java8 버전부터.
//    -> 인터페이스를 구현하는 (하위)클래스의 객체를 생성한 후에 참조 변수를 이용해서 호출(사용)하는 메서드.
// 4. [public] static 메서드 : body가 구현된 static 메서드. Java8 버전부터.
//    -> 객체 생성 없이 인터페이스 이름으로 참조해서 호출(사용)하는 메서드.
// 5. private static 메서드 : body가 구현된 static 메서드. Java 9 버전부터.
//    -> 인터페이스의 [public] static, [public] default 메서드 안에서만 사용하기 위한 목적의 메서드.
// 6. private 메서드 : body 가 구현된 메서드.
//    -> 인터페이스의 [public] default 메서드 안에서만 사용하기 위한 목적의 메서드.

interface Test{
    // 1.[public static final] 필드
    int VESION = 1;
    
    // 2.[public abstract] 메서드
    void test();
    
    // 3.[public] default 메서드 - Java8 부터
    default void defaultMethod() {
        System.out.println("공개 디포트 메서드");
        privateMethod();  // default 메서드 안에서는 사용 가능하다 
    }
    
    // 4.[public] static 메서드 - Java8 부터
    static void staticMthod() {
        System.out.println("공개 static 메서드");
        praivateStaticMethod(); // static 메서드 안에서 사용하기위해 만들었다.
    }
    
    // 5.private static 메서드 - Java9부터
    private static void praivateStaticMethod() {
        System.out.println("비공개 static 메서드");
    }
    
    // 6. private 메서드 - Java9 부터
    private void privateMethod() {
        System.out.println("비공개 이미 구현된 메서드");
    }
    
}


// Test 인터페이스를 구현하는 (하위) 클래스
class TestImpl implements Test{

    @Override
    public void test() {
        System.out.println("test 구현 메서드");
        
    }
    
}


public class InterfaceMain02 {

    public static void main(String[] args) {
        // 인터페이스의 [public] static 멤버 사용
        System.out.println(Test.VESION);
        Test.staticMthod();
        
        System.out.println();
        
        // 인터페이스의 [public] default 멤버 사용
        Test test = new TestImpl();
        test.defaultMethod();
        
        System.out.println();
        
        // 인터페이스의 [public abstract] 메서드 사용 - 구현된 메서드가 있어야.함
        test.test();
        
        
        
    }

}
