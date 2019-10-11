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
	String user = "root";
	String password = "1234";
	public Connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url =  "jdbc:mysql://localhost:3306/chess?serverTimezone=Asia/Seoul";
			System.out.println("Connected DB");
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//로그인 기능
	public String do_login(String id, String pw) {
		int check = 0;
		String db_password = "";
		String db_nick = "";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			
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
			System.out.println("check >> " + check);
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
	
	//회원가입 기능
	public int do_register(String id, String pw, String nick) {
		System.out.println("회원가입 메소드 실행 / id : " + id + " / pw : " + pw + " / nick : " + nick);
		int insertCheck = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into user_info values(?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,  0);
			pstm.setString(2, id);
			pstm.setString(3, pw);
			pstm.setString(4, nick);
			pstm.setInt(5, 0);
			insertCheck = pstm.executeUpdate();	//쿼리실행
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.getStackTrace();
			e.printStackTrace();
		}finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertCheck;
	}
	
}
