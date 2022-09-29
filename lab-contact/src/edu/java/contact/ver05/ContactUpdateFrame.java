package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
    @FunctionalInterface
    public interface ContactUpdateListener{
        void contactUpdateNotify();
    }
    private ContactUpdateListener listener;
    private Component parent; // 업데이트 창을 실행시킨 부모 컴포넌트
    private int index; // 수정할 연락처의 인덱스
    private ContactDaoImpl dao; // 연락처 검색(read), 업데이트(update), ...
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ContactUpdateFrame frame = new ContactUpdateFrame(parent,index,listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     * @param parent 
     */
    public ContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        this.parent = parent; // 부모 컴포넌트.
        this.index = index;  // 수정할 연락처의 인덱스를 멤버로 저장
        this.dao = ContactDaoImpl.getInstance(); // DAO 싱글턴 객체를 가져옴.
        this.listener = listener; // 업데이트 창을 만든 메인 창의 주소를 저장.
        initialize(); // UI 컴포넌트 생성,초기화
        initializeContactInfo(); // 수정하려는 인덱스의 연락처 정보를 JTextField에 채움.
    }
    private void initializeContactInfo() {
        Contact contact = dao.read(index);
        
        // 각 JTextField 연락처 정보를 씀.
        textEmail.setText(contact.getEmail());
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        
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
        
        JButton btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnUpdate.setFont(new Font("굴림", Font.BOLD, 16));
        btnUpdate.setBounds(27, 176, 147, 67);
        contentPane.add(btnUpdate);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("굴림", Font.BOLD, 16));
        btnCancel.setBounds(256, 176, 147, 67);
        contentPane.add(btnCancel);
    }

    private void updateContact() {
        // 각 JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 타입 객체 생성
        Contact contact = new Contact(name,phone,email);
        
        // DAO의 메서드를 사용해서 연락처 정보(파일) 업데이트.
        dao.update(index, contact);
        
        // 창 닫기
        dispose();
        
        // 메인 창(Frame)에게 연락처 정보 업데이트 됐다고 알려줌.
        listener.contactUpdateNotify();
        
    }

}
