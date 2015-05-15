package main.java.com.graphic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// cette classe permet de trier les 3 meilleurs score
public class GestionScore {

	List<Score> liste = new ArrayList<Score>(); 

	public GestionScore(List<Score> liste ){
		this.liste = liste;
	}

	// Si appel sur methode -> score est dans le top 3
	public void integreScore(List<Score> scores,String nom,int minutes, int secondes)
	{
		SaveScore saveScore = new SaveScore();
		List<Score> tempListe = new ArrayList<Score>();

		// score = 100*minutes+secondes
		Temps temps = new Temps(minutes,secondes);
		int newScore = temps.getMinutes() * 100 + temps.getSecondes();

		// on cree et ajoute le nouveau score
		Score score = new Score(nom,temps);

		if (newScore < scores.get(0).getScore())
		{
			tempListe.add(score);
			tempListe.add(scores.get(0));
			tempListe.add(scores.get(1));
		}
		else if (newScore < scores.get(1).getScore())
		{
			tempListe.add(scores.get(0));
			tempListe.add(score);
			tempListe.add(scores.get(1));
		}
		else
		{
			tempListe.add(scores.get(0));
			tempListe.add(scores.get(1));
			tempListe.add(score);
		}
		// la liste contient bien trois elements

		// sauvegarde liste
		this.liste= tempListe;
		
		//Ecriture du nouveau fichier de score
		try {
			saveScore.save(liste);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<Score> getListe() {
		return liste;
	}
	public void setListe(List<Score> liste) {
		this.liste = liste;
	}

	public boolean isHighScore(List<Score> scores, int minutes, int secondes)
	{
		int score3 = scores.get(2).getScore();
		int newScore = minutes*100 + secondes;
		if (newScore < score3)
			return true;
		else
			return false;
	}


}