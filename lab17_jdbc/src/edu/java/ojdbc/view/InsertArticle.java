package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertArticle extends JFrame {
	@FunctionalInterface
	public interface InsertAricleListener{
		void insertArticleNotify();
	}
	
	private InsertAricleListener listener;
	private JPanel contentPane;
	private Component parent;
	private JTextField inputTitle;
	private JTextField inputAuthor;
	private JTextArea insertContent;
	private JButton btnInsertAriticle;
	private JButton btnCancle;
	
	
	private BlogDaoImpl dao; // DB 테이블 기능

	/**
	 * Launch the application.
	 */
	public static void newInsertArticle(Component parent,InsertAricleListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				InsertArticle frame = new InsertArticle(parent,listener);
				frame.setVisible(true);
				
			}
		});
	}

	/**
	 * Create the frame.
	 * @param parent 
	 * @param listener 
	 */
	public InsertArticle(Component parent, InsertAricleListener listener) {
		this.parent = parent;
		this.listener = listener;
		this.dao = BlogDaoImpl.getInstance();
		initialize();
	}
	
	
	/**
     * Initialize the contents of the frame.
     */
	private void  initialize() {
		setTitle("새 글 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = parent.getX(); // 부모창 의 X 좌표
		int y = parent.getY(); // 부모창 의 Y 좌표
		setBounds(x, y, 622, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 96, 43);
		contentPane.add(lblTitle);
		
		inputTitle = new JTextField();
		inputTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		inputTitle.setBounds(120, 10, 474, 43);
		contentPane.add(inputTitle);
		inputTitle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("작성자");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblAuthor.setBounds(12, 63, 96, 43);
		contentPane.add(lblAuthor);
		
		inputAuthor = new JTextField();
		inputAuthor.setFont(new Font("D2Coding", Font.BOLD, 15));
		inputAuthor.setColumns(10);
		inputAuthor.setBounds(120, 63, 474, 43);
		contentPane.add(inputAuthor);
		
		JLabel lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblContent.setBounds(12, 136, 96, 43);
		contentPane.add(lblContent);
		
		insertContent = new JTextArea();
		insertContent.setFont(new Font("D2Coding", Font.BOLD, 15));
		insertContent.setBounds(12, 189, 582, 316);
		contentPane.add(insertContent);
		
		btnInsertAriticle = new JButton("작성완료");
		btnInsertAriticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateComplete();
			}
		});
		btnInsertAriticle.setFont(new Font("D2Coding", Font.BOLD, 15));
		btnInsertAriticle.setBounds(348, 515, 140, 47);
		contentPane.add(btnInsertAriticle);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("D2Coding", Font.BOLD, 15));
		btnCancle.setBounds(122, 515, 140, 47);
		contentPane.add(btnCancle);
	}

	protected void updateComplete() {
		String title = inputTitle.getText();
		String content = insertContent.getText();
		String author = inputAuthor.getText();
		
		if(title.equals("")||content.equals("")||author.equals("")) {
		    JOptionPane.showMessageDialog(this, // InsertArticleComponent - > InsertArticle의 주소
		            "제목,내용,작성자는 반드시 입력되어야 합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
		    return; // insert하면 안 됨 -> 메서드 종료
		}
		
		Blog blog = new Blog(null, title,content,author, null, null);
		
		int result = dao.insert(blog);
		System.out.println(result);
		if(result == 1) {
			dispose();
			listener.insertArticleNotify();
			JOptionPane.showMessageDialog(this, "작성 완료", "완료", JOptionPane.PLAIN_MESSAGE);
		}else {
		    JOptionPane.showMessageDialog(this, "작성 실패", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
