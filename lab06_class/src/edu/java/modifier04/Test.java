package edu.java.modifier04;

public class Test {
    private int a;
    private double b;
    private boolean c;
    private String d;
   
    
    public Test(int a, double b, boolean c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int getA() {
        return a;
    }
   
    public void setA(int a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public boolean isC() {
        return c;
    }
    public void setC(boolean c) {
        this.c = c;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    
 // 마우스 오른쪽 클림 --> Source --> Generate Getters and Setters
    
   
    
    
    
}
