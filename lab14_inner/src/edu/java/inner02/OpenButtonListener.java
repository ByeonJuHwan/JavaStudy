package edu.java.inner02;

import edu.java.inner02.Button.OnClickListener;


// Button.OnClickListner 인터페이스를 구현하는 클래스.
public class OpenButtonListener implements OnClickListener{

    @Override
    public void onClick() {
        System.out.println("파일열기");
        
    }
    
}
