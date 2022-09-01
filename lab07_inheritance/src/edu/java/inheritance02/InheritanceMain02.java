package edu.java.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        // Person 타입 객체를 기본 생성자를 사용해서 생성
        Person p1 = new Person();
        System.out.println(p1.getName());
        
        
        // Person 타입 객체를 argument를 갖는 생성자를 사용해서 생성.
        Person p2 = new Person("byeon");
        System.out.println(p2.getName());
     
        System.out.println("-------------");
        // Student 타입 객체를 기본 생성자를 사용해서 생성
        Student s1 = new Student();
        // subclass의 생성자를 호출하면 superclass의 생성자가 먼저 호출되고 난 후 subclass의 생성자가 호출됨.
        // 부모 타입 객체가 먼저 생성되야 자식 타입 객체도 생성된다.
        // subclass의 생성자에서 superclass의 생성자를 명시적으로 호출하는 코드가 없는 경우에는 
        // superclass의 기본 생성자가 자동으로 호출됨.
        // superclass의 argument가 있는 생성자는 자동으로 호출되지 않음.
        // superclass의 argument가 있는 생성자를 사용하려면 반드시 명시적으로 호출해야만 함.
        // super(..) 를 호출하는 코드는 생성자에서 가장 먼저 작성되어야 함.
        
        // this 의 의미 : (1) 생성된 자기자신 객체의 주소 : this.field, this.method(), (2) overloading된 생성자 : this()
        
        // super의 의미 :
        // (1) 생성된 부모 객체의 주소 : super.field, super.method()
        // (2) superclass의 생성자 : super(), super(...)
        
        // Student 타입의 객체를 argument 1개를 갖는 생성자로 생성.
        Student s2 = new Student("아이티윌"); 
        
        Student s3 = new Student("byeon","아이티윌");
        System.out.println(s3.getName());
        System.out.println(s3.getSchool());
            
        
    }
        
    
}
