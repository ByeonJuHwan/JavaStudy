package edu.java.modifier03;

// 데이터 캡슐화 (encapsulation) :
// 멤버 변수(필드)들을 private으로 선언해서 클래스 외부에서 보이지 않도록 감추고,
// 대신에 필요한 경우에 한해서 public 으로 공개된 메서드를 제공해서 간접적으로 
// 멤버 변수들의 값을 읽거나 수정하도록 허용하는 프로그래밍 방법.
// 데이터의 보안과 무결성을 유지하기 위해서 캡슐화를 사용.
// getter 메서드 : private 멤버 변수의 값을 리턴하는 메서드.
// setter 메서드 : private 멤버 변수의 값을 변경하는 메서드.

public class ModifierMain03 {

    public static void main(String[] args) {
        // Person 타입의 객체 생성
        Person p = new Person("변주환", 10);
        System.out.println(p);
        System.out.println(p.getName());
        System.out.println(p.getAge());
        p.setAge(20);
        System.out.println(p.getAge());
        p.setAge(-10);
        System.out.println(p.getAge());
    }

}
