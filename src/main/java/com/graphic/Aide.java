package main.java.com.graphic;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Aide extends JFrame
{	
	private JFrame frame;
	private JLabel selection;
	private JLabel rotation;
	private JLabel echange;
	private JLabel match;
	private JLabel bords;
	
	public Aide()
	{	
		frame = this;
		this.setTitle("Aide");
		setSize(543,660);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
		setLayout(null);

		selection = new JLabel(new ImageIcon("images/selection.png")); 
		rotation = new JLabel(new ImageIcon("images/rotation.png")); 
		echange = new JLabel(new ImageIcon("images/echange.png")); 
		match = new JLabel(new ImageIcon("images/match.png")); 
		bords = new JLabel(new ImageIcon("images/bords.png")); 
		
		selection.setBounds(50, 10, 443, 110);
		rotation.setBounds(50, 140,443, 110);
		echange.setBounds(50, 270, 443, 110);
		match.setBounds(50, 400, 443, 110);
		bords.setBounds(50, 530, 443, 110);

		this.add(bords);
		this.add(echange);
		this.add(match);
		this.add(rotation);
		this.add(selection);

		setVisible(true);
	}	
}