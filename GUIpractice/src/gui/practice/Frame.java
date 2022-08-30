package gui.practice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();  // JFrame 객체 생성
        JPanel panel = new JPanel();  // Frame 안에 panel을 넣는 객체 생성.  
        JLabel label = new JLabel("some texts");
        JButton btn1 = new JButton("Click this");  // 버튼을 생성해주고 버튼안에 들어갈 말을 넣어준다.
        JButton btn2 = new JButton("Exit");  
        JTextArea txtArea = new JTextArea();
        //JTextField txtField = new JTextField(200); //위의 area와의 차이점은 field는 한줄 또는 적은양의 글을 입력할때 사용하고, 위의 area는 많은 양의 글을 입력할때 사용한다. 
        // 그리고 숫자를 넣어주어서 몇 글자가 들어갈건지도 입력해주어야한다. 
        JPanel btnPanel = new JPanel();
        
        panel.setLayout(new BorderLayout()); // 구성품들의 위치를 정할수 있음
        
        
        btnPanel.add(btn1); 
        btnPanel.add(btn2); 
        
        panel.add(label, BorderLayout.NORTH);  // label 을 입력해주고, 선언한 BorderLayout에서 위치를 north로 해주면 위에다 some texts가 생성된다.
        //panel.add(btn1, BorderLayout.WEST); // 이번에는 위에서 버튼에 선언해준 btn1을 선언해주고, 위치를 west로 해주면 왼쪽에 버튼이 생성된다.
        panel.add(txtArea, BorderLayout.CENTER);
        //panel.add(txtField, BorderLayout.EAST);
        panel.add(btnPanel, BorderLayout.WEST);
        
        
        btn1.addActionListener(new ActionListener() {     // 버튼을 눌렀을때 어떤 동작을 수행시키기 위해서 사용해야함.

            @Override
            public void actionPerformed(ActionEvent e) {  // new ActionListener() 를 입력하면 반드시 따라오는 메서드 actionPerformed 에서 버튼에 동작을 수행시킨다.
                //txtArea.append("you are amazing \n");     // bt1 버튼을 누르면 자동으로 글을 입력해주고 다음줄로 옮겨준다. 
                label.setText(txtArea.getText());           // bt1 버튼을 누르면 위의 label의 글을 txtArea에 입력한 글로 바꿀수 있다.
            }
            
        });
        
        btn2.addActionListener(new ActionListener() {     

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);     // btn2 버튼을 누르면 프로그램을 종료시킨다.
            }
            
        });
    
        frame.add(panel); // add를 안해주면 frame따로 panel 따로 존재 하므로 무조건 panel을 넣어주어야한다.
        
        
        frame.setResizable(false); // 실행창 크기를 멋대로 조절할수 없게 만들어줌 (false) 입력시, true는 그 반대이다.
        frame.setVisible(true);    // 실행시 창이 보이게 해줌
        frame.setPreferredSize(new Dimension(840, 840/12*9));  // 실행시 보여주는 창의 크기를 조절 숫자를 쓸때는 무조건 new Dimension을 써줘야한다.
        frame.setSize(840, 840/12*9);
        frame.setLocationRelativeTo(null); // 실행창이 자동으로 왼쪽 위에서 시작되는데 이때 null 값을 넣어주면 자동으로 가운데에서 창이 뜨게 할 수 있다.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 실행을 눌렀을때 창 닫기를 눌렀을때도 프로그램이 계속 실행되는걸 확인할 수 있다. 이때 사용하는 명령어
    }
}
