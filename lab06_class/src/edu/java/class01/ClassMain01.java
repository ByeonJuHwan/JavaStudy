package edu.java.class01;

public class ClassMain01 {

    public static void main(String[] args) {
        // User 클래스 타입으로 변수 선언, 객체 생성, 초기화.
        User user1 = new User();
        System.out.println(user1);
        System.out.println(user1.age);
        System.out.println(user1.password);
        System.out.println(user1.userId);
        
        System.out.println();
        System.out.println("--------");
        
        user1.userId = "admin";
        user1.password = "1234";
        user1.age = 16;
        
        System.out.println(user1);
        System.out.println(user1.age);
        System.out.println(user1.password);
        System.out.println(user1.userId);
        
        System.out.println();
        System.out.println("--------");
        
        User user2 = new User("변주환", "1234", 25);
        System.out.println(user2.age);
        System.out.println(user2.password);
        System.out.println(user2.userId);
        
        System.out.println();
        System.out.println("--------");
        
        User user3 = new User("손흥민");
        System.out.println(user3.age);
        System.out.println(user3.password);
        System.out.println(user3.userId);
        
    }

}
