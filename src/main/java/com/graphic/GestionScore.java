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

		// score = 100*minutes+secondes
		Temps temps = new Temps(minutes,secondes);

		// on cree et ajoute le nouveau score
		Score nouveau_score = new Score(nom,temps); 
		scores.add(nouveau_score);

		// maintenant on va trier le tableau et garder les trois premiers elements
		// colletion trie la liste avec la clé demandée
		Collections.sort(scores, Score.ScoreTempsComparator);
		
		// si plus de 3 elements on garde 3 premiers uniquement
		// on garde 3 premiers et on vire le reste
		if (scores.size()>3) {
			Score premier =liste.get(0);
			Score deuxieme =liste.get(1);
			Score troisieme =liste.get(2);

			scores.clear();
			scores.add(premier);
			scores.add(deuxieme);
			scores.add(troisieme);
		}
		// la liste contient bien trois elements

		// sauvegarde liste
		this.liste= scores;
		
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