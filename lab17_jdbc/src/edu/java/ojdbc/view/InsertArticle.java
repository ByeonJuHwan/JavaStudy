package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InsertArticle extends JFrame {

	private JPanel contentPane;
	private Component parent;

	/**
	 * Launch the application.
	 */
	public static void newInsertArticle(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				InsertArticle frame = new InsertArticle(parent);
				frame.setVisible(true);
				
			}
		});
	}

	/**
	 * Create the frame.
	 * @param parent 
	 */
	public InsertArticle(Component parent) {
		this.parent = parent;
		initialize();
	}
	
	
	/**
     * Initialize the contents of the frame.
     */
	private void  initialize() {
		setTitle("새 글 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
