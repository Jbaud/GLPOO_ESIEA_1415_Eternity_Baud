package csv.com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PieceCsvDao {

	
	public String fichier;
	public BufferedReader br;
	public String ligne;
	public String separateur;


 public PieceCsvDao(){
		
		 	
 }

 public Map<Integer,Piece> parser(String fichier,BufferedReader br,String ligne,String separateur){
	 
	 		int iterateur=0; 
	 
	 		FaceCsvDao lecteurCsv = new FaceCsvDao();
	 		//faces contient la liste des faces.
	 		Map<Integer,Face> faces =  lecteurCsv.parser("lulz", br, ligne, separateur);
	 				
	 		// creation de la liste qui va contenir les faces pour chaques pieces
	 		Map<Integer,Piece> pieces = new HashMap<Integer,Piece>();
			
			try {
				br = new BufferedReader(new FileReader(fichier));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while ((ligne = br.readLine()) != null) {
 
					// on construit le tableau lu
					String[] contenu = ligne.split(separateur);
					pieces.put(iterateur++,new Piece(Integer.parseInt(contenu[0]), faces.get(Integer.parseInt(contenu[1])),faces.get(Integer.parseInt(contenu[2])),faces.get(Integer.parseInt(contenu[3])),faces.get(Integer.parseInt(contenu[4]))));
				
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			//a mettre en log  
			System.out.println("Fin de la lecture");
		  
		return pieces;
		
 	}


}
