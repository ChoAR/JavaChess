package chess.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ServerReader implements Runnable{

	Socket socket;
	BufferedReader br;
	
	
	
	public ServerReader() {}
	public ServerReader(Socket socket) {
		try {
			
			this.socket = socket;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// Reader 만들고 Thread 생성
			Thread t = new Thread(this);
			t.start();
			System.out.println("Create Receive");
			
		} catch(SocketException se) {
			System.out.println("disconnected");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		int tag = 0;
		String msg = "";
		
		while(true) {
			try {
				if((msg = br.readLine())!= null) {
					System.out.println(msg);
				}
			} catch(SocketException se) {
				se.printStackTrace();
				System.out.println("disconnected");
				break;
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
