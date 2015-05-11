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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FileDialog;
import java.awt.Cursor; //pour le choix du curseur

public class Gui extends JFrame
{
	//Creation du JFrame avec le focus
	private JFrame frame;
	private Cursor curseurFleche;

	//Creation table
	private JButton[][] plateau;
	private int taille;

	//Creation des panels 
	private JPanel panelOutil;
	private JPanel panelPuzzle;

	//Creation barre de menu
	private JMenuBar barreMenu;
	private JMenu fichier;
	private JMenu aide;
	private JMenuItem nouveau_;
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
		for (int lin=0; lin<taille; lin++)
		{
			for (int col=0; col<taille; col++)
			{
				plateau[lin][col] = new JButton("",new SuperpoRotateIcon(partie[lin][col].piece, partie[lin][col].orientation));
				plateau[lin][col].setBackground(Color.BLACK);
				plateau[lin][col].setBounds(5+5*lin+150*lin, 5+5*col+150*col, 150, 150); //marge intercell 5, taille cell 150
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
		nouveau_ = new JMenuItem("Nouvelle partie");
		instructions_ = new JMenuItem("Instructions");
		about_ = new JMenuItem("A propos");

		//Hierarchie de la Barre de menu
		fichier.add(nouveau_);
		aide.add(instructions_);
		aide.add(about_);
		barreMenu.add(fichier);
		barreMenu.add(aide);
		setJMenuBar(barreMenu);

		//Listeners
		nouveau_.addActionListener(new ActionListener()  //Fichier>Nouvelle Partie
		{
			public void actionPerformed(ActionEvent event)
			{
				//partie.nouvellePartie();
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

		//taille pour les tableaux
		taille = 4;

		testCerveau = new JButton("",imageComposeeTournee);
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

		//panelOutil.add(testCerveau);

		//Positions et taille des composants du panel outil
		chronoLabel.setBounds(675,50,200,50);
		droiteLabel.setBounds(655,150,100,150);
		gaucheLabel.setBounds(760,150,100,150);
		menuLabel.setBounds(660,400,200,50);
		sauveLabel.setBounds(660,475,200,50);

		testCerveau.setBounds(500,450,150,150);

		//retouche esthétique des boutons
		chronoLabel.setFont(chronoLabel.getFont().deriveFont(50.0f));
		droiteLabel.setContentAreaFilled(false);
		droiteLabel.setBorderPainted(false);
		gaucheLabel.setContentAreaFilled(false);
		gaucheLabel.setBorderPainted(false);
	}
}