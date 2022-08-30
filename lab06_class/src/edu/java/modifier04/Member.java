package edu.java.modifier04;

/*
 * field : 아이디, 비밀번호
 * constructor  : argument 2개를 갖는 생성자.
 * method : 아이디 getter, 비밀번호 getter / setter
 */
public class Member {
    private String id;
    private String pw;
    
    public Member(String id, String pw) {
        this.id=id;
        this.pw=pw;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getPw() {
        return this.pw;
    }
    
    public void setPw(String pw) {
        if(pw==null) {
            System.out.println("비밀번호를 입력해주세요");
        }else {
            this.pw=pw;
        }
    }
}
