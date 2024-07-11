package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import UI.*;


public class StartPanel extends JPanel implements ActionListener {
	
	public static int w_width=800;
	public static int w_height=600;
	protected int x=0;
	protected int y=0;
	Font font=new Font("SansSerif",Font.BOLD,60);
	Font font2=new Font("Monospaced",Font.ITALIC,20);
    Font font3=new Font("Serif",Font.BOLD,40);


	
	
	public static JFrame f=new JFrame();
    JPanel startPage=new JPanel();
	EmptyPanel gamePane=new EmptyPanel();
	JLabel gamelb= new JLabel("CONNECT FOUR");
	JPanel playPane=new JPanel();
	JButton playbt= new JButton("PLAY");
	

	
	
	StartPanel(){
		
		
		f.setTitle("Connect four");
		f.setSize(w_width,w_height);
		startPage.setBackground(colors.yellow_c);
		f.add(startPage);
		startPage.setLayout(null);
		
		
		gamelb.setFont(new Font("Monospaced",Font.BOLD,70));
		
		gamelb.setBounds(130,70,600,200);
		
		gamelb.setForeground(colors.brown_c);
		startPage.add(gamelb);

		;
		playbt.setFont(font3);
		playbt.setForeground(colors.yellow_c);
		playbt.setBackground(colors.brown_c);
		playbt.setFocusPainted(false);
		playbt.setBounds(230,300,320,120);
		startPage.add(playbt);
		
		playbt.addActionListener(this);
	
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==playbt) {
			new SecondPanel().setVisible(true);
			f.setVisible(false);
			f.dispose();
		}
	}
	
	
	
	
	

}
