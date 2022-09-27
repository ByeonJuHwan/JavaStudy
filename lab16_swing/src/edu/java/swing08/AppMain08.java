package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 568, 517);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("굴림", Font.BOLD, 15));
        textField.setBounds(12, 42, 408, 48);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.add(listModel.size(), textField.getText());
            }
        });
        btnInput.setFont(new Font("굴림", Font.BOLD, 15));
        btnInput.setBounds(432, 10, 112, 48);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(list.isFocusable()) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    toolkit.beep();
                    int result = JOptionPane.showConfirmDialog(frame, "삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(result==0) {
                        int index = list.getSelectedIndex();
                        listModel.remove(index);
                    }else {
                        return;
                    }
                }
            }
        });
        btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
        btnDelete.setBounds(432, 68, 112, 48);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 146, 528, 293);
        frame.getContentPane().add(scrollPane);
        
        list = new JList<>();
        listModel = new DefaultListModel<>();
        list.setModel(listModel);
        list.setFont(new Font("굴림", Font.BOLD, 15));
        scrollPane.setViewportView(list);
    }
}
