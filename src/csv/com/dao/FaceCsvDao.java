package csv.com.dao;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// Cette classe recupere les donnees contenues dans le csv et cree un hashmap les contenants
public class FaceCsvDao {
	
	
	
 public FaceCsvDao(){
	 	
	 }
 //[]
 public Map<Integer,Face> parser(String fichier,BufferedReader br,String ligne,String separateur){
	 
	
	 	int iterateur=0;
	 	
	 
		 
			Map<Integer, Face> faces = new HashMap<Integer, Face>();
	 
			try {
				br = new BufferedReader(new FileReader(fichier));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while ((ligne = br.readLine()) != null) {
 
					// use comma as separator
					String[] contenu = ligne.split(separateur);
					//on cree un objet face que l on met dans un hashmap
					// du coup mettre les bords noirs en null pour eviter l erreur
					faces.put(iterateur++, new Face(contenu[0].charAt(0),contenu[1],contenu[1],Integer.parseInt(contenu[2])));
					
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
		 
		return faces;
		
 	}
}
