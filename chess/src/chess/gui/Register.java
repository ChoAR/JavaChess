package chess.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;

import chess.db.Connection;

import java.awt.*;

public class Register extends JFrame {// 회원가입화면
	public Register() {
		Connection db = new Connection();
		JPanel p = new JPanel();
		Label lb_id = new Label("ID");
		Label lb_pw = new Label("PASSWORD");
		Label lb_pwCheck = new Label("PASSWORD check");
		Label l4 = new Label("nickname");
		/* Label l5 = new Label("닉네임"); */
		add(lb_id);
		add(lb_pw);
		add(lb_pwCheck);
		add(l4);
		/* add(l5); */
		TextField tf_id = new TextField();
		TextField tf_pw = new TextField();
		TextField tf_pwCheck = new TextField();
		TextField tf_nick = new TextField();
		/* TextField t5 = new TextField(); */
		add(tf_id);
		add(tf_pw);
		add(tf_pwCheck);
		add(tf_nick);
		/* add(t5); */
		tf_pw.setEchoChar('*');
		tf_pwCheck.setEchoChar('*');
		JButton btn_register = new JButton("회원가입");
		JButton btn_back = new JButton("돌아가기");
		add(btn_register);
		add(btn_back);

		lb_id.setBounds(60, 30, 40, 40);
		lb_pw.setBounds(40, 70, 80, 40);
		lb_pwCheck.setBounds(30, 110, 100, 40);
		l4.setBounds(60, 150, 40, 40);
		/* l5.setBounds(40, 170, 40, 40); */

		tf_id.setBounds(140, 30, 200, 30);
		tf_pw.setBounds(140, 70, 200, 30);
		tf_pwCheck.setBounds(140, 110, 200, 30);
		tf_nick.setBounds(140, 150, 200, 30);
		/* t5.setBounds(120, 180, 200, 30); */

		btn_register.setBounds(135, 240, 80, 30);
		btn_back.setBounds(250, 240, 80, 30);
		add(p);
		setSize(450, 350);
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btn_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {// 회원가입 데이터 저장
				try {
					int check = 0;
					System.out.println("회원가입 버튼을 누르셨습니다.");
					String id, pw, pwCheck, nick;
					id = tf_id.getText();
					pw = tf_pw.getText();
					pwCheck = tf_pwCheck.getText();
					nick = tf_nick.getText();
					
					if(pw.equals(pwCheck) && !pw.equals("")) {
						System.out.println("pw check"+ !(pw.equals("")));
						System.out.println("pw , pwCheck >> " + pw +"/"+ pwCheck);
						check = db.do_register(id, pwCheck, nick);
						System.out.println("check >> " + check);
						dispose();
						
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
					}else {
						JOptionPane.showMessageDialog(null, "다시 확인 후 회원가입 해주세요");
					}
//					BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt", true));
//					bos.write(tf_id.getText() + "/");
//					bos.write(tf_pw.getText() + "/");
//					bos.write(tf_pwCheck.getText() + "/");
//					bos.write(tf_nick.getText() + "\r\n");
//					// /* bos.write(t5.getText()+"\r\n"); */	//사용 안함
//					bos.close();
					
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
				}
			}
		});
	}
}
