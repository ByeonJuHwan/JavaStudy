package createthread;

import java.awt.Toolkit;

public class BeepPrintExample1 {

    public static void main(String[] args) {
        // 비프음을 5번 반복해서 소리나게 하는 작업
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++) {
            toolkit.beep();
            try {Thread.sleep(500);}catch(Exception e) {}
                // 1000 을 주게 되면 1초가되고, 500을 주면 0.5초가 된다.
            
        }
        
        
        // "띵" 문자열을 5번 출력하는 작업
        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try {Thread.sleep(500);}catch(Exception e) {}
                // 1000 을 주게 되면 1초가되고, 500을 주면 0.5초가 된다.
        }

    }

}
