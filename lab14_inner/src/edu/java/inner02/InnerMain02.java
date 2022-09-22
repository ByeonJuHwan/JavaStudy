package edu.java.inner02;

import edu.java.inner02.Button.OnClickListener;

public class InnerMain02 {

    public static void main(String[] args) {
        // Button 타입의 변수 선언, 객체 생성
        Button btnOpen = new Button("Open");
        
        // 생성된 버튼 객체의 setter 메서드를 호출하려면 
        // OnClickListener를 구현한 클래스의 객체를 argument로 전달해야함.
        OnClickListener l = new OpenButtonListener();
        btnOpen.setOnClickListenerr(l); // listener 변수 설정 
        btnOpen.click();

    }

}
