package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ContactUpdateFrame extends JFrame {

    private JPanel contentPane;
    private Component parent;

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ContactUpdateFrame frame = new ContactUpdateFrame(parent);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     * @param parent 
     */
    public ContactUpdateFrame(Component parent) {
        this.parent = parent; // 부모 컴포넌트.
        initialize(); // UI 컴포넌트 생성,초기화
    }
    /**
     * initialize UI components
     */
    private void initialize() {
        setTitle("연락처 확인/수정");
        int x = parent.getX(); // 부모 컴포넌트의 x 좌표
        int y = parent.getY(); // 부모 컴포넌트의 y 좌표
        setBounds(x, y, 455, 345);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("굴림", Font.BOLD, 15));
        lblName.setBounds(12, 10, 77, 36);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("굴림", Font.BOLD, 15));
        lblPhone.setBounds(12, 56, 77, 36);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("굴림", Font.BOLD, 15));
        lblEmail.setBounds(12, 102, 77, 36);
        contentPane.add(lblEmail);
        
        JTextField textName = new JTextField();
        textName.setBounds(101, 10, 302, 36);
        contentPane.add(textName);
        textName.setColumns(10);
        
        JTextField textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(101, 56, 302, 36);
        contentPane.add(textPhone);
        
        JTextField textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(101, 102, 302, 36);
        contentPane.add(textEmail);
        
        JButton btnUpdate = new JButton("수정");
        btnUpdate.setFont(new Font("굴림", Font.BOLD, 16));
        btnUpdate.setBounds(27, 176, 147, 67);
        contentPane.add(btnUpdate);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.setFont(new Font("굴림", Font.BOLD, 16));
        btnCancel.setBounds(256, 176, 147, 67);
        contentPane.add(btnCancel);
    }

}
