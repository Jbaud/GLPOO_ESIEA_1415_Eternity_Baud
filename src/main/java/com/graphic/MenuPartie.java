package main.java.com.graphic;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuPartie extends JFrame implements ActionListener{
	JFrame frame = this;
	
	public int min;
    public int sec;
    public int choix;
    
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
    
    //creation des boutons
    private JButton retour;
    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;

	//JButton eternity = new JButton(new ImageIcon("src/logo2.png"));

		public MenuPartie()
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
		 
	    retour = new JButton("Retour au menu");
		bouton1 = new JButton("<html>  Enregistrement  1<br>Temps="+stringMin1+":"+ stringSec1+"</html>");
		bouton2 = new JButton("<html>  Enregistrement  2<br>Temps="+stringMin2+":"+stringSec2+"</html>");
		bouton3 = new JButton("<html>  Enregistrement  3<br>Temps="+stringMin3+":"+stringSec3+"</html>");

		
		
		retour.setBounds(75,30, 200, 50);
	    bouton1.setBounds(75, 100, 200, 50);
		bouton2.setBounds(75, 170, 200, 50);
		bouton3.setBounds(75,240,200, 50);
		
    	this.add(retour);
    	this.add(bouton1);
    	this.add(bouton2);
    	this.add(bouton3);
    	
    	retour.addActionListener(this);
		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		bouton3.addActionListener(this);
		
		setTitle("Menu Chargement");
		setSize(350,350);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		
		}
		
		
public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == retour)
		{
			Menu FenetreMenu = new Menu();
			FenetreMenu.setVisible(true);
		}
		
		if (source == bouton1)
		{
			choix=1;
			this.min=min1;
			this.sec=sec1;
			System.out.println("Choix1");
		}
	
		else if (source == bouton2)
		{
			choix=2;
			this.min=min2;
			this.sec=sec2;
			System.out.println("Choix2");
		}
		else if (source == bouton3)
		{
			choix=3;
			this.min=min3;
			this.sec=sec3;
			System.out.println("Choix3");
		}
	
}

		public static void main(String args[])
		{
			MenuPartie FenetreLoad = new MenuPartie();
			FenetreLoad.setVisible(true);
			
		
		}

}
