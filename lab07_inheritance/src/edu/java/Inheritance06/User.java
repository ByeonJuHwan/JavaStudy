package edu.java.Inheritance06;

public class User {
    // field : 사용자 아이디, 비밀번호
    private String id;
    private String pwd;
   
    // 생성자 : 기본생성자, argument 2개를 갖는 생성자
    
    public User() {}
    
    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    // getters / setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    // toString() 재정의 : User 객체를 출력할 때 아이디와 비밀번호가 출력될 수 있도록.
    // print 할때 print(user1) 을 했을때 바로 id와 비밀번호를 보고싶을때 toString() 오버라이드를 한다.
    
    @Override
    public String toString() {
        String user = String.format("id = %s , pwd = %s", this.id,this.pwd);
        return user;
        // 다른방법으로 return "id = " + thsi.id + ", pwd = " + this.pwd`
    }
    
    // equals() 재정의 : 아이디가 일치하는 User 객체는 같은 객체.
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if(obj instanceof User) {
            User us = ((User)obj);
            result=this.id.equals(us.id);
        }
          
        return result;
    }
    
    // hashCode() 재정의 : 아이디가 같으면 hashCode(int)도 같으면된다.
    
    @Override
    public int hashCode() {
        return this.id.hashCode();  // 아이디가 같으면 내가 가지고있는 this의 hashCode 값을 리턴만해주면된다.
    }
}
