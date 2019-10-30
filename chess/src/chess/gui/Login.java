<<<<<<< HEAD
package chess.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Login extends JFrame{//�α���ȭ��
	Image img = null;
	public Login()
	{
		try {
			String path = Login.class.getResource("").getPath();
			File sourceimage = new File(path+"chessImage.png");
			img = ImageIO.read(sourceimage);
		} catch (IOException e) {
			System.out.println("�̹��������� �����ϴ�.");
		}
		JLabel label = new JLabel(new ImageIcon(img));
		JPanel p = new JPanel();
        p.setLayout(null);
        add(label);
		Label b2= new Label("���̵�:");
		add(b2);
		Label b3= new Label("��й�ȣ:");
		add(b3);
		TextField b4 = new TextField();
		add(b4);
		TextField b5 = new TextField();
		add(b5);
		b5.setEchoChar('*');//��ȣȭ
		JButton b6 = new JButton("�α���");
		add(b6);
		JButton b7 = new JButton("ȸ������");
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
		setTitle("�α��� ȭ�� ");
		setVisible(true);
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//ȸ������â���� �̵�
				// TODO Auto-generated method stub
				Register f2= new Register();
			}
		});;
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {//�α��� �Ҷ� 
				// TODO Auto-generated method stub
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("ȸ�����.txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
					if(b4.getText().equals(array[1])&&b5.getText().equals(array[2]))
					{
						JOptionPane.showMessageDialog(null, "�α����� �Ǿ����ϴ�!!");
						ChessGUI2 cg = new ChessGUI2();
				        JFrame f = new JFrame("������ Ȱ���� 1:1 ü������");
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
						JOptionPane.showMessageDialog(null, "�α����� �����Ͽ����ϴ�.");
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
	
	  public static void main(String[] args) {//�α���ȭ������ ���� // TODO Auto-generated
		  Login f = new Login();
	  
	  }
	 
}

=======
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
	public ChessGUI2 cg;
	
	

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
		cg = new ChessGUI2();
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
>>>>>>> d2f8d79a8a54f674bcda12e2849fe22b01d4ec05
