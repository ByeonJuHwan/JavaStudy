package data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        
        try {
            // socket의 생성 및 연결
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost",5001));
            // while 문을 사용하는 이유는 서버는 항상 클라이언트의 요청을 기다려야한다.
            while(true) {
                System.out.println("연결 기다림.");
                
                // 클라이언트로 부터의 연결을 기다린다.
                // 연결이 오게되면 Socket이라는 통신용 Socket을 만들고 리턴한다.
                Socket socket = serverSocket.accept();
                
                
                // 중간의 (InetSocketAddress) 는 .getRemoteSocketAddress 가 SocketAddress 값을
                // 리턴하기때문에 InetSocketAddress 값을 얻기위해 형변환을 한것이다.
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                
                System.out.println("연결 수락함 : " + isa.getHostName());
                
                // 데이터를 주고 받는 코드
                byte[] bytes = null;
                 String message = null;
                 
                 InputStream is = socket.getInputStream();
                 bytes = new  byte[100];
                 int readByteCount = is.read(bytes); // 클라이언트가 메세지를 보내게 되면 bytes에 저장되고 실제 데이터는 readByteCount에 저장됨.
                 message = new String(bytes,0,readByteCount,"UTF-8");
                 System.out.println("데이터받기 성공 : " + message);
                 
                 // 서버가 클라이언트로 데이터를 보내는 코드
                 
                 OutputStream os = socket.getOutputStream();
                 message = "Hello Client";
                 bytes=message.getBytes("UTF-8");
                 os.write(bytes);
                 os.flush();
                 System.out.println("데이터 보내기 성공!");
                 
                 is.close();
                 os.close();
                 socket.close();
                 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 서버를 닫는 콛를 작성해준다.
        if(!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
