package main.java.com.graphic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class TempsCsvDao
{

	private ArrayList<Temps> liste_temps;

	public TempsCsvDao()
	{
		liste_temps = new ArrayList<Temps>();
	}
		
	public Temps readTemps(int valeur)
	{
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("temps.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     String [] nextLine;
	     try {
			while ((nextLine = reader.readNext()) != null) {
		
			   liste_temps.add(new Temps(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[0]))); 
			 }
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     this.liste_temps = liste_temps;
	     
	     if (valeur==0) {
			return new Temps(0, 0);
		}
	     if (valeur !=0 && valeur <= 3 ) {
				return liste_temps.get(valeur);
			}
	     // case fail
		return null;
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

	public ArrayList<Temps> getListe_temps() {
		return liste_temps;
	}

	public void setListe_temps(ArrayList<Temps> liste_temps) {
		this.liste_temps = liste_temps;
	}

}