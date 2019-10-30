<<<<<<< HEAD
package chess.gui;
// �ʱ�ȭ�� ������!
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class ChessGUI2 extends JFrame implements ActionListener{
	JPanel chessGame = new JPanel(); // Center
	GridBagLayout gb;
	GridBagConstraints gbc;
	JPanel chessBoard = new JPanel(); // Center - Center
	JPanel player1 = new JPanel(); // West
	JPanel player2 = new JPanel(); // East
	JPanel chatting = new JPanel(); // South
	JPanel chattingInput = new JPanel(); // South - South	
	JButton[][] chessBoardSquares = new JButton[8][8];
	Image[][] chessPieceImages= new Image[2][6];
    public static final int QUEEN = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = { ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK };
    public static final int BLACK = 0, WHITE = 1;
    JTextArea chatArea = new JTextArea(10,50);
    JTextField chatField = new JTextField(70);
    JLabel GoldPlayer = new JLabel("GoldPlayer : ");
    JLabel WhitePlayer = new JLabel("WhitePlayer : ");
    JLabel Name1 = new JLabel("Name1");
    JLabel Name2 = new JLabel("Name2");
    JButton chatButton = new JButton("�Է�");
    JButton GoldStart = new JButton("Ready");
    JButton WhiteStart = new JButton("Ready");
    JButton GiveUp1 = new JButton("GiveUp");
    JButton GiveUp2 = new JButton("GiveUp");
	public ChessGUI2(){
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		chessGame.setLayout(gb);
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        tools.setBackground(Color.GRAY);
        gbinsert(tools, 1, 0, 1, 1);
        Action newGameAction = new AbstractAction("New") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        player1.setLayout(null);
        player2.setLayout(null);
		chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8,8,8,8),new LineBorder(Color.BLACK)));
        Color backgroundColor = new Color(204,119,34);
        chessBoard.setBackground(backgroundColor);
        chatting.setLayout(new BorderLayout());
	    chessBoardSquares = new JButton[8][8];
	    chessPieceImages = new Image[2][6];
	    Insets buttonMargin = new Insets(0, 0, 0, 0);
	    try {
	    	URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url);
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	    for (int ii = 0; ii < 8; ii++) {
	    	for (int jj = 0; jj < 8; jj++) {
	    		JButton b = new JButton();
	            b.setMargin(buttonMargin);
	            ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	            b.setIcon(icon);
	            if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
	            	b.setBackground(Color.WHITE);
	            } else {
	                   	b.setBackground(Color.BLACK);
	                   }
	            chessBoardSquares[ii][jj] = b;
	            chessBoard.add(b);
	        }
	    }
	    /*
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][0].setIcon(new ImageIcon(chessPieceImages[BLACK][STARTING_ROW[ii]]));
	    }
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][1].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
	    }
	    // set up the white pieces
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][6].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
	    }
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][7].setIcon(new ImageIcon(chessPieceImages[WHITE][STARTING_ROW[ii]]));
	    }*/
	    for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
             chessBoard.add(chessBoardSquares[ii][jj]);
            }
        }
	    player1.setBackground(Color.LIGHT_GRAY);
	    player1.add(GoldPlayer);
	    GoldPlayer.setBounds(20, 20, 100, 20);
	    player1.add(Name1);
	    Name1.setBounds(20, 50, 100, 20);
	    player1.add(GoldStart);
	    GoldStart.setBounds(20, 80, 100, 30);
	    player1.add(GiveUp1);
	    GiveUp1.setBounds(20, 120, 100, 30);
	    
	    player2.setBackground(Color.LIGHT_GRAY);
	    player2.add(WhitePlayer);
	    WhitePlayer.setBounds(20, 20, 100, 20);
	    player2.add(Name2);
	    Name2.setBounds(20, 50, 100, 20);
	    player2.add(WhiteStart);
	    WhiteStart.setBounds(20, 80, 100, 30);
	    player2.add(GiveUp2);
	    GiveUp2.setBounds(20, 120, 100, 30);
	    
	       gbinsert(player1, 0, 1, 1, 1);
	    gbinsert(chessBoard, 1, 1, 1, 1);
	       gbinsert(player2, 2, 1, 1, 1);
	    chattingInput.add(chatField);
	    chattingInput.add(chatButton);
	    chatting.add(chatArea, BorderLayout.CENTER);
	    chatting.add(chattingInput, BorderLayout.SOUTH);
	    
	    GoldStart.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		JButton GoldStart = (JButton) e.getSource();
				if(GoldStart.getText().equals("Ready")) {
					GoldStart.setText("Start Game");
					GoldStart.setBackground(Color.red);
				}
				/*
				else {
					GoldStart.setText("Ready");
					GoldStart.setBackground(Color.white);
				} 		
				*/
	    	}
	    });
	    WhiteStart.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		JButton WhiteStart = (JButton) e.getSource();
				if(WhiteStart.getText().equals("Ready")) {
					WhiteStart.setText("Start Game");
					WhiteStart.setBackground(Color.red);
				}
				/*
				else {
					WhiteStart.setText("Ready");
					WhiteStart.setBackground(Color.white);
				} 		
				*/
	    	}
	    });
	    GiveUp1.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		JButton WhiteStart = (JButton) e.getSource();
				if(WhiteStart.getText().equals("GiveUp")) {
					WhiteStart.setText("End Game");
					WhiteStart.setBackground(Color.yellow);
				}
				/*
				else {
					WhiteStart.setText("Ready");
					WhiteStart.setBackground(Color.white);
				} 
				*/		
	    	}
	    });
	    GiveUp2.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		JButton WhiteStart = (JButton) e.getSource();
				if(WhiteStart.getText().equals("GiveUp")) {
					WhiteStart.setText("End Game");
					WhiteStart.setBackground(Color.yellow);
				}
				/*
				else {
					WhiteStart.setText("Ready");
					WhiteStart.setBackground(Color.white);
				} 
				*/		
	    	}
	    });
	}
    public void gbinsert(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        chessGame.add(c, gbc);
    }
    
    private final void setupNewGame() {
        //message.setText("Make your move!");
        // set up the black pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][0].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][1].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][PAWN]));
        }
        // set up the white pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][6].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][PAWN]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][7].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }
    }
       
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    
}
=======
package chess.gui;
// 초기화면 만들자!
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import chess.client.ClientSender;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class ChessGUI2 extends JFrame {
	//class
	ClientSender cs;
	//
	JPanel chessGame = new JPanel(); // Center
	GridBagLayout gb;
	GridBagConstraints gbc;
	JPanel chessBoard = new JPanel(); // Center - Center
	JPanel player1 = new JPanel(); // West
	JPanel player2 = new JPanel(); // East
	JPanel chatting = new JPanel(); // South
	JPanel chattingInput = new JPanel(); 
	// South - South	
	JButton[][] chessBoardSquares = new JButton[8][8];
	Image[][] chessPieceImages= new Image[2][6];
    public static final int QUEEN = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = { ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK };
    public static final int BLACK = 0, WHITE = 1;
   public JTextArea chatArea = new JTextArea(10,50);
   public JTextField chatField = new JTextField(70);
   public JButton chatButton = new JButton("입력");
    
	public ChessGUI2(){
		
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		chessGame.setLayout(gb);
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
		chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8,8,8,8),new LineBorder(Color.BLACK)));
        Color backgroundColor = new Color(204,119,34);
        chessBoard.setBackground(backgroundColor);
        chatting.setLayout(new BorderLayout());
	    chessBoardSquares = new JButton[8][8];
	    chessPieceImages = new Image[2][6];
	    Insets buttonMargin = new Insets(0, 0, 0, 0);
	    try {
	    	URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url);
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	    for (int ii = 0; ii < 8; ii++) {
	    	for (int jj = 0; jj < 8; jj++) {
	    		JButton b = new JButton();
	            b.setMargin(buttonMargin);
	            ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	            b.setIcon(icon);
	            if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
	            	b.setBackground(Color.WHITE);
	            } else {
	                   	b.setBackground(Color.BLACK);
	                   }
	            chessBoardSquares[ii][jj] = b;
	            chessBoard.add(b);
	        }
	    }
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][0].setIcon(new ImageIcon(chessPieceImages[BLACK][STARTING_ROW[ii]]));
	    }
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][1].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
	    }
	    // set up the white pieces
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][6].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
	    }
	    for (int ii = 0; ii < 8; ii++) {
	        chessBoardSquares[ii][7].setIcon(new ImageIcon(chessPieceImages[WHITE][STARTING_ROW[ii]]));
	    }
	    for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
             chessBoard.add(chessBoardSquares[ii][jj]);
            }
        }
	    player1.setBackground(Color.RED);
	    //player1.setSize(500,600);
	    player2.setBackground(Color.BLUE);
	    //player2.setSize(500,600);
	    //chessBoard.setSize(600,600);
	       gbinsert(player1, 0, 0, 1, 1);
	    gbinsert(chessBoard, 1, 0, 1, 1);
	       gbinsert(player2, 2, 0, 1, 1);
	    chattingInput.add(chatField);
	    chattingInput.add(chatButton);
	    chatting.add(chatArea, BorderLayout.CENTER);
	    chatting.add(chattingInput, BorderLayout.SOUTH);
	   /* btn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {
				String id = tf_id.getText();
				String pass = tf_pw.getText();
				cs.sendMsg("100#"+id+"/"+pass);
			}
		});
	}
	JTextArea chatArea = new JTextArea(10,50);
    JTextField chatField = new JTextField(70);
    JButton chatButton = new JButton("입력");
	*/
	    chatButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("채팅 보내짐");
				String chat = chatField.getText();
				/*chatArea.append(enter);
				chatArea.append(chat);
				chatField.setText("");*/
				cs.sendMsg("500#"+chat);
			}
	    	
	    });
	}
    public void gbinsert(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        chessGame.add(c, gbc);
    }
	
    /*
	public static void main(String[] args) {
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
	*/
  
	public void setSender(ClientSender cs) {
		this.cs = cs;
	}
}
>>>>>>> d2f8d79a8a54f674bcda12e2849fe22b01d4ec05
