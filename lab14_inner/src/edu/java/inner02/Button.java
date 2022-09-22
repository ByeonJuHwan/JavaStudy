package edu.java.inner02;

public class Button {
    // static inner interface
    public static interface OnClickListener{
        void onClick(); // 추상 메서드 (public abstract 생략)
    }
    
    // field
    private String btnName;
    private OnClickListener listener;
    
    // constructor
    public Button(String btnName) {
        this.btnName=btnName;
    }
    
    // method 
    public void setOnClickListenerr(OnClickListener l) {
        this.listener=l;
    }
    
    public void click() {
        System.out.println(btnName + " 버튼");
        listener.onClick();
    }
}

