import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;

public class FaceCsvDao
{
	private Map<Integer,Face> facesHmap;
	private BufferedReader br;
	private String ligne;

	public FaceCsvDao()
	{
		ligne = "";
		facesHmap = new HashMap<Integer,Face>();
	}

 	public Map<Integer,Face> parser(String fichier,String separateur)
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
		//STRUCTURE CSV : (int)id_face,(string)nom_de_la_face,(char)type
		try
		{
			while ((ligne = br.readLine()) != null)
			{
				if(!ligne.startsWith("#"))
				{
					String[] contenu = ligne.split(separateur);
					//on met la face creee dans la hmap 'facesHmap'
					//CONSTRUCTEUR FACE [pour rappel] : Face(int id, String nom, char type)
					facesHmap.put(Integer.parseInt(contenu[0],10), new Face(Integer.parseInt(contenu[0],10), contenu[1], contenu[2].charAt(0)));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//fermeture du BufferReader
		finally
		{
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//a mettre en log  
		System.out.println("Fin de la lecture - face");

		return facesHmap;
 	}
}