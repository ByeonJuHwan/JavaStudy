package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

    private JFrame frame;
    private JButton btnConfirmDlg;
    private JButton btnOptionDlg;
    private JButton btnInputDlg;
    private JButton btnCustomDlg;
    private JButton btnCustomFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
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
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 673);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [닫기] 버튼 클릭 동장 -> 프로그램 종료
        frame.getContentPane().setLayout(null);
        
        JButton btnMsgDlg = new JButton("Message Dialog");
        btnMsgDlg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "안녕하세요");
                JOptionPane.showMessageDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트
                        "안녕하세요?", // 다이얼로그에 표시될 메세지
                        "메시지", // 다이얼로그의 타이틀
                        JOptionPane.PLAIN_MESSAGE, // 메시지 타입
                        null // 아이콘
                        );
            }
        });
        btnMsgDlg.setFont(new Font("굴림", Font.PLAIN, 19));
        btnMsgDlg.setBounds(12, 10, 410, 79);
        frame.getContentPane().add(btnMsgDlg);
        
        btnConfirmDlg = new JButton("Confirm Dialog");
        btnConfirmDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int result = JOptionPane.showConfirmDialog(frame, "삭제할까요?");
                int result = JOptionPane.showConfirmDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트
                        "삭제할까요?", // 다이얼로그에 표시될 메세지
                        "삭제 확인", // 다이얼로그의 타이틀
                        JOptionPane.OK_CANCEL_OPTION, // 확인 옵션(YES-NO, YES-NO-CANCEL, ... ) 개수
                        JOptionPane.PLAIN_MESSAGE, // 메시지 타입 (-> 아이콘을 자동으로 설정)
                        null // 아이콘 설정
                        );
                // showConfirmDialog의 리턴값 :
                // YES = 0, NO = 1, CANCLE = 2, X(종료) = -1
                btnConfirmDlg.setText(("Confirm = " + result));
            }
        });
        btnConfirmDlg.setFont(new Font("굴림", Font.PLAIN, 19));
        btnConfirmDlg.setBounds(12, 118, 410, 79);
        frame.getContentPane().add(btnConfirmDlg);
        
        btnOptionDlg = new JButton("Option Dialog");
        btnOptionDlg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] options = {"아니요","어려워요","재밌어요"};
               int result = JOptionPane.showOptionDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트
                        "허허허", // 다이얼로그에 표시될 메세지
                        "확인", // 다이얼로그의 타이틀
                        JOptionPane.YES_NO_CANCEL_OPTION, // 다이얼로그의 옵션 타입 (YES-NO, YES-NO-CANCLE, ...)
                        JOptionPane.ERROR_MESSAGE, // 메시지 타입
                        null, // 아이콘
                        options, // 옵션 배열에서 사용할 문자열 배열
                        options[2] // 다이얼로그가 실행될 때 포커스를 받는 버튼 옵션
                        );
               btnOptionDlg.setText("result = " + result);
            }
        });
        btnOptionDlg.setFont(new Font("굴림", Font.PLAIN, 19));
        btnOptionDlg.setBounds(12, 220, 410, 79);
        frame.getContentPane().add(btnOptionDlg);
        
        btnInputDlg = new JButton("Input Dialog");
        btnInputDlg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // String input = JOptionPane.showInputDialog("이름?");
                // -> OK 버튼을 클릭하면 입력한 내용이 리턴, Cancel을 클릭하면 빈 문자열을 리턴.
                Object[] selectionValues = {"10대","20대","30대","40대"};
                Object input = JOptionPane.showInputDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트
                        "나이?", // 다이얼로그에 표시될 메세지
                        "확인", // 다이얼로그의 타이틀
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입
                        null, // 아이콘
                        selectionValues, // 선택 값들의 배열
                        selectionValues[2] // 선택 값들 중에서 포커스를 받는 컴포넌트
                        );
                btnInputDlg.setText(""+input);
            }
        });
        btnInputDlg.setFont(new Font("굴림", Font.PLAIN, 19));
        btnInputDlg.setBounds(12, 319, 410, 79);
        frame.getContentPane().add(btnInputDlg);
        
        btnCustomDlg = new JButton("Custom Dialog");
        btnCustomDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomDialog.showMyCustomDialog();
                
            }
        });
        btnCustomDlg.setFont(new Font("굴림", Font.PLAIN, 19));
        btnCustomDlg.setBounds(12, 408, 410, 79);
        frame.getContentPane().add(btnCustomDlg);
        
        btnCustomFrame = new JButton("Custom Frame");
        btnCustomFrame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MyCustomFrame.showMyCustomFrame(); // arguments를 통해서 데이터 주고받기 가능
            }
        });
        btnCustomFrame.setFont(new Font("굴림", Font.PLAIN, 19));
        btnCustomFrame.setBounds(12, 501, 410, 79);
        frame.getContentPane().add(btnCustomFrame);
    }
}
