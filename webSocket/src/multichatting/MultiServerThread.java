package multichatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServerThread extends Thread{
	InputStream is;
	BufferedReader br_in;
	Socket socket = null;
	BufferedReader br_out;
	BufferedWriter bw;
	PrintWriter pw = null;
	OutputStream os;
	ServerSocket serverSocket;
	String Message = null;
	
	@Override
	public void run() {
		System.out.println("MultiServerThread is called");
		boolean isStop = false;
		try {
			is = ChattingServer.socket.getInputStream();
			os = ChattingServer.socket.getOutputStream();
			br_in = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw,true);
			while(!isStop) {
				Message = br_in.readLine();
				String[] str = Message.split("#");
				if(str[1].equals("exit")) {
					broadCasting(Message);
					isStop=true;
				}else {
					broadCasting(Message);
				} // end else
			}// end while
			ChattingServer.list.remove(this);
			ChattingServer.textArea.append(ChattingServer.socket.getInetAddress() + "IP 주소의 사용자 께서 종료하셨습니다.\n");
			ChattingServer.textField.setText("남은 사용자 수 : " + ChattingServer.list.size());
			
		}catch(Exception e) {
			ChattingServer.list.remove(this);
			ChattingServer.textArea.append(ChattingServer.socket.getInetAddress() + "IP 주소의 사용자 께서 비정상 종료하셨습니다.\n");
			ChattingServer.textField.setText("남은 사용자 수 : " + ChattingServer.list.size());
		}
		
	}//end run

	private void broadCasting(String message) {
		System.out.println("broadCasting is called");
		for(MultiServerThread ct : ChattingServer.list) {
			ct.send(message);
		}
		
	}

	private void send(String message) {
		pw.println(message);
		
	}
	
}
