package edu.java.swing07;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox<String> comboBox;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 528, 771);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("??????", Font.PLAIN, 14));
        rbPrivate.setBounds(8, 6, 80, 63);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("??????", Font.PLAIN, 14));
        rbPackage.setBounds(92, 6, 80, 63);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("??????", Font.PLAIN, 14));
        rbProtected.setBounds(176, 6, 100, 63);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("??????", Font.PLAIN, 14));
        rbPublic.setBounds(280, 6, 63, 63);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckboxStatus(e);
            }
        });
        cbAbstract.setBounds(8, 71, 115, 23);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckboxStatus(e);
            }
        });
        cbFinal.setBounds(127, 71, 115, 23);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckboxStatus(e);
            }
        });
        cbStatic.setBounds(246, 71, 115, 23);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String)comboBox.getSelectedItem();
                textArea.setText(selected);
                
            }
        });
        final String [] items = {"??????","??????","??????"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        
        comboBox.setBounds(8, 149, 164, 36);
        frame.getContentPane().add(comboBox);
        
        JButton btnShowInfo = new JButton("??????");
        btnShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInfo();
            }
        });
        btnShowInfo.setFont(new Font("??????", Font.BOLD, 14));
        btnShowInfo.setBounds(8, 238, 147, 87);
        frame.getContentPane().add(btnShowInfo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 339, 492, 189);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

    
    private void printInfo() {
        StringBuilder buffer = new StringBuilder(); // TextArea??? ????????? ???????????? ????????? ?????? ??????.
        
        if(rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText()+ " ");
        }else if(rbPackage.isSelected()) {
            buffer.append(rbPackage.getText()+ " ");
        }else if(rbProtected.isSelected()) {
            buffer.append(rbProtected.getText() + " ");
        }else if(rbPublic.isSelected()) {
            buffer.append(rbPublic.getText() + " ");
        }
        
        buffer.append("????????? ?????? ??????").append("\n");
        
        if(cbAbstract.isSelected()) {
            buffer.append(cbAbstract.getText()).append(" ");
        }
        if(cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        if(cbStatic.isSelected()) {
            buffer.append(cbStatic.getText()).append(" ");
        }
        
        buffer.append("???????????? ??????").append("\n");
        
        // ComboBox??? ???????????? ????????? ?????? ???????????? ?????? ?????????
        
        String item = (String) comboBox.getSelectedItem();
        buffer.append(item + " ").append("???????????? ????????? ??????");
        
        textArea.setText(buffer.toString());
        
        
        // ?????????????????? ????????? ?????? ????????? ???????????????
        
        
        
        
    }

    private  void printCheckboxStatus(ActionEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getSource();
        String checkText = checkBox.getText();
        boolean selected = checkBox.isSelected();
        textArea.setText(checkText + " + " + selected);
        
    }

    private void printRadioButtonStatus(ActionEvent e) {
        
        JRadioButton radioBtn =(JRadioButton) e.getSource(); // ???????????? ????????? ????????? ??????
        String btnText  = radioBtn.getText(); // ????????? ????????? ?????????
        boolean selected = radioBtn.isSelected(); // ????????? ????????? ??????/?????? ??????
        textArea.setText(btnText + " + " + selected); 
        
    }
}
