package chess.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

import chess.client.ClientMain;
import chess.client.ClientSender;

public class Login extends JFrame {// 로그인화면
	//Class
	
	ClientSender cs;

	Image img = null;
	
	
	

	public Login() {
		JPanel p = new JPanel();
		p.setLayout(null);
		/*
		 * JLabel label = new JLabel(new ImageIcon("D:\\블로그\\project\\123.jpg"));
		 * add(label); Label t1= new Label("안녕하세요."); add(t1); Label t2= new
		 * Label("본 프로그램은 ID를 입력하셔"); add(t2); Label t3= new Label("야만 사용이 가능합니다.");
		 * add(t3); Label t4= new Label("ID입력 후 로그인 버튼을 클릭하세요."); add(t4);
		 */
		Label lb_id = new Label("ID: ");
		add(lb_id);
		Label lb_pw = new Label("PASSWORD: ");
		add(lb_pw);
		TextField tf_id = new TextField();
		add(tf_id);
		TextField tf_pw = new TextField();
		add(tf_pw);
		tf_pw.setEchoChar('*');// 암호화
		JButton btn_login = new JButton("로그인");
		add(btn_login);
		JButton btn_register = new JButton("회원가입");
		add(btn_register);

		/* label.setBounds(0, 5, 350, 255); */
		/*
		 * t1.setBounds(350, 5, 70, 40); t2.setBounds(350,35, 280, 40);
		 * t3.setBounds(350, 65,150, 40); t4.setBounds(350,95,250, 40);
		 */
		lb_id.setBounds(40, 265, 40, 40);
		lb_pw.setBounds(40, 305, 60, 40);
		tf_id.setBounds(150, 265, 200, 30);
		tf_pw.setBounds(150, 305, 200, 30);
		btn_login.setBounds(380, 265, 80, 30);
		btn_register.setBounds(380, 305, 90, 30);
		add(p);
		setSize(560, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면 ");
		setVisible(true);
		
		//회원가입 버튼을 눌렀을 경우
		btn_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// 회원가입창으로 이동
				
				System.out.println("회원가입 버튼 클릭됨");
				Register register = new Register();
			}
		});
		
		//로그인 버튼을 눌렀을 경우
		btn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {
				String id = tf_id.getText();
				String pass = tf_pw.getText();
				cs.sendMsg("100#"+id+"/"+pass);
			}
		});
	}
	
	public void showMain() {
		JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
		ChessGUI2 cg = new ChessGUI2();
		cg.setSender(cs);
		JFrame f = new JFrame("소켓을 활용한 1:1 체스게임");
		f.setLayout(new BorderLayout());
		f.add(cg.chessGame, BorderLayout.CENTER);
		f.add(cg.chatting, BorderLayout.SOUTH);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		f.setSize(1000, 1000);
		this.setVisible(false);
	}
	
	// failed Connect to Server
	public void notConnect() {
		JOptionPane.showMessageDialog(null,"Server not Working..\nIt will closed.");
		System.exit(0);
	}
	
	public void denied() {
		JOptionPane.showMessageDialog(null, "회원정보를 다시 확인하시오.");
	}
	
	

	
	public void setSender(ClientSender cs) {
		this.cs = cs;
	}
	

}
