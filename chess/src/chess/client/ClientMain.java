package chess.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import chess.gui.Login;


public class ClientMain {
	private static final int PORT = 12345;
	Socket socket;
	PrintWriter pw;
	BufferedReader bis;
	
	//Class
	Login login;
	
	public ClientMain() {

	}
	
	// control Login Gui
	public ClientMain(Login login) {
		this.login = login;
	}
	
	public void connect() {
		try {
//			socket = new Socket("localhost", PORT );
			socket = new Socket("localhost", PORT );
		
			ClientReader cr = new ClientReader(socket);
			
			ClientSender cs = new ClientSender(socket);
			login.setSender(cs);
			
			
			//
			cr.setLogin(login);
			
		} catch (Exception e) {
			login.notConnect();
			e.printStackTrace();
		} 
	}
	
}
