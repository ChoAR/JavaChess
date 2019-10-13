package chess.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;

import chess.gui.Login;

public class ClientReader implements Runnable{
	
	// class
	Login login;
	
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	
	public ClientReader() {}
	public ClientReader(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Thread t = new Thread(this);
			t.start();
			System.out.println("---- Thread run");			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		StringTokenizer st;
		String msg = "";
		int tag = 0;
		String content; 
		while(true) {
			try {
				if((msg = br.readLine()) != null) {
					st = new StringTokenizer(msg, "#");
					tag = Integer.parseInt(st.nextToken());
					content = st.nextToken();
					
					switch(tag) {
						case 100:	// Login Success. 
							checkAuth(content);
							break;
						case 109:	// Login failed.
							authDenied();
					}		break;
					
					
				}
			}catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	// Login 성공
	public void checkAuth(String content) {
		login.showMain();
	}
	// 로그인 실패
	public void authDenied() {
		login.denied();
	}
	
}
