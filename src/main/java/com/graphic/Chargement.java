package main.java.com.graphic;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Chargement extends JFrame
{
	JFrame frame = this;
	
	public int minute;
    public int seconde;
    
    //creation des min et sec
    private int min1;
    private int min2;
    private int min3;
    private int sec1;
    private int sec2;
    private int sec3;
    private TempsCsvDao tempsDao;
    private Temps temps1;
    private Temps temps2;
    private Temps temps3;
    
    //creation des boutons
    public JButton partie1;
    public JButton partie2;
    public JButton partie3;
    private JLabel titre;
    private Color violet;

	public Chargement()
	{
		setContentPane(new JLabel(new ImageIcon("images/fondMenu.png")));
		setLayout(null);
		setTitle("Charger une partie");
		setSize(350,350);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
	
		//recup avec des csv
		tempsDao = new TempsCsvDao();
		temps1 = tempsDao.readTemps().get(1);
		temps2 = tempsDao.readTemps().get(2);
		temps3 = tempsDao.readTemps().get(3);
		min1=temps1.getMinutes();
		sec1=temps1.getSecondes();
		min2=temps2.getMinutes();
		sec2=temps2.getSecondes();
		min3=temps3.getMinutes();
		sec3=temps3.getSecondes();

		partie1 = new JButton("<html>  Sauvegarde  1<br>Temps="+formatage(min1)+":"+formatage(sec1)+"</html>");
		partie2 = new JButton("<html>  Sauvegarde  2<br>Temps="+formatage(min2)+":"+formatage(sec2)+"</html>");
		partie3 = new JButton("<html>  Sauvegarde  3<br>Temps="+formatage(min3)+":"+formatage(min3)+"</html>");
		titre = new JLabel(new ImageIcon("images/charger.png"));

		partie1.setBounds(75, 100, 200, 50);
		partie2.setBounds(75, 170, 200, 50);
		partie3.setBounds(75,240,200, 50);
		titre.setBounds(0,0,350,65);

		violet = new Color(125,36,124);

		partie1.setBackground(violet);
		partie1.setForeground(Color.white);
		partie1.setOpaque(true);
		partie2.setBackground(violet);
		partie2.setForeground(Color.white);
		partie2.setOpaque(true);
		partie3.setBackground(violet);
		partie3.setForeground(Color.white);
		partie3.setOpaque(true);

		this.add(partie1);
		this.add(partie2);
		this.add(partie3);
		this.add(titre);

		this.setVisible(true);
	}
		
	private String formatage(int nombre)
	{
		if (nombre < 10)
			return ("0" + Integer.toString(nombre));
		else
			return (Integer.toString(nombre));
	}
}