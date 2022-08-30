package edu.java.modifier01;

public class AccessTest {
    
    private int a;
    int b;
    protected int c;
    public int d;
    
    
    public AccessTest(int a, int b, int c, int d) {
        this.a =a;
        this.b =b;
        this.c =c;
        this.d =d;
    }
    
    public void printMembers() {
        System.out.println("a = " + this.a);
        System.out.println("b = " + this.b);
        System.out.println("c = " + this.c);
        System.out.println("d = " + this.d);
    }

}
