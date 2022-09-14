package edu.java.generic01;

public class OrangeBox {
    private Orange orange;
    
    public void put(Orange orange) {
        this.orange = orange;
    }
    
    public Orange get() {
        return orange;
    }
}

class Orange{
    private int sugar;
    
    public Orange(int sugar) {
    this.sugar =sugar;
    
    }
    
    public int getSugar() {
        return sugar;
    }
}