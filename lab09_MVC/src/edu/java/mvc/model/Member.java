package edu.java.mvc.model;


// Model. VO(Value Object), DTO(Data Transfer Object)
public class Member {
    
    // field
    private String memberId;
    private String memberPassword;
    
    // 생성자 constructor
    public Member() {}
    
    
    public Member(String memberId, String memberPassword) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }

    // getters / setters
    public String getMemberId() {
        return memberId;
    }


    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


    public String getMemberPassword() {
        return memberPassword;
    }


    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
    
    @Override
    public String toString() { 
        return String.format("Member(memberId=%s,memberPassword=%s", memberId, memberPassword);
    } 
    
}
