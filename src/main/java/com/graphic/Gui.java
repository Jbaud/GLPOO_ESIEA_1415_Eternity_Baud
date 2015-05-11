package com.graphic;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D; //pour les events repaint
import javax.swing.*;
import java.util.*;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.FileDialog;
import java.awt.Cursor; //pour le choix du curseur

public class Gui extends JFrame
{
	//Creation du JFrame avec le focus
	private JFrame frame = this;

	//Creation table
	private JTable table = null;
	private ModeleTable modele = null;

	//Curseur
	Cursor curseurFleche = new Cursor(Cursor.DEFAULT_CURSOR);

	//Creation barre de menu
	JMenuBar barreMenu = new JMenuBar();

	//Creation catégories de barreMenu
	JMenu fichier = new JMenu("Fichier");
	JMenu aide = new JMenu("Aide");

	//Creation des items dans Fichier
	JMenuItem nouveau_ = new JMenuItem("Nouvelle partie");

	//Creation des items dans Aide
	JMenuItem instructions_ = new JMenuItem("Instructions");
	JMenuItem about_ = new JMenuItem("A propos");

	//test
	ImageIcon imageTruc = new ImageIcon("truc.png");
	ImageIcon imageBidule = new ImageIcon("bidule.png");
	ImageIcon imageMachin = new ImageIcon("machin.png");
	ImageIcon imageBase = new ImageIcon("base-piece.png");
	ImageIcon coucheCoeur = new ImageIcon("couleur-coeur.png");
	SuperpoIcon imageChouette = new SuperpoIcon(imageBase);
	RotateIcon imageTournee;
	RotateIcon imageComposeeTournee;

	public Gui()
	{
		//appel au constructeur de la classe mère
		super();
		System.out.println("Graphic User Interface is being set");

		//Set the window properties
		this.setTitle("test pour JTable");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//Curseur fleche
		setCursor(curseurFleche);


		//////////////////////////////////////////////////////
		//													//
		//					BARRE DE MENU					//
		//													//
		//////////////////////////////////////////////////////

		//Construct the hierarchy of the MenuBar
		fichier.add(nouveau_);

		aide.add(instructions_);
		aide.add(about_);

		//Add the MenuBar to the window
		barreMenu.add(fichier);
		barreMenu.add(aide);

		//Activate the MenuBar
		setJMenuBar(barreMenu);

		//////////////////////////////////////////////////////
		//													//
		//						JTABLE						//
		//													//
		//////////////////////////////////////////////////////
		

		imageChouette.ajoutCouche(coucheCoeur);
		imageTournee = new RotateIcon(imageTruc,RotateIcon.Orientation.EST);
		imageComposeeTournee = new RotateIcon(imageChouette,RotateIcon.Orientation.OUEST);

		//Tableau de données
		Object[][] donnees =
		{
			{imageChouette,Color.red,imageTruc},
			{imageTournee,Color.blue,imageBidule},
			{"pieceC",Color.yellow,imageMachin}
		};

		//Tableau de titres
		String titre[] = {"Pieces", "Couleur", "Image"};

		modele = new ModeleTable(donnees,titre);
		this.table = new JTable(modele);
		System.out.println("Nb colonnes : "+modele.getColumnCount());
		System.out.println("Nb lignes : "+modele.getRowCount());
		table.setDefaultRenderer(Color.class, new ColorCellRenderer());

		this.table.setRowHeight(150);
		this.getContentPane().add(table);


		//////////////////////////////////////////////////////
		//													//
		//					MENU LISTENERS					//
		//													//
		//////////////////////////////////////////////////////

		//Fichier>Nouvelle Partie
		nouveau_.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//partie.nouvellePartie();
			}
		});		


		//Aide>Instructions
		instructions_.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog (null,
					"Ici il faut mettre des instructions\n"
					+"Bla Bla Bla",
					"Instructions",
					JOptionPane.INFORMATION_MESSAGE);
			}
		});

		//Aide>A propos
		about_.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog (null,
					"Ce logiciel de jeu a été développé par des étudiants de l'ESIEA en 2015"
					+"\nBala, Baud, Delisle, Fourcade, Martineau, Payne"
					+"\nsous l'égide de Thierry Leriche-Dessirier",
					"A propos",
					JOptionPane.INFORMATION_MESSAGE);
			}
		});

    }


}