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
	private JFrame frame = this;

	//Creation table
	private JTable table = null;
	private ModeleTable modele = null;

	//Creation panel pour les boutons et le temps
	JPanel panelOutil = new JPanel();

	//Creation panel pour le puzzl
	JPanel panelPuzzle = new JPanel();

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

	//images pour outils
	ImageIcon imageFlecheDroite = new ImageIcon("images/flecheTourneDroite.png");
	ImageIcon imageFlecheGauche = new ImageIcon("images/flecheTourneGauche.png");

	//Creation des boutons et label d'outils
	JLabel chronoLabel = new JLabel("00:00");
	JButton tourneDroite = new JButton("",imageFlecheDroite);
	JButton tourneGauche = new JButton("",imageFlecheGauche);
	JButton menuLabel = new JButton("Menu");
	JButton sauveLabel = new JButton("Sauvegarder");

	List<String> faces = new ArrayList<String>();
	Piece piece;
	SuperpoRotateIcon imageComposeeTournee;

	public Gui()
	{
		//appel au constructeur de la classe mère
		super();
		System.out.println("Graphic User Interface is being set");

		//Set the window properties
		this.setTitle("test pour JTable");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,655);
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
		

		faces.add("faces/couleur-bandes.png");
		faces.add("faces/couleur-etoile.png");
		faces.add("faces/couleur-shuriken.png");
		faces.add("faces/couleur-zigzag.png");
		piece = new Piece(faces);
		imageComposeeTournee = new SuperpoRotateIcon(piece,Orientation.OUEST);

		imageChouette.ajoutCouche(coucheCoeur);
		imageTournee = new RotateIcon(imageTruc,Orientation.EST);

		//Tableau de données
		Object[][] donnees =
		{
			{imageChouette,Color.red,imageTruc},
			{imageTournee,Color.blue,imageBidule},
			{imageComposeeTournee,Color.yellow,imageTruc}
		};

		//Tableau de titres
		String titre[] = {"Pieces", "Couleur", "Image"};

		modele = new ModeleTable(donnees,titre);
		this.table = new JTable(modele);
		System.out.println("Nb colonnes : "+modele.getColumnCount());
		System.out.println("Nb lignes : "+modele.getRowCount());
		table.setDefaultRenderer(ImageIcon.class, new BorderRenderer(table.getDefaultRenderer(ImageIcon.class)));

		//Setting des dimensions des cases
		TableColumnModel columnModel = this.table.getColumnModel();
		this.table.setRowHeight(150);
		columnModel.getColumn(0).setPreferredWidth(150);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(150);
		//columnModel.getColumn(3).setPreferredWidth(150);

		//Setting des dimensions des panel
		panelPuzzle.setSize(new Dimension(450,450));
		panelPuzzle.setLocation(5,0);
		panelOutil.setPreferredSize(new Dimension(350,450));
		panelOutil.setLocation(610,0);
		panelOutil.setLayout(null);

		//ajout des composants dans les panel
		panelPuzzle.add(table);
		panelOutil.add(chronoLabel);
		panelOutil.add(menuLabel);
		panelOutil.add(sauveLabel);
		panelOutil.add(tourneDroite);
		panelOutil.add(tourneGauche);

		//Positions des composants du panel outil
		chronoLabel.setLocation(675,50);
		tourneDroite.setLocation(655,150);
		tourneGauche.setLocation(760,150);
		menuLabel.setLocation(660,400);
		sauveLabel.setLocation(660,475);

		//Taille des composants dans le panel outil
		chronoLabel.setSize(200,50);
		chronoLabel.setFont(chronoLabel.getFont().deriveFont(50.0f));
		tourneDroite.setSize(100,150);
		tourneGauche.setSize(100,150);
		menuLabel.setSize(200,50);
		sauveLabel.setSize(200,50);

		//retouche esthétique des boutons
		tourneDroite.setContentAreaFilled(false);
		tourneDroite.setBorderPainted(false);
		tourneGauche.setContentAreaFilled(false);
		tourneGauche.setBorderPainted(false);

		//ajout des panel à la frame
		this.add(panelPuzzle);
		this.add(panelOutil);


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