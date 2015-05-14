import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

// cette classe permet de trier les 3 meilleurs score
public class CompareScore {

	ArrayList<Score> liste = new ArrayList<Score>(); 

	public CompareScore(ArrayList<Score> liste ){
		this.liste = liste;
	}
	// trie la liste des scores en fonction du temps
	public ArrayList<Score> trierListe(ArrayList<Score> scores ){

		/*Classement selon le temps*/
		System.out.println("Classement selon le temps");
		Collections.sort(scores, Score.ScoreTempsComparator);
		return scores;
	}


	public boolean integreScore(String nom,int minutes, int secondes){

		ReadScore liste_score = new ReadScore();
		ArrayList<Score> liste = new ArrayList<Score>();
		boolean best_score= false;
		SaveScoreCSV saver = new SaveScoreCSV();

		//on ajoute les deux ints et on recupere la lite des scores
		int score = Integer.parseInt(Integer.toString(minutes) + Integer.toString(secondes));
		liste = liste_score.read();
		System.out.println("affichage initial");
		for (Score score2 : liste) {
			System.out.println(score2.toString());
		}
		System.out.println("fin affichage initial");
		// on ajoute le dernier joueur
		Score nouveau_score = new Score(nom,score); 
		liste.add(nouveau_score);
		// cas ou il n y a pas encore 3 parties enregistres
		liste.add(new Score(" ", 1000));
		liste.add(new Score(" ", 1000));
		// maintenant on va trier le tableau et garder les trois premiers elements
		Collections.sort(liste, Score.ScoreTempsComparator);
		// on garde 3 premiers et on vire le reste

		Score premier =liste.get(0);
		Score deuxieme =liste.get(1);
		Score troisieme =liste.get(2);

		// verif si nouvreau meilleur score

		if (nouveau_score.equals(premier) && nouveau_score.equals(deuxieme) && nouveau_score.equals(troisieme) ) {
			best_score = true; 
		}
		System.out.println("222222222222222222222222222");
		for (Score score2 : liste) {
			System.out.println(score2.toString());
		}
		System.out.println("2222222222222222222222222222");
		liste.clear();
		if (premier.getScore()!= 1000  ) {
			liste.add(premier);
		}
		if (deuxieme.getScore() != 1000) {
			liste.add(deuxieme);
		}
		if (troisieme.getScore() !=1000) {
			liste.add(troisieme);	
		}

		// modif de la liste 
		this.liste= liste;
		// ecriture de la nouvelle liste
		try {
			saver.save(liste);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return best_score;
	}
	public ArrayList<Score> getListe() {
		return liste;
	}
	public void setListe(ArrayList<Score> liste) {
		this.liste = liste;
	}

		

}