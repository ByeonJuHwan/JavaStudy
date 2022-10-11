package edu.java.ojdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.view.InsertArticle.InsertAricleListener;
import edu.java.ojdbc.view.ViewAll.ViewAllListener;

import static edu.java.ojdbc.model.Blog.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BolgMain implements InsertAricleListener,ViewAllListener{
    
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = {
            COL_BOLG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE
    };
    
    
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    
    
    private BlogDaoImpl dao;
    private Blog blog;
    

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
        // 데이터는 없는, 컬럼 이름들만 설정된 테이블 모델 객체를 생성 => 테이초기화
        // DB에서 데이터를 검색.
        List<Blog> list = dao.select();
        for(Blog b : list) {
            Object[] row = {b.getBlogNo(), b.getTitle(),b.getAuthor(),b.getModifiedDate()};
            model.addRow(row); // 테이블 모델에 행(row) 데이터로 추가.
        }
         
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("블로그");
        frame.setBounds(650, 200, 622, 611);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새글 작성");
        btnCreate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InsertArticle.newInsertArticle(frame,BolgMain.this);
        		// BlogMain.this 는 BlogMain 의 주소이지만  // 그냥 this로 줄경우 버튼의 익명클래스(ActionListener)의 주소이다. 즉 다른 주소이다.
        	}
        });
        btnCreate.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnCreate);
        
        JButton btnRead = new JButton("상세보기");
        btnRead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                updateRow();
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
        
        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchArticle();
        	}
        });
        btnSearch.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnSearch);
        btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
        buttonPanel.add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null,COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    

	private void searchArticle() {
		SearchFrame.newSearchFrame(frame);
	}

	private void updateRow() {
		List<Blog>list = new ArrayList<>();
        list = dao.select();
		
        int row = table.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(frame, "확인할 행을 먼저 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        blog = list.get(row);
        
        ViewAll.newViewAll(frame,blog.getBlogNo(),BolgMain.this);
	}

	private void deleteRow() {
        List<Blog>list = new ArrayList<>();
        list = dao.select();
        
        
        int row = table.getSelectedRow();
        if(row == -1) { // JTable에서 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(frame, "삭제할 행을 먼저 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        blog = list.get(row);
        
        int confirm = JOptionPane.showConfirmDialog(frame,
                blog.getBlogNo() + " 번 블로그 글을 정말  삭제할까요??",
                "삭제확인",
                JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION) {
            int result = dao.delete(blog.getBlogNo());
            if(result == 1) {
                JOptionPane.showMessageDialog(frame, "삭제완료");
            }else {
                JOptionPane.showMessageDialog(frame, "삭제실패");
            }
            model.removeRow(row);
        }else {
            return;
        }
    }

	@Override
	public void insertArticleNotify() {
		resetTable();
	}
	
    @Override
	public void viewAllNotify() {
        resetTable();
	}
    
    private void resetTable() {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        initializeTable();
        
    }

}
