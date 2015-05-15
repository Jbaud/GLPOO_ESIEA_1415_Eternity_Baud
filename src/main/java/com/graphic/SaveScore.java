package main.java.com.graphic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

//cette classe sauvegarde le fic
public class SaveScore {


	public SaveScore()
	{
	}

	public void save(List<Score> liste) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream("score.csv"));
		for (Score s : liste)
			pw.println(s.toString());
		pw.close();
	}
}