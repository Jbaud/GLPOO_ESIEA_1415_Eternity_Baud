package main.java.com.graphic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class TempsCsvDao
{

	private List<Temps> liste_temps;

	public TempsCsvDao()
	{
		this.liste_temps = new ArrayList<Temps>();
	}
		
	public List<Temps> readTemps()
	{
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("temps.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    String [] nextLine;
	    liste_temps.add(new Temps(0,0));
	    try {
			while ((nextLine = reader.readNext()) != null)
			{
				liste_temps.add(new Temps(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]))); 
			}
		} catch (NumberFormatException | IOException e)
		{
			e.printStackTrace();
		}
	    
		return liste_temps;
	    
	}

	public void saveTemps(int min, int sec){
		//on veut garder une liste de taille <=3
		if (liste_temps.size() == 4) {
			liste_temps.remove(3);
		}
		int index = 0;
		// On ajoute le nouveau temps en haut de la liste
		liste_temps.add(1, new Temps(min,sec));

		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter("temps.csv"), ',', 
				    CSVWriter.NO_QUOTE_CHARACTER, 
				    CSVWriter.NO_ESCAPE_CHARACTER, 
				    System.getProperty("line.separator"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     // feed in your array (or convert your data to an array)
	    // String[] entries = "first#second#third".split("#");
	     for (Temps l : liste_temps) {
	    	if ((index > 0) && (index < 4))
	    	{
	    		String[] entries =  {String.valueOf(l.getMinutes()),String.valueOf(l.getSecondes())};
	    		writer.writeNext(entries);
	    	}
	    	index++;
		}
	     try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setListe_temps(ArrayList<Temps> liste_temps) {
		this.liste_temps = liste_temps;
	}

}