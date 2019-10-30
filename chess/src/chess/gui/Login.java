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

