package chess.server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
				
				ServerReader sr = new ServerReader(socket);
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
