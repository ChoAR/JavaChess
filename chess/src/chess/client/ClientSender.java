package chess.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender {
	Socket socket;
	PrintWriter pw;
	
	public ClientSender() {}
	
	public ClientSender(Socket socket) throws IOException {
		System.out.println("Ready for Sending");
		
		this.socket = socket;
		pw = new PrintWriter(socket.getOutputStream());
		
//		// Thread for Send
//		Thread send = new Thread(this);
//		send.start();
//		
	}
	
	public void sendMsg(String msg) {
		pw.println(msg);
		pw.flush();
	}

//	@Override
//	public void run() {
//		Scanner s = new Scanner(System.in); 
//		String msg;
//		while(true) {
//			try {
//				System.out.println("Input : ");
//				msg = s.nextLine();
//				pw.println(msg);
//				pw.flush();
//			}catch(Exception e) {
//				e.printStackTrace();
//				break;
//			}
//			
//		}
//	}
}
