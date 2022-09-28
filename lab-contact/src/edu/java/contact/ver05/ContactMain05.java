package edu.java.contact.ver05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.java.contact.ver05.ContactCreateFrame.ContactInsertListener;;
public class ContactMain05 implements ContactInsertListener{
    private static final String[] COLUMN_NAMES= {"이름","전화번호"};

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = ContactDaoImpl.getInstance(); // 연락처 데이터 관리(추가, 삭제, 변경, 검색, ...)
        loadContactDataFromFile(); // 데이터 파일에 저장된 데이터를 로드해서 테이블에 설정.
        
    }
    private void loadContactDataFromFile() {
        List<Contact> list = dao.read();
        for(Contact c : list) {
            addContactToTableModel(c);
        }
    }
    

    private void addContactToTableModel(Contact c) {
        // 테이블 모델에 추가할 행(row) 데이터
        Object[] rowData = {c.getName(),c.getPhone()}; 
        // 테이블 모델에 데이터 추가
        model.addRow(rowData);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 537, 505);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Contact Ver 0.5"); // 애플리케이션 타이틀을 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame, ContactMain05.this);
                
                
            }
        });
        btnCreate.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 확인/수정");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContactUpdateFrame.newContactCreateFrame(frame);
                //TODO
            }
        });
        btnUpdate.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnDelete);
        
        JButton btnSerch = new JButton("검색");
        btnSerch.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnSerch);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model= new DefaultTableModel(null,COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }
    // ContactCreateFrame.ContactInsertListener 인터페이스의 메서드 구현.
    @Override
    public void contactInsertNotify(Contact c) {
        System.out.println(c);
        
    }

}
