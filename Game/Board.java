package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.SecondPanel;
import UI.*;

public class Board extends JPanel implements MouseListener {	
		int boardx=190;
		int boardy=80;
		int cellwidth=60;
		int turn=2;
		int rows=6;
		int cols=7;
		Color[][] slot=new Color[rows][cols];
		JPanel board=new JPanel();	
		
		public static boolean Awin;
		public static boolean Bwin;

		public Board() {
		board.setBackground(colors.yellow_c);
		addMouseListener(this);
		
			//initialize array 
	//	int x=0;
		for (int row = 0; row < 6; row++) {//double for loop
            for (int col = 0; col < 7; col++) {
               slot[row][col] = new Color(255,255,255);//set color to white
            }
          }
		}
		
		protected void paintComponent(Graphics g) {   //protected
			super.paintComponent(g);
			

			g.setColor(colors.blue_c);
		    g.fillRoundRect(190, 80, cellwidth*7, cellwidth*6, 10, 10);
		   
		    boardx=190;
			boardy=80;
			for (int row=0;row<6;row++) {
				for(int col=0;col<7;col++){
					g.setColor(slot[row][col]);
					g.fillOval(boardx, boardy, cellwidth, cellwidth);
					boardx+=cellwidth;
					
				}
				
			boardx=190;
			boardy+=cellwidth;
			}
			g.setColor(colors.brown_c);
			g.fillRect(0,470,800,200);
			g.setColor(Color.WHITE);
			
			if (turn%2==0) {		
				g.setColor(colors.yellow_c);
				g.setFont(new Font("Serif",Font.BOLD,40));
				g.drawString(SecondPanel.play1tx.getText()+ "'s turn", 325, 530);

			}
			else {
				g.setColor(colors.yellow_c);
				g.setFont(new Font("Serif",Font.BOLD,40));
				g.drawString(SecondPanel.play2tx.getText() + "'s turn", 325, 530);
			}

		
		
		}
		

		@Override
		public void mouseClicked(MouseEvent e) {
				
		}

		@Override
		public void mousePressed(MouseEvent e) {

			int	x=e.getX()-190;
			double a=x;//implicit casting
			double y=e.getY()-80;
			int b= (int)y;  //explicit casting
		
			int posx=(int)a/cellwidth;
			int posy=Math.round(b/cellwidth);    //Math class
			posy = checkFreeSlot(posx);
			
			System.out.println(x+" "+posx+" "+b+" "+posy);
			
			if(turn%2==0) {
				slot[posy][posx]=colors.pink_c;
				
			}
			else {
				slot[posy][posx]=colors.green_c;
			}
			
					
					boolean Awinner=false;
					boolean Bwinner=false;
					
					Awinner =isAWinner(slot);
					Bwinner =isBWinner(slot);
					
			if (Awinner) {
				Awin = true;
				Bwin = false;
				new GameEnd();
				System.out.println("A won");
			}
			else if (Bwinner) {
				Bwin = true;
				Awin = false;
				new GameEnd();
				System.out.println("B won");
			}
			
		   else {

			
			display(slot);

			turn++;
			repaint(); 	
		   }
		
		}
		
		public static void display(Color[][] grid){
			System.out.println(" 0 1 2 3 4 5 6");
			System.out.println("---------------");
			for (int row = 0; row < grid.length; row++){
				System.out.print("|");
				for (int col = 0; col < grid[0].length; col++){
					if (grid[row][col].equals(new Color(239,160,193))) {
						System.out.print("A");
					} else if (grid[row][col].equals(new Color(229,243,207))) {
						System.out.print("B");
					} else {
						System.out.print(" ");
					}
					System.out.print("|");
				}
				System.out.println();
				System.out.println("---------------");
			}
			System.out.println(" 0 1 2 3 4 5 6");
			System.out.println();
		}
		

		
		public static boolean isAWinner(Color[][] grid){//horizontal
			for(int row = 0; row<grid.length; row++){
				for (int col = 0;col < grid[0].length - 3;col++){
					if (grid[row][col].equals(new Color(239,160,193)) && 
						grid[row][col+1].equals(new Color(239,160,193))  &&
						grid[row][col+2].equals(new Color(239,160,193))  &&
						grid[row][col+3].equals(new Color(239,160,193))){
						return true;
					}
				}			
			}
			for(int row = 0; row < grid.length - 3; row++){// vertical
				for(int col = 0; col < grid[0].length; col++){
					if (grid[row][col].equals(new Color(239,160,193))  && 
						grid[row+1][col].equals(new Color(239,160,193)) &&
						grid[row+2][col].equals(new Color(239,160,193)) &&
						grid[row+3][col].equals(new Color(239,160,193))){
						return true;
					}
				}
			}
			for(int row = 0; row < grid.length; row++){// slash diagonal
				for(int col = 0; col < grid[0].length - 3; col++){
					if (grid[row][col].equals(new Color(239,160,193)) && 
						grid[row-1][col+1].equals(new Color(239,160,193)) &&
						grid[row-2][col+2].equals(new Color(239,160,193)) &&
						grid[row-3][col+3].equals(new Color(239,160,193))){
						return true;
					}
				}
			}
			for(int row = 0; row < grid.length - 3; row++){// backslash diagonal
				for(int col = 0; col < grid[0].length - 3; col++){
					if (grid[row][col].equals(new Color(239,160,193))   && 
						grid[row+1][col+1].equals(new Color(239,160,193)) &&
						grid[row+2][col+2].equals(new Color(239,160,193)) &&
						grid[row+3][col+3].equals(new Color(239,160,193))){
						return true;
					}
				}
			}
			return false;
		}
		
		
		public static boolean isBWinner(Color[][] grid){
			for(int row = 0; row<grid.length; row++){
				for (int col = 0;col < grid[0].length - 3;col++){
					if (grid[row][col].equals(new Color(229,243,207)) && 
						grid[row][col+1].equals(new Color(229,243,207))  &&
						grid[row][col+2].equals(new Color(229,243,207))  &&
						grid[row][col+3].equals(new Color(229,243,207)) ){
						return true;
					}
				}			
			}
			for(int row = 0; row < grid.length - 3; row++){
				for(int col = 0; col < grid[0].length; col++){
					if (grid[row][col].equals(new Color(229,243,207))  && 
						grid[row+1][col].equals(new Color(229,243,207)) &&
						grid[row+2][col].equals(new Color(229,243,207)) &&
						grid[row+3][col].equals(new Color(229,243,207))){
						return true;
					}
				}
			}
			for(int row = 0; row < grid.length; row++){
				for(int col = 0; col < grid[0].length - 3; col++){
					if (grid[row][col].equals(new Color(229,243,207)) && 
						grid[row-1][col+1].equals(new Color(229,243,207)) &&
						grid[row-2][col+2].equals(new Color(229,243,207)) &&
						grid[row-3][col+3].equals(new Color(229,243,207))){
						return true;
					}
				}
			}
			for(int row = 0; row < grid.length - 3; row++){
				for(int col = 0; col < grid[0].length - 3; col++){
					if (grid[row][col].equals(new Color(229,243,207))   && 
						grid[row+1][col+1].equals(new Color(229,243,207)) &&
						grid[row+2][col+2].equals(new Color(229,243,207)) &&
						grid[row+3][col+3].equals(new Color(229,243,207))){
						return true;
					}
				}
			}
			return false;
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		public int checkFreeSlot(int posx) {
			int posy=rows-1;
			while(!(slot[posy][posx].equals(Color.WHITE))) {
				posy--;
			}
		
			return posy;
}
}