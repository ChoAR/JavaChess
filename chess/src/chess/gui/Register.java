package chess.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;
public class Register extends JFrame {//ȸ������ȭ��
	public Register(){
		  	JPanel p = new JPanel();
		  	Label l1= new Label("ID");	
	        Label l2 = new Label("PASSWORD");
	        Label l3= new Label("PASSWORD Ȯ��");
	        Label l4 = new Label("�г���");
		/* Label l5 = new Label("�г���"); */
	        add(l1);
	        add(l2);
	        add(l3);
	        add(l4);
		/* add(l5); */
	        TextField t1 = new TextField();
	        TextField t2 = new TextField();
	        TextField t3 = new TextField();
	        TextField t4 = new TextField();
		/* TextField t5 = new TextField(); */
	        add(t1);
	        add(t2);
	        add(t3);
	        add(t4);
		/* add(t5); */
	        t3.setEchoChar('*');
	        JButton j1 = new JButton("����");
	        JButton j2 = new JButton("���");
	        add(j1);
	        add(j2);
	        
	        l1.setBounds(60, 30, 40, 40);
	        l2.setBounds(40, 70, 80, 40);
	        l3.setBounds(30, 110, 100, 40);
	        l4.setBounds(60, 150, 40, 40);
		/* l5.setBounds(40, 170, 40, 40); */
	        
	        t1.setBounds(140, 30, 200, 30);
	        t2.setBounds(140, 70, 200, 30);
	        t3.setBounds(140, 110, 200, 30);
	        t4.setBounds(140, 150, 200, 30);
		/* t5.setBounds(120, 180, 200, 30); */
	        
	        j1.setBounds(135, 240, 80, 30);
	        j2.setBounds(250, 240, 80, 30); 
	    add(p);
		setSize(450,350);
		setTitle("ȸ������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       j1.addActionListener(new ActionListener() {
		@Override
		 public void actionPerformed(ActionEvent T) {//ȸ������ ������ ����
			try{
				BufferedWriter bos = new BufferedWriter(new FileWriter("ȸ�����.txt",true));
				bos.write(t1.getText()+"/");
				bos.write(t2.getText()+"/");
				bos.write(t3.getText()+"/");
				bos.write(t4.getText()+"\r\n");
					/* bos.write(t5.getText()+"\r\n"); */
				bos.close();
				JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
				dispose();
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
			}
		 } 
	   });
       j2.addActionListener(new ActionListener() {
   		@Override
   		 public void actionPerformed(ActionEvent T) {//ȸ������ ������ ����
   			dispose();
   		 } 
   	   });
	}    
}

