package edu.java.ojdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import static edu.java.ojdbc.model.Blog.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BolgMain {
    
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = {
            COL_BOLG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE
    };
    
    
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    
    
    private BlogDaoImpl dao;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BolgMain window = new BolgMain();
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
    public BolgMain() {
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = BlogDaoImpl.getInstance(); 
        initializeTable(); // 메인 하면에서의 JTable 데이터 초기화
    }

    private void initializeTable() {
        List<Blog> list = dao.select();
        for(Blog b : list) {
            Object[] row = {b.getBlogNo(), b.getTitle(),b.getAuthor(),b.getModifiedDate()};
            model.addRow(row);
        }
         
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 622, 611);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새글 작성");
        btnCreate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InsertArticle.newInsertArticle(frame);
        	}
        });
        btnCreate.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnCreate);
        
        JButton btnRead = new JButton("상세보기");
        btnRead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRead.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnRead);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null,COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    

	private void deleteRow() {
        int row = table.getSelectedRow();
        int result  = dao.delete(row);
        
        if(result == 1) {
            JOptionPane.showMessageDialog(frame, "삭제완료");
        }
        model.removeRow(row);
        
        
    }

}
