package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Game.GamePanel;
import UI.*;

public class SecondPanel extends StartPanel implements ActionListener {
	
	public static JFrame secondframe=new JFrame();
	


	JPanel secondPane=new JPanel();
	JLabel namelb=new JLabel("Enter Player's Name");
	
	EmptyPanel playerPane=new EmptyPanel();
	JLabel playerlb1=new JLabel("PLAYER 1");
	public static JTextField play1tx=new JTextField("",20); //public
	JLabel playerlb2=new JLabel("PLAYER 2");
	public static JTextField play2tx=new JTextField("",20);
	
	
	JLabel howtolb=new JLabel("How to: Connect 4 chips and win!!");
	JButton startbt=new JButton("START");
	
	
	SecondPanel(){
		
		secondframe.setTitle("Connect four");
		secondframe.setSize(w_width,w_height);
		secondPane.setBackground(colors.yellow_c);
		secondframe.add(secondPane);
		secondPane.setLayout(null);
		secondPane.add(namelb);
		secondPane.add(playerPane);
		secondPane.add(howtolb);
		secondPane.add(startbt);

		
		
		namelb.setFont(font);
		namelb.setForeground(colors.brown_c);
		namelb.setBounds(90,60,700,100);
		
		playerlb1.setFont(font2);
		playerlb1.setForeground(colors.brown_c);
		playerlb2.setFont(font2);
		playerlb2.setForeground(colors.brown_c);
		playerPane.setLayout(new GridLayout(2,2));
		playerPane.add(playerlb1);
		playerPane.add(play1tx);
		playerPane.add(playerlb2);
		playerPane.add(play2tx);
		playerPane.setBounds(60,200,600,100);
		
	
		howtolb.setFont(font2);
		howtolb.setBounds(220, 260, 400, 200);
		startbt.setFont(font3);
		startbt.setForeground(colors.yellow_c);
		startbt.setBackground(colors.brown_c);
		startbt.setBounds(300, 430, 200, 80);
		startbt.addActionListener(this);
		

		secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondframe.setLocationRelativeTo(null);
		secondframe.setResizable(false);
		secondframe.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if (e.getSource()==startbt) {
				new GamePanel();
				secondframe.dispose();
			}
			
	}
}
