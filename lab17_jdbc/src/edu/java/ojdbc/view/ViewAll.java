package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAll extends JFrame {

	private Component parent;
	private int row;
	
	private JPanel contentPane;
	private JTextField ShowTitle;
	private JTextField ShowAuthor;
	private JTextField ShowBlogNo;
	private JTextField ShowDate;
	private JTextArea ShowContent;
	
	
	private BlogDaoImpl dao;

	/**
	 * Launch the application.
	 */
	public static void newViewAll(Component parent, int row) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ViewAll frame = new ViewAll(parent,row);
				frame.setVisible(true);
			}
		});
	}
	
	/**
     * Create the frame.
	 * @param parent 
     * @param parent 
	 * @param index 
     *
     */
     public ViewAll(Component parent, int row) {
    	 this.parent = parent;
    	 this.row = row;
    	 this.dao = BlogDaoImpl.getInstance();
    	 initialize();
    	 showSelectedRow();
     }
	
	

	 private void showSelectedRow() {
		Blog blog = dao.select(row);
		ShowTitle.setText(blog.getTitle());
		ShowAuthor.setText(blog.getAuthor());
		ShowBlogNo.setText(blog.getBlogNo().toString());
		ShowContent.setText(blog.getContent());
		ShowDate.setText(blog.getCreatedDate().toString());
		
	}

	/**
     * initialize UI components
	 * @return 
     */
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("제목");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblTitle.setBounds(12, 10, 96, 43);
		contentPane.add(lblTitle);
		
		ShowTitle = new JTextField();
		ShowTitle.setFont(new Font("D2Coding", Font.BOLD, 15));
		ShowTitle.setColumns(10);
		ShowTitle.setBounds(120, 10, 474, 43);
		contentPane.add(ShowTitle);
		
		JLabel lblAuthor = new JLabel("작성자");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblAuthor.setBounds(12, 66, 96, 43);
		contentPane.add(lblAuthor);
		
		ShowAuthor = new JTextField();
		ShowAuthor.setFont(new Font("D2Coding", Font.BOLD, 15));
		ShowAuthor.setColumns(10);
		ShowAuthor.setBounds(120, 63, 174, 43);
		contentPane.add(ShowAuthor);
		
		JLabel lblBlogNo = new JLabel("글번호");
		lblBlogNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlogNo.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblBlogNo.setBounds(306, 63, 96, 43);
		contentPane.add(lblBlogNo);
		
		ShowBlogNo = new JTextField();
		ShowBlogNo.setFont(new Font("D2Coding", Font.BOLD, 15));
		ShowBlogNo.setColumns(10);
		ShowBlogNo.setEditable(false);
		ShowBlogNo.setBounds(420, 63, 174, 43);
		contentPane.add(ShowBlogNo);
		
		JLabel lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblContent.setBounds(12, 119, 96, 43);
		contentPane.add(lblContent);
		
		ShowContent = new JTextArea();
		ShowContent.setFont(new Font("D2Coding", Font.BOLD, 15));
		ShowContent.setBounds(12, 172, 582, 222);
		contentPane.add(ShowContent);
		
		JLabel lblCreateDate = new JLabel("작성날짜");
		lblCreateDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateDate.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblCreateDate.setBounds(12, 404, 96, 43);
		contentPane.add(lblCreateDate);
		
		ShowDate = new JTextField();
		ShowDate.setFont(new Font("D2Coding", Font.BOLD, 15));
		ShowDate.setColumns(10);
		ShowDate.setEditable(false);
		ShowDate.setBounds(120, 404, 174, 43);
		contentPane.add(ShowDate);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("D2Coding", Font.BOLD, 15));
		btnCancle.setBounds(101, 515, 140, 47);
		contentPane.add(btnCancle);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.BOLD, 15));
		btnUpdate.setBounds(346, 515, 140, 47);
		contentPane.add(btnUpdate);
	}

}
