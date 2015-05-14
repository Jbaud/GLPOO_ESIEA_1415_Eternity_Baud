import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;

public class PieceCsvDao
{
	private int iterateur;
	private List<Face> faces;
	private Map<Integer,Face> facesHmap;
	private Map<Integer,Piece> piecesHmap;
	private BufferedReader br;
	private String ligne;

	public PieceCsvDao(Map<Integer,Face> facesHmap)
	{
		ligne = "";
		this.facesHmap = facesHmap;
		piecesHmap = new HashMap<Integer,Piece>();
	}

	public Map<Integer,Piece> parser(String fichier,String separateur)
	{
		//initialisation du BufferReader
		try
		{
			br = new BufferedReader(new FileReader(fichier));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		//Lecture et parsing
		//STRUCTURE CSV : (int)id_piece, (int)id_face_1, (int)id_face_2, (int)id_face_3, (int)id_face_4
		try {
			while ((ligne = br.readLine()) != null)
			{
				if(!ligne.startsWith("#"))
				{
					//on met la piece creee dans la hmap 'pieces'
					//CONSTRUCTEUR PIECE [pour rappel] : Piece (int id, List<Face> faces)
					faces = new ArrayList<Face>();
					String[] contenu = ligne.split(separateur);
					faces.add(facesHmap.get(Integer.parseInt(contenu[1],10))); //face_1
					faces.add(facesHmap.get(Integer.parseInt(contenu[2],10))); //face_2
					faces.add(facesHmap.get(Integer.parseInt(contenu[3],10))); //face_3
					faces.add(facesHmap.get(Integer.parseInt(contenu[4],10))); //face_4
					piecesHmap.put(Integer.parseInt(contenu[0],10),new Piece(Integer.parseInt(contenu[0],10), faces));
				}
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
		System.out.println("Fin de la lecture - piece");
		
		return piecesHmap;
	}


}