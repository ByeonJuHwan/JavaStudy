package multichatting;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;



import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client implements Runnable{
	private static final String SERVER_IP = "127.0.0.1";
	private static Socket socket;
	private String ip;
	private String chatName;
	private InputStream is;
	private OutputStream os;
	private BufferedReader br_in;
	private BufferedWriter bw = null;
	private PrintWriter pw = null; 
	private JFrame frame;
	private JButton btnExit;
	private JTextField textField;
	private JLabel lblChatName;
	private JLabel lblServerIpName;
	private JTextArea textArea;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    Client window = new Client();
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
	public Client() {
		chatName = JOptionPane.showInputDialog(frame,"대화명을 입력하세요!!","대화명 입력 다이얼로그",
				JOptionPane.YES_NO_OPTION);
		if(chatName.length() == 0 || chatName ==null) {
			System.exit(0);
		}
		
		initialize();
		init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("멀티 채팅 클라이언트 프로그램");
		frame.setResizable(false);
		frame.setBounds(100, 100, 594, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pw.println(chatName + "#exit");
				}catch (Exception ee) {
					ee.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnExit.setBounds(481, 396, 97, 23);
		frame.getContentPane().add(btnExit);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				String msg = textField.getText();
				if(obj==textField) {
					if(msg == null || msg.length() == 0) {
						JOptionPane.showMessageDialog(frame, "글을 써주세요.", "경고", JOptionPane.WARNING_MESSAGE);
					}else { // 내용을 입력하고 엔터한경우
						try {
							pw.println(chatName+"#"+msg);
						}catch(Exception ee) {
							ee.printStackTrace();
						} // catch
						textField.setText("");
					}
				}
			} // actionPerformed
		});
		textField.setBounds(0, 397, 482, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.YELLOW);
		textArea.setBounds(0, 38, 578, 359);
		frame.getContentPane().add(textArea);
		
		lblChatName = new JLabel("대화명 : [[" + chatName + "]]");
		lblChatName.setBounds(0, 0, 202, 39);
		frame.getContentPane().add(lblChatName);
		
		lblServerIpName = new JLabel("서버 IP 주소 " + SERVER_IP);
		lblServerIpName.setBounds(345, 0, 233, 39);
		frame.getContentPane().add(lblServerIpName);
	}
	
	public void init() {
		try {
			socket = new Socket(SERVER_IP,5000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			br_in = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw,true);  // 자동으로 flush 한다.
			Thread t = new Thread(this);
			t.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// end init
	@Override
	public void run() {
		String message = null;
		String [] receiveMag = null;
		boolean isStop = false;
		while(!isStop) {
			try {
				message = (String)br_in.readLine();
				receiveMag  = message.split("#");
			}catch(Exception e) {
				e.printStackTrace();
				isStop=true;  // 반복문 설정 종료
			}
			System.out.println(receiveMag[0]+ ":" + receiveMag[1]);
			if(receiveMag[1].equals("exit")) { // 해당 사용자
				if(receiveMag.equals(chatName)) {
					System.exit(0);
				}else { // 그 외 사용자
					textArea.append(
							receiveMag[0] + "님이 종료했습니다.\n");
					textArea.setCaretPosition(
							textArea.getDocument().getLength());
				}
			}else { // exit이 아닐경우
				// 채팅 내용을 화면에 보여준다
				textArea.append(receiveMag[0] + ":" + receiveMag[1] +"\n");
				
				textArea.setCaretPosition(
						textArea.getDocument().getLength());
			}
		}
		
	}
}// end class
