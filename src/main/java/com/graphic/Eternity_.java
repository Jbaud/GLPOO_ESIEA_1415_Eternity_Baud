package main.java.com.graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Eternity_ extends JFrame implements ActionListener
{
	private Gui puzzle;
	private Menu menu;
	private Chargement chargement;
	private Aide aide;
	private HighScores scores;
	private int choixDePartie;

	public Eternity_()
	{
		//Lancement de l'interface graphique
		menu = new Menu();
		menu.play.addActionListener(this);
		menu.load.addActionListener(this);
		menu.help.addActionListener(this);
		menu.score.addActionListener(this);
		menu.quit.addActionListener(this);

		choixDePartie = 0;
	}

	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();

		//Recommencer
		if (puzzle != null)
		{
			if (source == puzzle.recommencerLabel)
			{
				puzzle.dispose();
				puzzle = null;
				if (puzzle == null)
				{
					puzzle = new Gui(choixDePartie);
					puzzle.recommencerLabel.addActionListener(this);
					puzzle.menuLabel.addActionListener(this);
				}
			}
			else if (source == puzzle.menuLabel)
			{
				if (menu != null)
					menu.setVisible(true);
				if (menu == null)
				{
					menu= new Menu();
					menu.play.addActionListener(this);
					menu.load.addActionListener(this);
					menu.help.addActionListener(this);
					menu.score.addActionListener(this);
					menu.quit.addActionListener(this);
				}
			}
		}
		if (menu != null)
		{
			//Nouvelle Partie
			if (source == menu.play)
			{
				if (puzzle != null)
				{
					puzzle.dispose();
					puzzle = null;
				}
				if (puzzle == null)
				{
					choixDePartie = 0;
					puzzle = new Gui(choixDePartie);
					puzzle.recommencerLabel.addActionListener(this);
					puzzle.menuLabel.addActionListener(this);
				}
				if (menu != null)
				{
					menu.dispose();
					menu = null;
				}
			}
			//Chargement de partie
			else if (source == menu.load)
			{
				if (chargement != null)
				{
					chargement = null;
				}
				if (chargement == null)
				{
					chargement = new Chargement();
					chargement.partie1.addActionListener(this);
					chargement.partie2.addActionListener(this);
					chargement.partie3.addActionListener(this);
				}
			}
			else if (source == menu.help)
			{
				if (aide == null)
				{
					aide = new Aide();
				}
			}
			else if (source == menu.score)
			{
				if (scores != null)
				{
					scores = null;
				}
				if (scores == null)
				{
					scores = new HighScores();
				}
			}
		}

		if (chargement != null)
		{
			//choix de partie
			if (source == chargement.partie1)
			{
				choixDePartie = 1;
				if (puzzle != null)
					puzzle = null;
				if (puzzle == null)
				{
					puzzle = new Gui(choixDePartie);
					puzzle.recommencerLabel.addActionListener(this);
					puzzle.menuLabel.addActionListener(this);
				}
				if (menu != null)
				{
					menu.dispose();
					menu = null;
				}
				chargement.dispose();
				chargement = null;
			}
			else if (source == chargement.partie2)
			{
				choixDePartie = 2;
				if (puzzle != null)
					puzzle = null;
				if (puzzle == null)
				{
					puzzle = new Gui(choixDePartie);
					puzzle.recommencerLabel.addActionListener(this);
					puzzle.menuLabel.addActionListener(this);
				}
				if (menu != null)
				{
					menu.dispose();
					menu = null;
				}
				chargement.dispose();
				chargement = null;
			}
			else if (source == chargement.partie3)
			{
				System.out.println("Le 3 est détecté");
				choixDePartie = 3;
				if (puzzle != null)
					puzzle = null;
				if (puzzle == null)
				{
					puzzle = new Gui(choixDePartie);
					puzzle.recommencerLabel.addActionListener(this);
					puzzle.menuLabel.addActionListener(this);
				}
				if (menu != null)
				{
					menu.dispose();
					menu = null;
				}
				chargement.dispose();
				chargement = null;
			}
		}
	}
}