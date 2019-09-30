package chess.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientMain {
	private static final int PORT = 12345;
	Socket socket;
	PrintWriter pw;
	BufferedReader bis;
	
	public ClientMain() {

	}
	
	public void connect() {
		try {
			socket = new Socket("localhost", PORT );
			
			ClientReader cr = new ClientReader(socket);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		ClientMain cm = new ClientMain();
		cm.connect();
	}
}
