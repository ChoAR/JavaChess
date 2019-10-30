package chess.gui;

import chess.client.ClientMain;

public class MainGui {

	public static void main(String[] args) {
		Login login = new Login();
		ClientMain cm = new ClientMain(login);
		cm.connect();
	} 
}
