package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SimpleClient {

	public static void main(String[] args) {
		BufferedReader br_out;
		BufferedWriter bw;
		PrintWriter pw = null;
		OutputStream os;
		String outMessage = null;
		
		try {
			Socket s1 = new Socket("127.0.0.1",5434);
			os = s1.getOutputStream();
			RecvThread rThread = new RecvThread(s1);
			rThread.start();
			
			br_out = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw,true);
			
			while(true) {

				outMessage = br_out.readLine();
				if(outMessage.equals("exit")) {
					break;
				}
				pw.println("client : " + outMessage);
			}// end while
			
			pw.close();
			s1.close();
			
			if(rThread.isAlive()) {
				rThread.interrupt();
				rThread = null;
			}
		}catch(SocketException e) {
			System.out.println("서버로 부터 연결이 끊어졌습니다. 종료합니다...");
			System.exit(0);
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
