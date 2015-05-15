package main.java.com.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame
{
	private JFrame frame;
	public JButton play;
	public JButton load;
	public JButton help;
	public JButton score;
	public JButton quit;
	private JLabel titre;
	private Color violet;
	
	public Menu()
	{
		frame = this;
		setTitle("Menu Eternity");
		setSize(500,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
		setLayout(null);

		violet = new Color(125,36,124);

		play = new JButton("Nouvelle Partie");
		load = new JButton("Charger Partie");
		help = new JButton("Aide");
		score = new JButton("Scores");
		quit = new JButton("Quitter");
		titre = new JLabel(new ImageIcon("images/logo.png"));

		play.setBounds(150, 2*getHeight()/7, 200, 50);
		load.setBounds(150, 3*getHeight()/7, 200, 50);
		help.setBounds(150, 4*getHeight()/7, 200, 50);
		score.setBounds(150,5*getHeight()/7, 200, 50);
		quit.setBounds(150, 6*getHeight()/7, 200, 50);
		titre.setBounds(0,0, 500, 162);

		play.setBackground(violet);
		play.setForeground(Color.white);
		play.setOpaque(true);
		load.setBackground(violet);
		load.setForeground(Color.white);
		load.setOpaque(true);
		help.setBackground(violet);
		help.setForeground(Color.white);
		help.setOpaque(true);
		score.setBackground(violet);
		score.setForeground(Color.white);
		score.setOpaque(true);
		quit.setBackground(violet);
		quit.setForeground(Color.white);
		quit.setOpaque(true);

		this.add(play);
		this.add(load);
		this.add(help);
		this.add(score);
		this.add(quit);
		this.add(titre);

		setVisible(true);
	}
}