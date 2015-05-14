package main.java.com.graphic;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuScore extends JFrame implements ActionListener{
	
		JFrame frame = this;
		
		public int min;
	    public int sec;
	    
	    
	    //creation des min et sec
	    private int min1;
	    private int min2;
	    private int min3;
	    private int sec1;
	    private int sec2;
	    private int sec3;
	    
	    //creation des strings min et sec
	    private String stringMin1;
	    private String stringSec1;
	    private String stringMin2;
	    private String stringSec2;
	    private String stringMin3;
	    private String stringSec3;
	    
	    //creation des zones de texte
	    private JLabel label1;
	    private JLabel label2;
	    private JLabel label3;
	    
	    //creation des variables NOM
	    private String nom1;
	    private String nom2;
	    private String nom3;
	    
		//JButton eternity = new JButton(new ImageIcon("src/logo2.png"));

			public MenuScore()
			{
			
			setLayout(new BorderLayout());
			setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
			setLayout(null);
		
			min1=12;
			sec1=2;
			min2=3;
			sec2=6;
			min3=42;
			sec3=25;
			
			nom1="Michel";
			nom2="Bruno";
			nom3="Bob";
			
			stringMin1 = Integer.toString(min1);
			stringSec1 = Integer.toString(sec1);
			stringMin2 = Integer.toString(min2);
			stringSec2 = Integer.toString(sec2);
			stringMin3 = Integer.toString(min3);
			stringSec3 = Integer.toString(sec3);
			
		    if (min1 < 10)
		    {
		  	this.stringMin1 = "0" + Integer.toString(min1);
		    }
		        
		    if (sec1 < 10)
		    {
		  	this.stringSec1 = "0" + Integer.toString(sec1);
		    }
		    
		    if (min2 < 10)
		    {
		  	this.stringMin2 = "0" + Integer.toString(min2);
		    }
		        
		    if (sec2 < 10)
		    {
		  	this.stringSec2 = "0" + Integer.toString(sec2);
		    }
		    
		    if (min3 < 10)
		    {
		  	this.stringMin3 = "0" + Integer.toString(min3);
		    }
		    
		    if (sec3 < 10)
		    {
		  	this.stringSec3 = "0" + Integer.toString(sec3);
		    }
			 
		    
			label1 = new JLabel("<html>1	Pseudo:		"+nom1+" 	"+stringMin1+":"+stringSec1+"</html>");
			label2 = new JLabel("<html>2 	Pseudo:		"+nom2+"	 "+stringMin2+":"+stringSec2+"</html>");
			label3 = new JLabel("<html>3	Pseudo:		"+nom3+" 	"+stringMin3+":"+stringSec3+"</html>");
		
			label1.setBounds(75, 70, 200, 50);
			label2.setBounds(75, 140, 200, 50);
			label3.setBounds(75,210,200, 50);
				  
	    	this.add(label1);
	    	this.add(label2);
	    	this.add(label3);
	      		
			setTitle("Menu Score");
			setSize(350,350);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
				
			
			}
			
			
	public void actionPerformed(ActionEvent e) {
				
	}

			public static void main(String args[])
			{
				MenuScore FenetreScore = new MenuScore();
				FenetreScore.setVisible(true);
				
			
			}

	}