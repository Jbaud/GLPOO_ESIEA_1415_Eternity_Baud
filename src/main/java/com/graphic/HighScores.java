package main.java.com.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScores extends JFrame implements ActionListener
{
	JFrame frame = this;

	public int minute;
	public int seconde;
	public String nom;

	//creation des min et sec
	private int min1;
	private int min2;
	private int min3;
	private int sec1;
	private int sec2;
	private int sec3;

	//creation des zones de texte
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	//creation des variables NOM
	private String nom1;
	private String nom2;
	private String nom3;

	public HighScores()
	{
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
		setLayout(null);
		setTitle("Menu Score");
		setSize(350,350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//à partir du CSV
		min1=12;
		sec1=2;
		min2=3;
		sec2=6;
		min3=42;
		sec3=25;

		nom1="Michel";
		nom2="Bruno";
		nom3="Bob";

		label1 = new JLabel("<html>1	Pseudo:		"+nom1+" 	"+formatage(min1)+":"+formatage(sec1)+"</html>");
		label2 = new JLabel("<html>2 	Pseudo:		"+nom2+"	 "+formatage(min2)+":"+formatage(sec2)+"</html>");
		label3 = new JLabel("<html>3	Pseudo:		"+nom3+" 	"+formatage(min3)+":"+formatage(sec3)+"</html>");

		label1.setBounds(75, 70, 200, 50);
		label2.setBounds(75, 140, 200, 50);
		label3.setBounds(75,210,200, 50);

		label1.setBackground(Color.lightGray);
		label2.setBackground(Color.lightGray);
		label3.setBackground(Color.lightGray);

		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);
			  
		this.add(label1);
		this.add(label2);
		this.add(label3);
	}
	
	private String formatage(int nombre)
	{
		if (nombre < 10)
			return ("0" + Integer.toString(nombre));
		else
			return (Integer.toString(nombre));
	}
			
	public void actionPerformed(ActionEvent e)
	{
				
	}
}