package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import Main.*;
import UI.*;

public class GameEnd extends JPanel implements ItemListener{

	JFrame result = new JFrame("Connect four");
	JPanel resultPane = new JPanel();
	JLabel Awin = new JLabel("      The winner is " + SecondPanel.play1tx.getText());
	JLabel Bwin = new JLabel("      The winner is " + SecondPanel.play2tx.getText());
	EmptyPanel bt_pn = new EmptyPanel();
	JRadioButton exit = new JRadioButton("Exit");

	public GameEnd() {
		Awin.setFont(new Font("Monospaced",Font.BOLD,45));
		Awin.setForeground(colors.brown_c);
		Awin.setBounds(130,70,600,200);
		
		Bwin.setFont(new Font("Monospaced",Font.BOLD,45));
		Bwin.setForeground(colors.brown_c);
		Bwin.setBounds(130,70,600,200);

		exit.setFocusPainted(false);
		exit.setOpaque(false);
		exit.setForeground(colors.brown_c);
		exit.setFont(new Font("Monospaced",Font.ITALIC,30));
		
		bt_pn.setLayout(new GridLayout(1,5));
		bt_pn.add(new EmptyPanel());
		bt_pn.add(new EmptyPanel());
		bt_pn.add(exit);
		bt_pn.add(new EmptyPanel());
		bt_pn.add(new EmptyPanel());
		
		resultPane.setBackground(colors.yellow_c);
		resultPane.setLayout(new GridLayout(7, 1));

	
		if (Board.Awin == true && Board.Bwin == false) {
			resultPane.add(new EmptyPanel());
			resultPane.add(new EmptyPanel());
			resultPane.add(Awin);
			
			
		}
		
		if (Board.Bwin == true && Board.Awin == false) {
			resultPane.add(new EmptyPanel());
			resultPane.add(new EmptyPanel());
			resultPane.add(Bwin);
			
		}
	
		
		resultPane.add(bt_pn);
		
		
		exit.addItemListener(this);

		result.add(resultPane);
		result.setSize(800, 600);
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result.setLocationRelativeTo(null);
		result.setResizable(false);
		result.setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == exit && e.getStateChange() == 1){
			StartPanel.f.dispose();
			SecondPanel.secondframe.dispose();
			GamePanel.Gameframe.dispose();
			result.dispose();
			
		}
		
	}
}





