package edu.java.set02;

public class Score {
    // field
    private int java;
    private int web;
    
    // 생성자
    public Score() {}

    public Score(int java, int web) {
        this.java = java;
        this.web = web;
    }
    
    // getter/ setter

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }
    
    @Override
    public String toString() {
        
        return String.format("Score(java=%d, web=%d)", java,web);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Score) {
            Score s = (Score)obj;
            return (this.java == s.java)&&(this.web == s.web);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        
        return Integer.valueOf(java).hashCode();
    }
    
}
