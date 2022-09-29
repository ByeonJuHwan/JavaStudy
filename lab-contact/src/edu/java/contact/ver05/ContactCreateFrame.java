package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
    
    @FunctionalInterface
    public interface ContactInsertListener{
        void contactInsertNotify(Contact c);
    }
    private  ContactInsertListener listener;
    
    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     * @param parent 
     */
    public ContactCreateFrame(Component parent, ContactInsertListener listener) {
        this.parent = parent; // 부모 컴포넌트.
        this.listener = listener; // contactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트 생성,초기화
    }
    /**
     * initialize UI components
     */
    private void initialize() {
        setTitle("새 연락처 추가");
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
        
        textName = new JTextField();
        textName.setBounds(101, 10, 302, 36);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(101, 56, 302, 36);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(101, 102, 302, 36);
        contentPane.add(textEmail);
        
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnSave.setFont(new Font("굴림", Font.BOLD, 16));
        btnSave.setBounds(27, 176, 147, 67);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창만 닫고, 부모 컴포넌트는 계속 실행.
            }
        });
        btnCancel.setFont(new Font("굴림", Font.BOLD, 16));
        btnCancel.setBounds(256, 176, 147, 67);
        contentPane.add(btnCancel);
    }

    private void createNewContact() {
        // 3개의 JTextField의 입력된 문자열을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        // 현재 창 닫기 
        dispose();
        
        // 새연락처가 생성됐음을 (ContactMain에게) 알려준다.
        listener.contactInsertNotify(contact);
    }

}
