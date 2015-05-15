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
		this.setTitle("Eternity-Aide");
		setSize(654,750);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("src/fondMenu.png")));
		setLayout(null);

		selection = new JLabel(new ImageIcon("src/selection.png")); 
		rotation = new JLabel(new ImageIcon("src/rotationDroite.png")); 
		echange = new JLabel(new ImageIcon("src/echange.png")); 
		match = new JLabel(new ImageIcon("src/match.png")); 
		bords = new JLabel(new ImageIcon("src/bords.png")); 
		
		selection.setBounds(50, 10, 554, 125);
		rotation.setBounds(50, 155, 554, 125);
		echange.setBounds(50, 300, 554, 125);
		match.setBounds(50, 445, 554, 125);
		bords.setBounds(50, 590, 554, 125);

		this.add(bords);
		this.add(echange);
		this.add(match);
		this.add(rotation);
		this.add(selection);

		setVisible(true);
	}	
}