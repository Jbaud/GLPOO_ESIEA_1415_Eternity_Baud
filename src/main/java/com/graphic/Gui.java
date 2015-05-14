package main.java.com.graphic;

import java.awt.event.*;
import java.awt.Graphics2D; //pour les events repaint
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FileDialog;
import java.awt.Cursor; //pour le choix du curseur

public class Gui extends JFrame implements ActionListener,MouseListener
{
	//Creation du JFrame avec le focus
	private JFrame frame;
	private Cursor curseurFleche;

	//Creation table
	private JButton[][] plateau;
	private SuperpoRotateIcon[][] images;
	private int taille;

	//Creation des panels 
	private JPanel panelOutil;
	private JPanel panelPuzzle;

	//Creation barre de menu
	private JMenuBar barreMenu;
	private JMenu fichier;
	private JMenu aide;
	private JMenuItem nouvellePartie_;
	private JMenuItem menu_;
	private JMenuItem sauvegarder_;
	private JMenuItem instructions_;
	private JMenuItem about_;

	//images pour le panel outil
	private ImageIcon imageFlecheDroite;
	private ImageIcon imageFlecheGauche;

	//Creation des boutons et label du panel outil
	private JLabel chronoLabel;
	private JButton droiteLabel;
	private JButton gaucheLabel;
	private JButton menuLabel;
	private JButton sauveLabel;

	//Elements de jeu
	private String fichierFaces;
	private String fichierPieces;
	private String fichierPartie;
	private Map<Integer,Face> faceHmap;
	private Map<Integer,Piece> piecesHmap;
	private FaceCsvDao facesDao;
	private PieceCsvDao piecesDao;
	private PartieCsvDao partieDao;
	private Partie[][] partie;
	private JButton testCerveau;
	private SuperpoRotateIcon imageComposeeTournee;

	//Variables evenementielles
	private Boolean isPieceSelectionnee;
	private int xSelect;
	private int ySelect;
	private Piece tempPiece;
	private Orientation tempOrientation;
	private Verification verif;
	private SavePartie save = new SavePartie();
	
	public Gui()
	{
		//appel au constructeur de la classe mère
		super();
		System.out.println("Graphic User Interface is being set");

		//initialisations diverses
		initFenetre();
		initObjects();
		initBarreMenu();
		initPanel();
		initPartie();
		initPlateau();

		//initialisation des var d'event
		isPieceSelectionnee = false;
		xSelect = 0;
		ySelect = 0;
		tempPiece = null;
		tempOrientation = null;
		verif = new Verification(partie);
		chrono = new Timer(1000, marche);		
   		chrono.start();
		//ajout des panel à la frame
		this.add(panelPuzzle);
		this.add(panelOutil);

		//autorisation de l'affichage
		this.setVisible(true);
	}

	private void initPartie()
	{
		fichierFaces = "faces.csv";
		fichierPieces = "pieces.csv";
		fichierPartie = "partie.csv";
		partie = new Partie[taille][taille];
		facesDao = new FaceCsvDao();
		faceHmap = facesDao.parser(fichierFaces,",");
		piecesDao = new PieceCsvDao(faceHmap);
		piecesHmap = piecesDao.parser(fichierPieces,",");
		partieDao = new PartieCsvDao(piecesHmap);
		partie = partieDao.parser(fichierPartie,",");
	}

	private void initPlateau()
	{
		plateau = new JButton[taille][taille];
		images = new SuperpoRotateIcon[taille][taille];
		for (int lin=0; lin<taille; lin++)
		{
			for (int col=0; col<taille; col++)
			{
				images[lin][col] = new SuperpoRotateIcon(partie[lin][col].piece, partie[lin][col].orientation);
				plateau[lin][col] = new JButton(images[lin][col]);
				plateau[lin][col].setBackground(Color.BLACK);
				plateau[lin][col].setBounds(5+5*col+150*col, 5+5*lin+150*lin, 150, 150); //marge intercell 5, taille cell 150
				plateau[lin][col].addMouseListener(this);
				plateau[lin][col].addActionListener(this);
				panelPuzzle.add(plateau[lin][col]);
			}
		}
	}

