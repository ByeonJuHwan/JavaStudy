package edu.java.modifier03;

public class Person {
    // field(멤버 변수)
    private String name;
    private int age;
    
    
    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        if(age<0) {
            System.out.println("나이는 0보다 작을수 없습니다.");
        }else {
            this.age = age;
        }
        
    }
}
