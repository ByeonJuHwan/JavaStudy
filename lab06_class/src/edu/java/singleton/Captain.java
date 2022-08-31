package edu.java.singleton;

// 싱글톤(singleton) : 오직 한 번만 생성될 수 있는 객체.
// singleton : (1) private static field + (2) private constructor + (3) public static method 

public class Captain {
    // (1) private static field
    private static Captain instance = null;
    
    private String name ="캡틴 아메리카";
    
    // (2) private 생성자
    // -> 다른 클래스에서 생성자가 안 보임. -> 다른 클래스에서는 객체를 생성할 수 없다.
    private Captain() {
        
    }
    
    // (3) public static Captain 타입을 리턴하는 메서드
    public static Captain getInstance() {
        if(instance == null) {
            instance = new Captain();
        }
        
        return instance;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name=name;
    }
}
