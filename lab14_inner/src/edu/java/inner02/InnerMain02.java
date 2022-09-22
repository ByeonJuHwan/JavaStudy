package edu.java.inner02;

import edu.java.inner02.Button.OnClickListener;

public class InnerMain02 {

    public static void main(String[] args) {
        // Button 타입의 변수 선언, 객체 생성
        Button btnOpen = new Button("Open");
        
        // 생성된 버튼 객체의 setter 메서드를 호출하려면 
        // OnClickListener를 구현한 클래스의 객체를 argument로 전달해야함.
        OnClickListener l = new OpenButtonListener();
        btnOpen.setOnClickListenerr(l); // listener 변수 설정 -> 버튼이 해야 할 기능을 등록.
        btnOpen.click(); // 버튼 클릭 -> 버튼 클릭 기능 실행.
        
        // 1) 버튼 생성
        Button btnSave = new Button("Save");
        
        // 지역 (내부) 클래스(local class) : 메서드 안에서 선언(정의)된 클래스
        // -> 선언된 메서드 안에서만 사용 가능(생성자 호출).
        class SaveButtonListener implements OnClickListener{

            @Override
            public void onClick() {
                System.out.println("파일 저장");
                
            }
            
        }
        SaveButtonListener listener = new SaveButtonListener();
        
        // 2) 버튼 클릭 기능 등록
        btnSave.setOnClickListenerr(listener);
        btnSave.setOnClickListenerr(new SaveButtonListener());
        // 3) 버튼 클릭 (기능 실행) 
        btnSave.click();
        
        
        // 1) 버튼생성
        Button btnClose = new Button("close");
        
        // 익명 클래스(anonymous class)
        OnClickListener listener2 = new OnClickListener() {
            
            @Override
            public void onClick() {
                System.out.println("파일 닫기");
                
            }
        };
        // 2) 버튼 기능 등록
        btnClose.setOnClickListenerr(listener2);
        
        // 3) 버튼 기능 실행
        btnClose.click();
        
        
        // 1) 버튼 생성
        Button btnExit = new Button("Exit");
        // 2) 버튼 기능 등록
        btnExit.setOnClickListenerr(new OnClickListener() {
            
            @Override
            public void onClick() {
               System.out.println("프로그램 종료");
                
            }
        });
        // 3) 버튼 기능 실행
        btnExit.click();
    }

}
