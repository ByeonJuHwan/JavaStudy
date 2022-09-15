package edu.java.list04;



public class User {
    private String userID;
    private String password;
   
    // 생성자 : (1) 기본생성자, (2) arguments 2개를 같는 생성자
    public User() {};
    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }
    
    // getters / setters
    
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
   
    @Override
    public String toString() {
       
        return String.format("아이디는 %s 입니다. 비밀번호는 %s 입니다.", userID, password );
    }
}
