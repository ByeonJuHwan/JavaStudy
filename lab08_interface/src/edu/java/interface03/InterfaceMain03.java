package edu.java.interface03;

// 자바는 다중 상속을 지원하지 않음. 단이 상속만 지원함.
class A{}
class B{}
class C extends A{}  // 단일 상속
// class D extends A,B {} // 다중 상속 - 자바는 지원하지 않음!

// 자바의 클래스 구현하는 인터페이스의 개수는 제한이 없음.
interface E{}
interface F{}
class G implements E,F{} // 2개 이상의 인터페이스를 구현하는 클래스 선언.

// 인터페이스는 다른 인터페이스를 상속(extends) 할 수 있음.
// (주의) 인터페이스는 2개 이상의 인터페이스를 상속(다중 상속) 할 수 있음.

interface H extends E,F{}

// (주의) 인터페이스는 클래스를 상속할 수 없음!
// interface I extends A{} // 오류발생

interface Buyer {
    void buy();
    
    default void register() {
        System.out.println("구매자 등록");
    }
}

interface Seller {
    void sell();
    
    default void register() {
        System.out.println("판매자 등록");
    }
}

class User implements Buyer, Seller {
    @Override
    public void sell() {
        System.out.println("판매");
    }

    @Override
    public void buy() {
        System.out.println("구매");
    }
    
    // 2개의 인터페이스에 같은 signature를 갖는 메서드가 있다면 반드시 재정의(override).
    @Override
    public void register() {
        Buyer.super.register();
        Seller.super.register();
    }
}

public class InterfaceMain03 {

    public static void main(String[] args) {
        // User 타입의 객체를 생성
        User user = new User();
        user.buy();
        user.sell();
        
        // 다형성(polymorphism)
        Buyer user2 = new User();
        user2.buy();
        // user2는 Buyer라고 선언했기 때문에 
        // Buyer의 메서드는 보이지만 Seller의 메서드는 보이지 않음.
        // 하지만 실제 생성된 객체는 User 타입이기 때문에 
        // casting(타입 변환)을 하면 buy(), sell() 모두 사용 가능.
        if (user2 instanceof User) {
            ((User) user2).sell();
        }
        
        user2.register();
        
}
}
