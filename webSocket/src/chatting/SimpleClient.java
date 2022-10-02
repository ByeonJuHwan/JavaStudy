package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) {
		InputStream is;
		BufferedReader br_in;
		BufferedReader br_out;
		BufferedWriter bw;
		PrintWriter pw =null;
		OutputStream os;
		Socket s1 = null;
		ServerSocket serverSocket;
		String inMessage = null;
		String outMessage = null;
		try {
			s1 = new Socket("127.0.0.1", 5434);
			is = s1.getInputStream();
			os = s1.getOutputStream();
			br_in = new BufferedReader(new InputStreamReader(is));
			br_out = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw,true);
			while(true) {
				inMessage = br_in.readLine();
				System.out.println(inMessage);
				
				System.out.print("client : ");
				outMessage = br_out.readLine();
				if(outMessage.equals("exit")) {
					break;
				}
				pw.println("client : " + outMessage);
			}
			pw.close();
			s1.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
