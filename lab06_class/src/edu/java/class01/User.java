package edu.java.class01;


// 클래스 : 데이터 + 기능 ==> 데이터 타입
public class User {
    // 객체가 가지는 속성들 (데이터)
    
    String userId;
    String password;
    int age;

    // 생성자 (constructor)
    // 객체를 메모리에 생성하고 초기화해 주는 기능을 담당.
    // 모든 클래스는 생성자가 적어도 하나 이상은 있어야 함.
    // 클래스를 작성할 때 생성자를 하나도 정의하지 않으면, 자바 컴파일러가 기본 성생자를 자동으로 만들어 준다.
    // 클래스를 작성할 때 생성자를 정의하면, 자바 컴파일러는 기본 생성자를 자동으로 만들지 않는다.
    // 생성자의 이름은 클래스 이름과 동일. 생성자는 리턴 타입 사용하지 않음!
    
    // 기본 생성자 (default constructor) - argument를 갖지 않는 생성자
    // 모든 속성들은 그 타입의 기본값으로 초기화를 해준다.
    // 숫자 타입 기본값 : 0 , boolean 타입 기본값 : false, 참조 타입 기본값 : null
    public User() {         // constructor - 1
        // Do nothing.
    }
    
    // argument를 갖는 생성자
    public User (String userId, String password, int age) {     // constructor - 2
        this.userId = userId;
        this.password = password;
        this.age = age;
    }
    
    public User(String userId, String password) {      // constructor - 3
        // this.userId = userId;
        // this.password = password;
        this(userId,password,0);       // constructor - 2 호출
    } 
    
    public User(String userId) {   // constructor - 4
        this(userId,null,0);  // constructor - 2 호출 
    }
    
    // 생성자 오버로딩(overloading) : 파라미터가 다른 생성자를 여러개 정의하는 것.
    
    // this의 의미 : 
    // (1) 생성된 객체의 주소 : (예) this.userId, this.password, ...
    // (2) 생성자 : overloading된 다른 생성자를 사용할 때
}
