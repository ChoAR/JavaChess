package chess.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientReader implements Runnable{
	
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	
	public ClientReader() {}
	public ClientReader(Socket socket) {
		this.socket = socket;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Scanner s = new Scanner(System.in);
			Thread t = new Thread(this);
			t.start();
			System.out.println("---- Thread run");
			
			pw = new PrintWriter(socket.getOutputStream());
			while(true) {
				System.out.println("enter : ");
				String str = s.next();
				pw.println(str);
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String msg = "";
		int tag = 0;
		
		while(true) {
			try {
				if((msg = br.readLine()) != null) {
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
