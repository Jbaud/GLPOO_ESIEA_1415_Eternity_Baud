package main.java.com.graphic;

import javax.swing.JOptionPane;

public class Popup {
  public static void main(String[] args) { 

	    JOptionPane JOptionPane1 = new JOptionPane(), JOptionPane2 = new JOptionPane();

	    String nom = JOptionPane1.showInputDialog(null, "Veuillez rentrer votre nom (5 lettres saisies):", "Saisie du score", JOptionPane.QUESTION_MESSAGE);
	    
	    nom=nom.substring(0, 5);
	    JOptionPane2.showMessageDialog(null, "Votre nom est " + nom, "Nom saisie", JOptionPane.INFORMATION_MESSAGE);

}
}	