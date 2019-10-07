package chess;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Login extends JFrame{//로그인화면
	Image img = null;
	public ex1()
	{
		try {
			String path = ex1.class.getResource("").getPath();
			File sourceimage = new File(path+"chessImage.png");
			img = ImageIO.read(sourceimage);
		} catch (IOException e) {
			System.out.println("이미지파일이 없습니다.");
		}
		JLabel label = new JLabel(new ImageIcon(img));
		JPanel p = new JPanel();
        p.setLayout(null);
        add(label);
		Label b2= new Label("아이디:");
		add(b2);
		Label b3= new Label("비밀번호:");
		add(b3);
		TextField b4 = new TextField();
		add(b4);
		TextField b5 = new TextField();
		add(b5);
		b5.setEchoChar('*');//암호화
		JButton b6 = new JButton("로그인");
		add(b6);
		JButton b7 = new JButton("회원가입");
		add(b7);
		
		label.setBounds(0, 0, 600, 250);
		b2.setBounds(40, 265, 40, 40);
		b3.setBounds(40, 305, 60, 40);
		b4.setBounds(150, 265, 200, 30);
		b5.setBounds(150, 305, 200, 30);
		b6.setBounds(380, 265, 80, 30);
		b7.setBounds(380, 305, 90, 30);
		add(p);
		setSize(560, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면 ");
		setVisible(true);
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//회원가입창으로 이동
				// TODO Auto-generated method stub
				ex2 f2= new ex2();
			}
		});;
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {//로그인 할때 
				// TODO Auto-generated method stub
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("회원명단.txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
					if(b4.getText().equals(array[1])&&b5.getText().equals(array[2]))
					{
						JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
						ChessGUI2 cg = new ChessGUI2();
				        JFrame f = new JFrame("소켓을 활용한 1:1 체스게임");
				        f.setLayout(new BorderLayout());
				        f.add(cg.chessGame, BorderLayout.CENTER);
				        f.add(cg.chatting, BorderLayout.SOUTH);
				        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        f.pack();
				        f.setVisible(true);
				        f.setSize(1000,1000);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
					}
					}
					bos.close();
					dispose();
				}catch (IOException E10){
					E10.printStackTrace();
				}
			}
		});
	}
	/*
	 * public static void main(String[] args) {//로그인화면으로 실행 // TODO Auto-generated
	 * method stub Login f = new Login();
	 * 
	 * }
	 */
}

