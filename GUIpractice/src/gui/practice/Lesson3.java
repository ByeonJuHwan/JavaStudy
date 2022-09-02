package gui.practice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Lesson3 extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Lesson3 frame = new Lesson3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Lesson3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 687, 451);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
        btnNewButton.setBounds(499, 290, 138, 79);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Login Form");
        lblNewLabel.setBounds(215, 60, 229, 35);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(208, 128, 149, 35);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(85, 138, 82, 25);
        contentPane.add(lblNewLabel_1);
    }
}
