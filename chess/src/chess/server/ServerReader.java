package chess.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReader implements Runnable{

	Socket socket;
	BufferedReader br;
	
	public ServerReader(Socket socket) {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// Reader 만들고 Thread 생성
			Thread t = new Thread(this);
			t.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		while(true) {
			
		}
		
	}
	
	
}
