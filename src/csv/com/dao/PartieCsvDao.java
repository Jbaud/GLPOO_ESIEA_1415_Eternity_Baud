package csv.com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public class PartieCsvDao {

		public PartieCsvDao(){
			
			
		}

		public Partie[][] parser(String fichier,BufferedReader br,String ligne,String separateur){
		
			PieceCsvDao pieces = new PieceCsvDao();
			Map<Integer, Piece> listepiece = pieces.parser("lulz", br, ligne, separateur);
			// creation du tableau 2d de la partie
			
			Partie[][] position = new Partie[4][4];
			
			try {
				br = new BufferedReader(new FileReader(fichier));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while ((ligne = br.readLine()) != null) {
 
					String[] contenu = ligne.split(separateur);
					// pos[x][y]= new Partie(get.piece, contenu 1, contenu 2 , charat de contenu3 )
position[Integer.parseInt(contenu[1])][Integer.parseInt(contenu[2])]= new Partie(listepiece.get(contenu[0]),Integer.parseInt(contenu[1]),Integer.parseInt(contenu[2]),contenu[3].charAt(0));
					
					//position[Integer.parseInt(contenu[1])][Integer.parseInt(contenu[2])] = listepiece.get(contenu[0]);
					
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
		  
		return position;

			
			
			
		}
}
