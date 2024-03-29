package chess.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;

import chess.db.Connection;

public class ServerReader implements Runnable{

	//class
	ServerSender ss;
	Connection conn;
	//
	Socket socket;
	BufferedReader br;
	String nickname = "";
	public ServerReader() {}
	public ServerReader(Socket socket) {
		try {
			this.socket = socket;
			
			///
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
		StringTokenizer st;
		int tag = 0;
		String msg = "";
		String content = "";
		while(true) {
			try {
				if((msg = br.readLine())!= null) {
					System.out.println("from client = "+ msg);
					st = new StringTokenizer(msg, "#");
					tag = Integer.parseInt(st.nextToken());
					content = st.nextToken();
					System.out.println("content = "+content +"/tag = "+tag);
					
					switch(tag) {
						case 100 : 
							doLogin(content);
							break;
						case 500 :
							chatsend(content);
							break;
					}
					//ss.sendAll(msg);
				}
			}catch(Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}	
	
	
	public String chatsend(String content) {
		System.out.println("chat = " + content);
		System.out.println("nickname:"+nickname + content);
		
		String allchat = nickname+":"+content;
		System.out.println(allchat);
		String tag = "";
		if(allchat.equals("")) {
			tag = "509#";
			allchat = "채팅이 제대로 보내지지 않음.";
		}
		else {
			tag = "500#";
			ss.sendAll(tag+allchat);
		}
		//ss.sendMsg(tag+allchat);
		return allchat;
		
	}
	
	////Method////
	public String doLogin(String content) {
		System.out.println("msg = " +  content);
		StringTokenizer st = new StringTokenizer(content, "/");
		String id = st.nextToken();
		String pass = st.nextToken();
		
		
		String result = conn.do_login(id, pass);
		System.out.println("result = " +result);
		String tag = "";
		if(result.equals("")) {
			tag = "109#";
			result = "denied";
		}else {
			nickname = result;
			tag = "100#";
		}
		ss.sendMsg(tag+result);	
		return result ;
	}
	
	//setter
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public void setSender(ServerSender ss) {
		this.ss = ss;
	}
}
