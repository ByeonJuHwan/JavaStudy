package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain01 window = new AppMain01();
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
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblText = new JLabel("안녕하세요, Swing!");    // JLable 객체 생성
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setFont(new Font("궁서", Font.PLAIN, 40));
        frame.getContentPane().add(lblText, BorderLayout.CENTER); // JLable 객체를 화면에 추가.
    }

}
