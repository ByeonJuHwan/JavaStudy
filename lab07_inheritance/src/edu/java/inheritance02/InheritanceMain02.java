package edu.java.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        // Person 타입 객체를 기본 생성자를 사용해서 생성
        Person p1 = new Person();
        System.out.println(p1.getName());
        
        
        // Person 타입 객체를 argument를 갖는 생성자를 사용해서 생성.
        Person p2 = new Person("byeon");
        System.out.println(p2.getName());
    }

}
