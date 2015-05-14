package main.java.com.graphic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;

public class PartieCsvDao
{
	private Map<Integer, Piece> piecesHmap;
	private Partie[][] partie;
	private BufferedReader br;
	private String ligne;

	public PartieCsvDao(Map<Integer, Piece> piecesHmap)
	{
		ligne = "";
		this.piecesHmap = piecesHmap;
		partie = new Partie[4][4];

	}

	public Partie[][] parser(String fichier,String separateur)
	{
		//initialisation du BufferedReader
		try
		{
			br = new BufferedReader(new FileReader(fichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Lecture et parsing
		//STRUCTURE CSV : (int)id_piece, (int)coordX, (int)coordY, (String)ORIENTATION
		try
		{
			while ((ligne = br.readLine()) != null)
			{
				if(!ligne.startsWith("#"))
				{
					String[] contenu = ligne.split(separateur);
					//on lit le csv partie, on récup les pièces, on place dans le tableau partie[][] aux coord
					//CONSTRUCTEUR PARTIE [pour rappel] : Partie(Piece piece, int x, int y, Orientation orientation)
					partie[Integer.parseInt(contenu[1],10)][Integer.parseInt(contenu[2],10)] =
						new Partie(piecesHmap.get(Integer.parseInt(contenu[0],10)), Integer.parseInt(contenu[1],10), Integer.parseInt(contenu[2],10), Orientation.valueOf(contenu[3]));	
				}
			}
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		//fermeture du BufferedReader
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		//a mettre en log  
		System.out.println("Fin de la lecture - partie");
	  
		return partie;
	}
}