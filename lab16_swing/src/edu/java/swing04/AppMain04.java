package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AppMain04 {

    private JFrame frame;
    private JTextField InputNum1;
    private JTextField InputNum2;
    private JTextArea opresult;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnMultiple;
    private JButton btnDevide;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 482, 564);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNum1 = new JLabel("숫자1");
        lblNum1.setOpaque(true);
        lblNum1.setForeground(Color.WHITE);
        lblNum1.setBackground(Color.GRAY);
        lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum1.setFont(new Font("굴림", Font.BOLD, 15));
        lblNum1.setBounds(12, 28, 82, 43);
        frame.getContentPane().add(lblNum1);
        
        JLabel lblNum2 = new JLabel("숫자2");
        lblNum2.setForeground(Color.WHITE);
        lblNum2.setBackground(Color.GRAY);
        lblNum2.setOpaque(true);
        lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum2.setFont(new Font("굴림", Font.BOLD, 15));
        lblNum2.setBounds(12, 96, 82, 43);
        frame.getContentPane().add(lblNum2);
        
        InputNum1 = new JTextField();
        InputNum1.setFont(new Font("굴림", Font.BOLD, 15));
        InputNum1.setBounds(106, 21, 348, 58);
        frame.getContentPane().add(InputNum1);
        InputNum1.setColumns(10);
        
        btnAdd = new JButton("+");
        btnAdd.addActionListener(new ActionListener() {
            
            // 파라미터 ActionEvent e : 이벤트가 발생한 컴포턴트, 이벤트의 종류 등에 대한 정보를 담고 있다.
            // ActionEvent.getSurce(): 이벤트가 발생한 컴포넌트를 리턴.
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
                
            }
        });
        btnAdd.setFont(new Font("굴림", Font.PLAIN, 25));
        btnAdd.setBounds(12, 186, 82, 67);
        frame.getContentPane().add(btnAdd);
        
        btnSubtract = new JButton("-");
        btnSubtract.setFont(new Font("굴림", Font.BOLD, 20));
        btnSubtract.addActionListener(e->performCalculation(e));
        btnSubtract.setBounds(121, 186, 82, 67);
        frame.getContentPane().add(btnSubtract);
        
        btnMultiple = new JButton("*");
        btnMultiple.addActionListener(e->performCalculation(e));
        btnMultiple.setFont(new Font("굴림", Font.BOLD, 20));
        btnMultiple.setBounds(232, 186, 82, 67);
        frame.getContentPane().add(btnMultiple);
        
        btnDevide = new JButton("/");
        btnDevide.addActionListener(e->performCalculation(e));
        btnDevide.setFont(new Font("굴림", Font.BOLD, 20));
        btnDevide.setBounds(342, 186, 82, 67);
        frame.getContentPane().add(btnDevide);
        
        opresult = new JTextArea();
        opresult.setFont(new Font("Monospaced", Font.BOLD, 20));
        opresult.setBounds(12, 263, 442, 252);
        frame.getContentPane().add(opresult);
        
        InputNum2 = new JTextField();
        InputNum2.setFont(new Font("굴림", Font.BOLD, 15));
        InputNum2.setColumns(10);
        InputNum2.setBounds(106, 89, 348, 58);
        frame.getContentPane().add(InputNum2);
    } // end Main

    private void performCalculation(ActionEvent e) {
        // JTextFiled에 입력된 문자열을 읽고, double 타입으로 변환
        String s1 = InputNum1.getText();
        String s2 = InputNum2.getText();
        
        double number1 = 0;
        double number2 = 0;
        
        try {
         number1 = Double.parseDouble(s1);
         number2 = Double.parseDouble(s2);
        }catch(NumberFormatException ex) {
            opresult.setText("숫자1 또는 숫자2는 숫자 타입으로 입력하세요..");
            return; // 메서드 종료
        }
        
        
        double result=0; // 산술 연산 결과를 저장하기 위한 변수.
        String op=" ";
        
        Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
        if(source == btnAdd) {
            result = number1 + number2;
            op= " + ";
        }else if(source == btnSubtract) {
            result = number1 - number2;
            op= " - ";
        }else if(source == btnMultiple) {
            result = number1 * number2;
            op= " * ";
        }else if(source == btnDevide) {
            result = number1 / number2;
            op= " / ";
        }
        
        String output = String.format("%f %s %f = %f", number1,op,number2,result);
        opresult.setText(output);
        
    }

}
