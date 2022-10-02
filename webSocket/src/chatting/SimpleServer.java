package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		InputStream is;
		BufferedReader br_in;
		BufferedReader br_out;
		BufferedWriter bw;
		PrintWriter pw =null;
		OutputStream os;
		ServerSocket serverSocket;
		Socket s1 = null;
		String inMessage = null;
		String outMessage = null;
		try {
			serverSocket = new ServerSocket(5434);
			System.out.println("서버 실행 중.....");
			s1 = serverSocket.accept();
			is = s1.getInputStream();
			os = s1.getOutputStream();
			br_out = new BufferedReader(new InputStreamReader(System.in));
			br_in = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw,true);
			pw.println("server : 접속을 환영합니다.");
			
			while(true) {
				inMessage = br_in.readLine(); // 클라이언트 쪽에서 보낸 메세지
				System.out.println(inMessage);
				System.out.print("server : ");
				outMessage = br_out.readLine(); // 서버에서 키보드로 입력한 데이터
				if(outMessage.equals("exit")) {
					break;
				}
				pw.println("server: " + outMessage);
			}
			pw.close();
			s1.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		

	}

}
