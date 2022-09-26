package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField NameInput;
    private JTextField PhoneInput;
    private JTextField EmailInput;
    private JTextArea result;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 552, 435);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblName.setBounds(24, 22, 88, 37);
        frame.getContentPane().add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblPhone.setBounds(24, 85, 88, 37);
        frame.getContentPane().add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblEmail.setBounds(24, 154, 88, 37);
        frame.getContentPane().add(lblEmail);
        
        NameInput = new JTextField();
        NameInput.setFont(new Font("D2Coding", Font.PLAIN, 12));
        NameInput.setBounds(124, 30, 283, 37);
        frame.getContentPane().add(NameInput);
        NameInput.setColumns(10);
        
        PhoneInput = new JTextField();
        PhoneInput.setFont(new Font("D2Coding", Font.PLAIN, 12));
        PhoneInput.setBounds(124, 93, 283, 37);
        frame.getContentPane().add(PhoneInput);
        PhoneInput.setColumns(10);
        
        EmailInput = new JTextField();
        EmailInput.setFont(new Font("D2Coding", Font.PLAIN, 12));
        EmailInput.setBounds(124, 154, 283, 37);
        frame.getContentPane().add(EmailInput);
        EmailInput.setColumns(10);
        
        result = new JTextArea();
        result.setFont(new Font("D2Coding", Font.PLAIN, 20));
        result.setBounds(44, 236, 466, 119);
        frame.getContentPane().add(result);
        
        JButton btnButton = new JButton("입력");
        // 버튼에 이벤트 핸들러를 등록
        // 이벤트 핸들러 : 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
        btnButton.addActionListener((e)->printInfo());
        btnButton.setBounds(419, 161, 105, 30);
        frame.getContentPane().add(btnButton);
    } // end main
    
    // "입력" 버튼을 클릭했을 때 실행할 내용.ㄴ
    private void printInfo() {
     // JTextField에 입력된 내용을 읽음.
        String name = NameInput.getText();
        String phone = PhoneInput.getText();
        String email = EmailInput.getText();
        
        // JTextArea에 출력할 문자열 만들기
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름 : ").append(name).append("\n")
            .append("전화번호 : ").append(phone).append("\n")
            .append("이메일 : ").append(email);
        
        // 만들어진 문자열을 JTextArea에 출력
        result.setText(buffer.toString());
    }
} // end class 
