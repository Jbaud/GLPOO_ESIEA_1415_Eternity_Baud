package main.java.com.graphic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;

public class ScoreCsvDao
{
	private ArrayList<Score> liste_score;
	public ScoreCsvDao()
	{
		this.liste_score = new ArrayList<Score>();
	}
	
	public ArrayList<Score> read()
	{
		CSVReader reader = null;
		try {
		reader = new CSVReader(new FileReader("score.csv"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String [] nextLine;

		try {
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(nextLine[0]);
				liste_score.add(new Score(nextLine[0],Integer.parseInt(nextLine[1]))); 
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return liste_score;
	}	
}