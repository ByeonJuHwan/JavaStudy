package edu.java.ojdbc.view;

import static edu.java.ojdbc.model.Blog.Entity.COL_AUTHOR;
import static edu.java.ojdbc.model.Blog.Entity.COL_BOLG_NO;
import static edu.java.ojdbc.model.Blog.Entity.COL_MODIFIED_DATE;
import static edu.java.ojdbc.model.Blog.Entity.COL_TITLE;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

public class SearchFrame extends JFrame {
	
	private static final String[] categories= {"제목", "내용", "작성자"};
	private static final String[] COLUMN_NAMES = {
            COL_BOLG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE
    };
	
	
	private JPanel contentPane;
	private Component parent;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	private JTextField inputSearch;
	private JTable articleTable;
	private JButton btnSearch;
	private JComboBox comboBox;
	
	private BlogDaoImpl dao;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void newSearchFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SearchFrame frame = new SearchFrame(parent);
				frame.setVisible(true);
			}
		});
	}
	
	public SearchFrame(Component parent) {
		this.parent = parent;
		dao = BlogDaoImpl.getInstance();
		initialize();
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.NORTH);
		
		comboBox = new JComboBox(categories);
		comboBox.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(comboBox);
		
		inputSearch = new JTextField();
		inputSearch.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(inputSearch);
		inputSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search();
			}
		});
		btnSearch.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnSearch);
		
		btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		articleTable = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		articleTable.setModel(model);
		articleTable.setFont(new Font("굴림", Font.BOLD, 15));
		scrollPane.setViewportView(articleTable);
	}

	private void Search() {
		model.setNumRows(0);
		
		List<Blog> list = new ArrayList<>();
		
		String category = (String) comboBox.getSelectedItem();
		String text = inputSearch.getText();
		
		if(text.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "검색할 내용을 입력해주세요..", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		list = dao.selectByColumn(category, text);
		
		for(Blog b : list) {
			Object[] row = {b.getBlogNo(), b.getTitle(),b.getAuthor(),b.getModifiedDate()};
            model.addRow(row);
		}
	}
}
