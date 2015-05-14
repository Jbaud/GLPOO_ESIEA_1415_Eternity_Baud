import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

//cette classe sauvegarde le fic
public class SaveScoreCSV {


	public SaveScoreCSV(){


	}

	public void  saveScore(String[] score){

		String csv = "score.csv";
		CSVWriter writer = null;
		try {
			// ajout de true dans le constructeur FileWriter afin qu il ajoute a la fin du fichier existant
			// sans quotes et avec un , en separation 

			writer = new CSVWriter(new FileWriter(csv,true), ',', 
					CSVWriter.NO_QUOTE_CHARACTER, 
					CSVWriter.NO_ESCAPE_CHARACTER, 
					System.getProperty("line.separator"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.writeNext(score);


		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de l ecriture du fichier des scores");
	}
}