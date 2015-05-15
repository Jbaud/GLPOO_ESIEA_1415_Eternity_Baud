package main.java.com.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScores extends JFrame
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

	//creation des variables NOM
	private String nom1;
	private String nom2;
	private String nom3;

	//creation des zones de texte
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	//Variables pour csv
	private ScoreCsvDao scoreDao;
	private List<Score> scores;

    private JLabel titre;
	private Color violet;

	public HighScores()
	{
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
		setLayout(null);
		setTitle("Menu Score");
		setSize(350,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//Recup a partir du csv
		scoreDao = new ScoreCsvDao();
		scores = scoreDao.read();
		nom1 = scores.get(0).getNom();
		nom2 = scores.get(1).getNom();
		nom3 = scores.get(2).getNom();
		min1 = scores.get(0).getTemps().getMinutes();
		min2 = scores.get(1).getTemps().getMinutes();
		min3 = scores.get(2).getTemps().getMinutes();
		sec1 = scores.get(0).getTemps().getSecondes();
		sec2 = scores.get(1).getTemps().getSecondes();
		sec3 = scores.get(2).getTemps().getSecondes();

		label1 = new JLabel("    1    "+nom1+"    "+formatage(min1)+":"+formatage(sec1));
		label2 = new JLabel("    2    "+nom2+"    "+formatage(min2)+":"+formatage(sec2));
		label3 = new JLabel("    3    "+nom3+"    "+formatage(min3)+":"+formatage(sec3));
		titre = new JLabel(new ImageIcon("images/scores.png"));

		label1.setBounds(75, 100, 200, 50);
		label2.setBounds(75, 170, 200, 50);
		label3.setBounds(75, 240, 200, 50);
		titre.setBounds(0,0,350,65);

		violet = new Color(125,36,124);

		label1.setBackground(violet);
		label1.setForeground(Color.white);
		label1.setOpaque(true);
		label2.setBackground(violet);
		label2.setForeground(Color.white);
		label2.setOpaque(true);
		label3.setBackground(violet);
		label3.setForeground(Color.white);
		label3.setOpaque(true);
			  
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(titre);

		setVisible(true);
	}
	
	private String formatage(int nombre)
	{
		if (nombre < 10)
			return ("0" + Integer.toString(nombre));
		else
			return (Integer.toString(nombre));
	}
}