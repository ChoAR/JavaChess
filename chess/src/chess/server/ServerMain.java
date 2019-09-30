package chess.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	ServerSocket server;
	PrintWriter pw;
	BufferedReader br;
	
	// 기본 생성자
	public ServerMain() {
		System.out.println("Launched Server");
	}
	
	// 연결 초기화
	public void connection() {
		try {
			server = new ServerSocket(12345);
			
			while(true) {
				System.out.println("waiting..");
				Socket socket = server.accept();
				System.out.println("connected");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = br.readLine();
				System.out.println(msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerMain sm = new ServerMain();
		sm.connection();
	}
}
