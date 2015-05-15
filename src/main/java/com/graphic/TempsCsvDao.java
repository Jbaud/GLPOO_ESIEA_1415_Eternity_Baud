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

	public void writeTemps(){
		
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter("temps.csv"), '\t');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     // feed in your array (or convert your data to an array)
	    // String[] entries = "first#second#third".split("#");
	     for (Temps l : liste_temps) {
	    	 String[] entries =  {String.valueOf(l.getMinutes()),String.valueOf(l.getSecondes())};
	    	 writer.writeNext(entries);
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