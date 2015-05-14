package main.java.com.graphic;

import java.util.*;

public class Partie
{
	public  Piece piece;
	public  int x;
	public  int y;
	public Orientation orientation;
	//tous les attributs sont destinés à être utilisés partie.attrbut
	//on les laisse en public, on ne fait pas de getters
	
	//destiné a etre construit sous forme de tableau[][]
	public Partie(Piece piece, int x, int y, Orientation orientation)
	{
		this.piece = piece;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
}