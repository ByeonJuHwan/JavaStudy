package gui.practice;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();  // JFrame 객체 생성
        JPanel panel = new JPanel();  // Frame 안에 panel을 넣는 객체 생성.  
        
        panel.add(new JLabel("welcome"));  // 패널 안에 'welcome'을 넣고 다시 패널을 frame안으로 넣어준다.
    
        frame.add(panel); // add를 안해주면 frame따로 panel 따로 존재 하므로 무조건 panel을 넣어주어야한다.
        
        
        frame.setResizable(false); // 실행창 크기를 멋대로 조절할수 없게 만들어줌 (false) 입력시, true는 그 반대이다.
        frame.setVisible(true);    // 실행시 창이 보이게 해줌
        frame.setPreferredSize(new Dimension(840, 840/12*9));  // 실행시 보여주는 창의 크기를 조절 숫자를 쓸때는 무조건 new Dimension을 써줘야한다.
        frame.setSize(840, 840/12*9);
        frame.setLocationRelativeTo(null); // 실행창이 자동으로 왼쪽 위에서 시작되는데 이때 null 값을 넣어주면 자동으로 가운데에서 창이 뜨게 할 수 있다.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 실행을 눌렀을때 창 닫기를 눌렀을때도 프로그램이 계속 실행되는걸 확인할 수 있다. 이때 사용하는 명령어
    }
}
