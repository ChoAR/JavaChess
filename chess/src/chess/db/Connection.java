package chess.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {

	public Connection() {
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		PreparedStatement pstm = null; 
		
		String url = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url =  "jdbc:mysql://localhost:3306/chess?serverTimezone=Asia/Seoul";
			System.out.println("Connected DB");
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
}
