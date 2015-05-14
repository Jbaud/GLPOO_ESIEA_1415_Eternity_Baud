import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import com.opencsv.CSVReader;


public class Score implements Comparable<Score>{

	private String nom_joueur;
	private int score;

	public Score(String nom_joueur,int score){
		this.nom_joueur=nom_joueur;
		this.score=score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nom_joueur == null) ? 0 : nom_joueur.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (nom_joueur == null) {
			if (other.nom_joueur != null)
				return false;
		} else if (!nom_joueur.equals(other.nom_joueur))
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	public String getNom_joueur() {
		return nom_joueur;
	}

	public void setNom_joueur(String nom_joueur) {
		this.nom_joueur = nom_joueur;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Score compareScore) {

		 int agecompare=((Score)compareScore).getScore();
	        /* For Ascending order*/
	        return this.score-agecompare;
	}

	public static Comparator<Score> ScoreTempsComparator = new Comparator<Score>() {

		public int compare(Score s1, Score s2) {
			int Score1 = s1.getScore();
			int Score2 = s2.getScore();

			//un-Descending order
			return Score1-Score2;

			//descending order
			//return StudentName2.compareTo(StudentName1);
		}};

	@Override
	public String toString() {
		//", "
		return nom_joueur +","+ score;
	}
	
}