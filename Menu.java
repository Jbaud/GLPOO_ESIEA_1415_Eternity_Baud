package main.java.com.graphic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Menu extends JFrame implements ActionListener{
	JFrame frame = this;
	

	JButton play = new JButton("Nouvelle Partie");
	JButton load = new JButton("Charger Partie");
	JButton help = new JButton("Aide");
	JButton score = new JButton("Scores");
	JButton quit = new JButton("Quitter");
	
	
	//JButton eternity = new JButton(new ImageIcon("src/logo2.png"));

	JButton b1;
	JLabel l1;
	
		public Menu()
		{
		
	
		setTitle("Menu Eternity");
		setSize(500,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//setVisible(true);

		
	    play.addActionListener(this);
	    quit.addActionListener(this);
	   
		
	// Another way
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
		setLayout(null);
	
		
		
		play.setBounds(150, 2*getHeight()/7, 200, 50);
		load.setBounds(150, 3*getHeight()/7, 200, 50);
		help.setBounds(150, 4*getHeight()/7, 200, 50);
		score.setBounds(150,5*getHeight()/7, 200, 50);
		quit.setBounds(150, 6*getHeight()/7, 200, 50);
		
		
		
    	this.add(play);
    	this.add(load);
    	this.add(help);
    	this.add(score);
    	this.add(quit);
    	
		// Just for refresh :) Not optional!
		setSize(499,699);
		setSize(500,700);
		
		
		}
		
		
public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();
			
				
			 
			 if(source == play){
				
				 System.out.println("Clic");
				frame.dispose();
			 }
			
			 if(source == quit)
			 {
				 
				 dispose();
			 }
			 
			
			 
		}

		/*public static void main(String args[])
		{
			Menu interfaceGraphique = new Menu();
			interfaceGraphique.setVisible(true);
			
		
		}*/

}

