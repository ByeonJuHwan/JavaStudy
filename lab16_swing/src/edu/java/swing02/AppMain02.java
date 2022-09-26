package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;

public class AppMain02 {

    private JFrame frame;
    private JTextField textinput;
    private JLabel lblResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setFont(new Font("Dialog", Font.PLAIN, 24));
        frame.setBounds(100, 100, 403, 393);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);  // absolute layout 
        
        lblResult = new JLabel("New label");
        lblResult.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblResult.setBounds(12, 47, 363, 45);
        frame.getContentPane().add(lblResult);  // JLabel이 화면에 추가
        
        textinput = new JTextField();
        textinput.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textinput.setBounds(12, 102, 363, 108);
        frame.getContentPane().add(textinput); // JTextField가 화면에 추가
        textinput.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        // 버튼에 이벤트 핸들러를 설정 - 이벤트가 발생했을 때 그 이벤트를 처리할 수 있는 객체를 정의.
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼이 클릭됐을 때 할 일을 정의.
                // 1) JTextField에 입력된 내용을 읽음.
                String input = textinput.getText();
                // 2) 그 내용을 JLable에 씀.
                lblResult.setText(input);
                // 3) JLable에 내용을 써주면 textInput을 초기화 해준다.
                textinput.setText(null);
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnInput.setBounds(12, 220, 363, 92);
        frame.getContentPane().add(btnInput);  // JButton을 화면에 추가
    }
}
