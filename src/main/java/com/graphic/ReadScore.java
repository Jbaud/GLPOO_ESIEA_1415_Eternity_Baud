import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;


public class ReadScore {

	public ReadScore(){


	}

	public ArrayList<Score> read(){
		CSVReader reader = null;
		try {
		reader = new CSVReader(new FileReader("score.csv"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String [] nextLine;


		ArrayList<Score> list_score = new ArrayList<Score>();

		try {
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(nextLine[0]);
				list_score.add(new Score(nextLine[0],Integer.parseInt(nextLine[1]))); 
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return list_score;
	}	
}