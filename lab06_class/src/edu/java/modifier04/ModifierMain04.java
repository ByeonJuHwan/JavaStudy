package edu.java.modifier04;

public class ModifierMain04 {

    public static void main(String[] args) {
        Member member = new Member("byeon","1234");
        
        System.out.println(member.getId());
        System.out.println(member.getPw());
        member.setPw("1234111");
        System.out.println(member.getPw());
        member.setPw(null);
        

    }

}
