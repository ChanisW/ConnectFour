package Game;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import UI.Fonts;
import UI.colors;

public class GamePanel  {
	
	static JFrame Gameframe=new JFrame();
	private Board b=new Board();                //private
	private JLabel timeLabel=new JLabel("");
	private Timer timer = null;
	int sec;
	int min;

	
	
	public GamePanel() {
	
	b.setBackground(colors.yellow_c);
	Gameframe.setLayout(new BorderLayout());
	Gameframe.add(b,BorderLayout.CENTER);
	b.add(timeLabel,BorderLayout.NORTH);
	timeLabel.setFont(Fonts.font2);
	//timeLabel.setBounds(20, 20, 30, 50);
	Gameframe.setSize(800, 600);
	Gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Gameframe.setLocationRelativeTo(null);
	Gameframe.setResizable(false);
	Gameframe.setVisible(true);
	
	sec=0;
	min=0;
	gameTimer();
	timer.start();
	
			
			
	}


public void gameTimer() {
	timer=new Timer(1000, new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
         sec++;
         
         timeLabel.setText(min + ":" + sec);
         if (sec==60) {
        	 sec=0;
        	 min++;
        	 timeLabel.setText(min + ":" + sec);
        	 
         }

		}
	});
}
}


