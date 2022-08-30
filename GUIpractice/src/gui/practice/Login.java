package gui.practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Login extends JFrame {
    public Login() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("ID");
        JTextField txtId = new JTextField(20);
        
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
