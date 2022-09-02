package gui.practice;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

public class Lesson06 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Lesson06 window = new Lesson06();
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
    public Lesson06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Lesson 06");
        frame.setBounds(100, 100, 800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel START = new JPanel();
        START.setBounds(0, 0, 784, 561);
        frame.getContentPane().add(START);
        START.setLayout(null);
        
        JButton btnNext = new JButton("go to next");
        btnNext.setBounds(110, 191, 97, 23);
        START.add(btnNext);
        
        JPanel LAST = new JPanel();
        LAST.setBounds(0, 0, 784, 561);
        frame.getContentPane().add(LAST);
        LAST.setLayout(null);
        
        JButton btnEnd = new JButton("go to end");
        btnEnd.setBounds(0, 0, 436, 125);
        LAST.add(btnEnd);
        
        btnEnd.setVisible(false);
        
        btnNext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnEnd.setVisible(true);
                btnNext.setVisible(false);
                
            }
            
        });
        
        btnEnd.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEnd.setVisible(false);
                btnNext.setVisible(true);
                
            }
        });
            
        
        
    }
}
