package gui.practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame {
    public Login() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("ID : ");
        JLabel pw = new JLabel("Password : ");
        JTextField txtId = new JTextField(20);
        JPasswordField txtPass = new JPasswordField(10);
        JButton logBtn = new JButton("Log In");
        
        panel.add(label);
        panel.add(txtId);
        panel.add(pw);
        panel.add(txtPass);
        panel.add(logBtn);
       
        
        // 로그인 버튼을 눌렀을때 맞는 아이디인지 확인하기위해 만드는 기능
        logBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              String id ="byeon";
              String pw = "1234";
              
              if(id.equals(txtId.getText())&&pw.equals(txtPass.getText())) {
                  JOptionPane.showMessageDialog(null,"환영합니다.");
              }else {
                  JOptionPane.showMessageDialog(null,"다시 입력해주세요");
              }
                
            }
            
        });
        add(panel);
        
        setVisible(true);
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Login() ;
            
        
    }
}