	private void initBarreMenu()
	{
		//Barre de menu
			barreMenu = new JMenuBar();
			fichier = new JMenu("Fichier");
			aide = new JMenu("Aide");
			nouvellePartie_ = new JMenuItem("Recommencer");
			menu_ = new JMenuItem("Menu");
			sauvegarder_ = new JMenuItem("Sauvegarder");
			instructions_ = new JMenuItem("Instructions");
			about_ = new JMenuItem("A propos");

			//Hierarchie de la Barre de menu
			fichier.add(nouvellePartie_);
			fichier.add(menu_);
			fichier.add(sauvegarder_);
			aide.add(instructions_);
			aide.add(about_);
			barreMenu.add(fichier);
			barreMenu.add(aide);
			setJMenuBar(barreMenu);

			//Listeners
			nouvellePartie_.addActionListener(new ActionListener()  //Fichier>Recommencer
			{
				public void actionPerformed(ActionEvent event)
				{
					//lancement nouvelle partie
				}
			});
			menu_.addActionListener(new ActionListener()  //Fichier>Menu
			{
				public void actionPerformed(ActionEvent event)
				{
					//ouverture fenetre de menu
				}
			});
			sauvegarder_.addActionListener(new ActionListener()  //Fichier>Sauvegarder
			{
				public void actionPerformed(ActionEvent event)
				{
					//sauvegarde
					//pop up confirmant la sauvegarde
				}
			});			
		instructions_.addActionListener(new ActionListener() //Aide>Instructions
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
		about_.addActionListener(new ActionListener()//Aide>A propos
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

	private void initObjects()
	{
		//images pour le panel outil
		imageFlecheDroite = new ImageIcon("images/flecheTourneDroite.png");
		imageFlecheGauche = new ImageIcon("images/flecheTourneGauche.png");

		//boutons et label du panel outil
		chronoLabel = new JLabel("00:00");
		droiteLabel = new JButton("",imageFlecheDroite);
		gaucheLabel = new JButton("",imageFlecheGauche);
		menuLabel = new JButton("Menu");
		sauveLabel = new JButton("Sauvegarder");

		//ajout de l'actionListener
		droiteLabel.addMouseListener(this);
		gaucheLabel.addMouseListener(this);
		menuLabel.addMouseListener(this);
		sauveLabel.addMouseListener(this);

		//taille pour les tableaux
		taille = 4;
	}

	private void initFenetre()
	{
		frame = this;
		curseurFleche = new Cursor(Cursor.DEFAULT_CURSOR);

		//proprietes de la fenetre
		this.setTitle("Eternity");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,675);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//Curseur fleche
		setCursor(curseurFleche);
	}

	private void initPanel()
	{
		plateau = null;
		panelOutil = new JPanel();
		panelPuzzle = new JPanel();

		//Setting des dimensions des panel
		panelPuzzle.setSize(new Dimension(620,620));
		panelPuzzle.setLocation(0,0);
		panelPuzzle.setLayout(null);
		panelOutil.setPreferredSize(new Dimension(350,450));
		panelOutil.setLocation(610,0);
		panelOutil.setLayout(null);

		//ajout des composants dans les panel
		panelOutil.add(chronoLabel);
		panelOutil.add(menuLabel);
		panelOutil.add(sauveLabel);
		panelOutil.add(droiteLabel);
		panelOutil.add(gaucheLabel);

		//Positions et taille des composants du panel outil
		chronoLabel.setBounds(700,50,250,50);
		droiteLabel.setBounds(655,150,100,150);
		gaucheLabel.setBounds(760,150,100,150);
		menuLabel.setBounds(660,400,200,50);
		sauveLabel.setBounds(660,475,200,50);

		//retouche esthétique des boutons
		chronoLabel.setFont(chronoLabel.getFont().deriveFont(50.0f));
		droiteLabel.setContentAreaFilled(false);
		droiteLabel.setBorderPainted(false);
		gaucheLabel.setContentAreaFilled(false);
		gaucheLabel.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent event)
	{
		//click sur une case
		for(int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				if (event.getSource() == plateau[i][j])
				{
					if (isPieceSelectionnee)
					{
						//déselection
						System.out.println("Dé-selection de : "+xSelect+","+ySelect);

						isPieceSelectionnee = false;
						images[xSelect][ySelect].enleveCadre();
						
						if (i!=xSelect || j!=ySelect)
						{
							System.out.println("echange");
							
						

							partie[xSelect][ySelect].piece = partie[i][j].piece;
							partie[xSelect][ySelect].orientation = partie[i][j].orientation;
							partie[i][j].piece = tempPiece;
							partie[i][j].orientation = tempOrientation;

							images[xSelect][ySelect].setPiece(images[i][j].getPiece());
							images[xSelect][ySelect].setOrientation(images[i][j].getOrientation());
							images[i][j].setPiece(tempPiece);
							images[i][j].setOrientation(tempOrientation);
						}

						//verif si victoire
						if(verif.checkVictoire() == true)
							System.out.println("Victoire !");

						repaint();
					}
					else
					{
						System.out.println("Selection de : "+i+","+j);
						xSelect = i;
						ySelect = j;
						tempPiece = images[xSelect][ySelect].getPiece();
						tempOrientation = images[xSelect][ySelect].getOrientation();

						isPieceSelectionnee = true;
						images[xSelect][ySelect].ajouteCadre();

						//verif si victoire
						if(verif.checkVictoire() == true)
						System.out.println("Victoire !");

						repaint();

					}
				}
			}
		}
	}

	public void mouseClicked(MouseEvent event)
	{
		//LEFT button
		if (event.getButton() == 1)
		{
			//click sur la fleche pour tourner à droite
			if (event.getSource() == droiteLabel)
			{
				if(isPieceSelectionnee)
				{
					partie[xSelect][ySelect].orientation = partie[xSelect][ySelect].orientation.getDroite();
					images[xSelect][ySelect].rotateDroite();
					repaint();

					//verif si victoire
					if(verif.checkVictoire() == true)
						System.out.println("Victoire !");
				}
			}
			//click sur la fleche pour tourner à gauche
			else if (event.getSource() == gaucheLabel)
			{
				if(isPieceSelectionnee)
				{
					partie[xSelect][ySelect].orientation = partie[xSelect][ySelect].orientation.getGauche();
					images[xSelect][ySelect].rotateGauche();
					repaint();

					//verif si victoire
					if(verif.checkVictoire() == true)
						System.out.println("Victoire !");
				}
			}
			//click sur le bouton de menu
			else if (event.getSource() == menuLabel)
			{
				//
			}
			//click sur le bouton de sauvegarde
			else if (event.getSource() == sauveLabel)
			{
				System.out.println("Sauvegarde de la Partie");
				save.savePartie(partie);
				System.out.println("Partie Sauvegardee");
			}
		}
	}

	Timer chrono;
    int valeur = 0;
    ActionListener marche = new ActionListener()  {
		  public void actionPerformed(ActionEvent e1)  {

			  valeur++;
			
			  int minute = valeur/60;
	          int seconde = valeur - (minute*60);
	
	          String stringMin = Integer.toString(minute);
	          
	          if (minute < 10)
	          {
	        	  stringMin = "0" + Integer.toString(minute);
	          }
	          
	          String stringSec = Integer.toString(seconde);
	          
	          if (seconde < 10)
	          {
	        	  stringSec = "0" + Integer.toString(seconde);
	          }

			  chronoLabel.setText(stringMin+":"+stringSec);		 
		 }
     };	
     
	public void mouseExited(MouseEvent event)
	{
		return;
	}

	public void mouseEntered(MouseEvent event)
	{
		return;
	}

	public void mouseReleased(MouseEvent event)
	{
		return;
	}

	public void mousePressed(MouseEvent event)
	{
		return;
	}
}