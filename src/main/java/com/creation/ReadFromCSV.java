package com.creation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Description
// Cette classe fourni 2 methodes permettant de lire soit un fichier face soit un fichier piece.

//TODO
// implementer ecriture dans les objets de type face ou pieces.

public class ReadFromCSV {

	  public static void main(String[] args) {
		  
			ReadFromCSV obj = new ReadFromCSV();
			obj.face();
			
		  }
		 
		  public void face() {
		 
			String csvFile = "/Users/mkyong/Downloads/GeoIPCountryWhois.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
		 
			try {
		 
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
		 
				        // use comma as separator
					String[] country = line.split(cvsSplitBy);
		 
					System.out.println("Face=> [Type= " + country[0] 
		                                 + " , id=" + country[1] + " , couleur_fond=" + country[2] + " , forme=" + country[3] + " , couleur_forme=" + country[4] +"]");
		 
				}
		 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			//Inserer log a la place
			System.out.println("Fin de la lecture du fichier des faces");
		  }
		 
		  public void piece() {
				 
				String csvFile = "/Users/mkyong/Downloads/GeoIPCountryWhois.csv";
				BufferedReader br = null;
				String line = "";
				String cvsSplitBy = ",";
			 
				try {
			 
					br = new BufferedReader(new FileReader(csvFile));
					while ((line = br.readLine()) != null) {
			 
					        // use comma as separator
						String[] country = line.split(cvsSplitBy);
			 
						System.out.println("Face=> [id_pieces= " + country[0] 
			                                 + " , id_forme_nord=" + country[1] + " , id_forme_est=" + country[2] + " , id_forme_sud=" + country[3] + " , couleur_ouest=" + country[4] +"]");
			 
					}
			 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				//Inserer log a la place
				System.out.println("Fin de la lecture du fichier des faces");
			  }
			 
}

	

