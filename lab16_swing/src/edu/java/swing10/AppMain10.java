package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AppMain10 {

    private JFrame frame;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 469, 606);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblKorean = new JLabel("국어");
        lblKorean.setFont(new Font("굴림", Font.BOLD, 15));
        lblKorean.setBounds(34, 33, 75, 34);
        frame.getContentPane().add(lblKorean);
        
        JLabel lblEnglish = new JLabel("영어");
        lblEnglish.setFont(new Font("굴림", Font.BOLD, 15));
        lblEnglish.setBounds(34, 77, 75, 34);
        frame.getContentPane().add(lblEnglish);
        
        JLabel lblMath = new JLabel("수학");
        lblMath.setFont(new Font("굴림", Font.BOLD, 15));
        lblMath.setBounds(34, 121, 75, 34);
        frame.getContentPane().add(lblMath);
        
        textKorean = new JTextField();
        textKorean.setBounds(121, 40, 240, 27);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        textEnglish = new JTextField();
        textEnglish.setColumns(10);
        textEnglish.setBounds(121, 84, 240, 27);
        frame.getContentPane().add(textEnglish);
        
        textMath = new JTextField();
        textMath.setColumns(10);
        textMath.setBounds(121, 128, 240, 27);
        frame.getContentPane().add(textMath);
        
        JButton btnInput = new JButton("입력");
        btnInput.setForeground(Color.WHITE);
        btnInput.setBackground(Color.DARK_GRAY);
        btnInput.setFont(new Font("굴림", Font.BOLD, 15));
        btnInput.setBounds(34, 194, 134, 42);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(Color.DARK_GRAY);
        btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnDelete.setBounds(227, 194, 134, 42);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 287, 415, 270);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        
        // 테이블 데이터 -2차원배열 
        //TODO
        
        // 테이블 컬럼 이름 -1차원 배열
        Object[] colNames = {"국어","영어","수학","총점","평균"};
        
        // 테이블 데이터를 관리하는 DefaultTableModel 객체를 생성.
        DefaultTableModel model = new DefaultTableModel(null,colNames);
        
        // 테이블의 데이터를 관리(추가, 삭제, ...)하는 TableModel을 JTable에 설정
        table.setModel(model);
        
        scrollPane.setViewportView(table);
    }
}
