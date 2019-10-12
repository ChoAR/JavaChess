package chess.server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerMain {
	
	private static final int PORT = 12345;
	
	ServerSocket server;
	PrintWriter pw;
	BufferedReader br;
	SocketList sl;
	// 기본 생성자
	public ServerMain() {
		System.out.println("Launched Server");
		
	}
	
	// 연결 초기화
	public void connection() {
		try {
			server = new ServerSocket(PORT);
			
			sl = new SocketList();
			
			while(true) {
				System.out.println("waiting..");
				Socket socket = server.accept();
				System.out.println("connected");
				
				ServerSender ss = new ServerSender(socket);
				ServerReader sr = new ServerReader(socket);
				sl.addUser(socket);
				sr.setSender(ss);
				ss.setList(sl);
			}
			
		} catch(SocketException se) {
			System.out.println("disconnected");
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerMain sm = new ServerMain();
		sm.connection();
	}
}
