package chess.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	ResultSet rs = null;
	Statement stmt = null;
	java.sql.Connection conn = null;
	PreparedStatement pstm = null; 
	
	String url = "";

	public Connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url =  "jdbc:mysql://localhost:3306/chess?serverTimezone=Asia/Seoul";
			System.out.println("Connected DB");
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//로그인 기능
	String do_login(String id, String pw) {
		int check = 0;
		String db_password = "";
		String db_nick = "";
		
		try {
			conn = DriverManager.getConnection(url, "root", "1234");
			
			String sql = "select * from user_info where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
				db_password = rs.getString("password");
				db_nick = rs.getString("nick");
			}
			if(db_password.equals(pw)) {
				check = 1;
			}else {
				check = 0;
			}
		}catch (SQLException e) {
			e.getStackTrace();
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		if(check == 1) {
			return db_nick;
		}else {
			return "";
		}
	}
	
}
