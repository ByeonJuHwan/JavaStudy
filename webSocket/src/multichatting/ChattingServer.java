package multichatting;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingServer {
	public static ArrayList<MultiServerThread> list; // 클라이언트와 통신 스레드객체를 저장하는 리스트.
	public static Socket socket;
	private ServerSocket serverSocket = null;
	
	private JFrame frame;
	public static JTextField textField;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingServer window = new ChattingServer();
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
	public ChattingServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("다중 채팅 서버");
		frame.setBounds(100, 100, 686, 502);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 670, 389);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 401, 670, 52);
		frame.getContentPane().add(textArea);
		
		list = new ArrayList<>();
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("127.0.0.1",5000));
			MultiServerThread mst = null;
			boolean isStop = true;
			textField.setText("서버 정상 실행 중입니다. 관리자님 !!");
			System.out.println("isStop : " + isStop);
			while(isStop) {
				socket = serverSocket.accept();
				mst = new MultiServerThread();
				list.add(mst);
				mst.start();
			} // while 문
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
