package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private static final String[] colNames = {"국어","영어","수학","총점","평균"};

    private JFrame frame;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JTable table;
    private DefaultTableModel model;

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
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScore();
            }
        });
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
            @Override
            public void actionPerformed(ActionEvent e) {
                deletRow();
            }
        });
        btnDelete.setBounds(227, 194, 134, 42);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 287, 415, 270);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable(); // JTable 생성
        
        // 테이블 데이터 -2차원배열 
        //TODO
        
        // 테이블 컬럼 이름 -1차원 배열
        // private static final String[] colNames = {"국어","영어","수학","총점","평균"};
        
        // 테이블 데이터를 관리하는 DefaultTableModel 객체를 생성.
        model = new DefaultTableModel(null,colNames);
    
        
        table.setModel(model); // 테이블 모델을 테이블에 세팅.
        
        scrollPane.setViewportView(table);
    
    } // end main
    
    private void deletRow() {
        // 테이블에서 삭제하기 위해서선택된 행(row) 인덱스를 찾음.
        int index = table.getSelectedRow();
        if(index == -1) { // 성택된 행이 없는경우
            JOptionPane.showMessageDialog(frame, "삭제할 행을 먼저 선택하세요","warning",JOptionPane.WARNING_MESSAGE);
            return;
        } 
        int confirm = JOptionPane.showConfirmDialog(frame,index + " 번째 정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            model.removeRow(index);
        }
        
    }

    private void inputScore() {
        // 3개의 JTextField에서 읽은 문자열을 정수(int)로 변환.
        int korean=0;
        int english=0;
        int math=0;
        try {
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "입력값은 반드시 정수여야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }finally {
            clearAllTextFields();
        }
        
        // 입력값들을 사용해서 Score 객체 생성
        Score score = new Score(korean,english,math);
        
        // 테이블에 행(row)에 추가할 데이터를 1차원 배열로 만듦.
        Object[] rowData = {
                score.getKorean(),
                score.getMath(),
                score.getEnglish(),
                score.sum(),
                score.average()
        };
        
        // row data를 테이블 모델에 추가
        model.addRow(rowData);
        
    }

    private void clearAllTextFields() {
        textEnglish.setText("");
        textKorean.setText("");
        textMath.setText("");
        
    }
} // end class
