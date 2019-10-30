package chess.server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


import com.sun.javafx.collections.MappingChange.Map;

public class SocketList {
	ArrayList<Socket> map;
	
	public SocketList() {
		map = new ArrayList<Socket>();
	}
	
	public void addUser(Socket pw) {
		map.add(pw);
	}
	
	public int userCount() {
		return map.size();
	}
	
	
	public ArrayList<Socket> getAll() {
		return map;
	}
}
