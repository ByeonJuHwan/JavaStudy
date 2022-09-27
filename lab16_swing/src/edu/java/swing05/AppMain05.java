package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AppMain05 {

    private JFrame frame;
    private JLabel lblImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 735, 789);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblImage = new JLabel(new ImageIcon("images/flower1.jpg"));
        lblImage.setBounds(12, 10, 640, 640);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.setFont(new Font("굴림", Font.PLAIN, 15));
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowPrevImage();
            }
        });
        btnPrev.setBounds(12, 682, 124, 58);
        frame.getContentPane().add(btnPrev);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowNextImage();
            }
        });
        btnNext.setFont(new Font("굴림", Font.PLAIN, 15));
        btnNext.setBounds(583, 682, 124, 58);
        frame.getContentPane().add(btnNext);
    } // end main

    protected void ShowPrevImage() {
        Icon i =lblImage.getIcon();
        String IconFileName = i.toString();
        if(IconFileName.equals("images/flower1.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower5.jpg"));
        }else if(IconFileName.equals("images/flower2.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower1.jpg"));
        }else if(IconFileName.equals("images/flower3.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower2.jpg"));
        }else if(IconFileName.equals("images/flower4.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower3.jpg"));
        }else if(IconFileName.equals("images/flower5.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower4.jpg"));
        }
        
    }
    
    protected void ShowNextImage() {
        Icon i =lblImage.getIcon();
        String IconFileName = i.toString();
        if(IconFileName.equals("images/flower1.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower2.jpg"));
        }else if(IconFileName.equals("images/flower2.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower3.jpg"));
        }else if(IconFileName.equals("images/flower3.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower4.jpg"));
        }else if(IconFileName.equals("images/flower4.jpg")) {
            lblImage.setIcon(new ImageIcon("images/flower5.jpg"));
        }else {
            lblImage.setIcon(new ImageIcon("images/flower1.jpg"));
        }
        
    }

} // end class
