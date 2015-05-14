import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Aide extends JFrame {
	
	private JFrame frame = this;
	
	private JLabel selection = new JLabel(new ImageIcon("src/selection.png")); 
	private JLabel rotation = new JLabel(new ImageIcon("src/rotationDroite.png")); 
	private JLabel echange = new JLabel(new ImageIcon("src/echange.png")); 
	private JLabel match = new JLabel(new ImageIcon("src/match.png")); 
	private JLabel bords = new JLabel(new ImageIcon("src/bords.png")); 
	
	
	public Aide()
	{
		
		
	
		this.setTitle("Eternity-Aide");
		setSize(654,750);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("src/fondMenu.png")));
		setLayout(null);
		
		
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
		
	
		
		
	}
	
	
	/*public static void main(String args[])
	{
		Aide fenetreAide = new Aide();
		fenetreAide.setVisible(true);
		
	
	}*/

}

