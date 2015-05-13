import java.awt.List;
import java.util.Iterator;


public class Verification
{
	private Partie[][] partie;
	private Orientation tempOr;

	public Verification(Partie[][] partie)
	{
		this.partie = partie;
	}


	public Boolean checkVictoire()
	{	
		// test des coins
		if (getType(partie[0][0],Orientation.NORD)!='B' || getType(partie[0][0],Orientation.OUEST)!='B')
			return false;
		if (getType(partie[0][3],Orientation.NORD)!='B' || getType(partie[0][3],Orientation.EST)!='B')
			return false;
		if (getType(partie[3][0],Orientation.SUD)!='B' || getType(partie[3][0],Orientation.OUEST)!='B')
			return false;
		if (getType(partie[3][3],Orientation.SUD)!='B' || getType(partie[3][3],Orientation.EST)!='B')
			return false;
		
		//test des bordures en haut
		if (getType(partie[0][1],Orientation.NORD)!='B')
			return false;
		if (getType(partie[0][2],Orientation.NORD)!='B')
			return false;
		
		//test des bordures en bas
		if (getType(partie[3][1],Orientation.SUD)!='B')
			return false;
		if (getType(partie[3][2],Orientation.SUD)!='B')
			return false;

		//test des bordures a gauche
		if (getType(partie[1][0],Orientation.OUEST)!='B')
			return false;
		if (getType(partie[2][0],Orientation.OUEST)!='B')
			return false;

		//test des bordures a gauche
		if (getType(partie[1][3],Orientation.EST)!='B')
			return false;
		if (getType(partie[2][3],Orientation.EST)!='B')
			return false;

		//test des faces adjacentes horizontalement
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<3; j++)
			{
				if(getId(partie[i][j],Orientation.EST) != getId(partie[i][j+1],Orientation.OUEST))
					return false;
			}
		}

		//test des faces adjacentes verticalement
		for (int i=0; i<3; i++)
		{
			//System.out.println("Ligne"+i);
			for (int j=0; j<4; j++)
			{
				//System.out.println("Colonne"+j);
				if(getId(partie[i][j],Orientation.SUD) != getId(partie[i+1][j],Orientation.NORD))
					return false;
			}
		}

		//si on est arrivé jusque là c'est que tout est bon, victoire !
		return true;
	}

	private char getType(Partie partie_, Orientation faceOr)
	{
		tempOr = partie_.orientation;
		for(Face face : partie_.piece.getFaces())
		{
			if(faceOr == tempOr)
				return face.getType();
			else
				tempOr = tempOr.getDroite();
		}
		return 'F';
	}

	private int getId(Partie partie_, Orientation faceOr)
	{
		tempOr = partie_.orientation;
		for(Face face : partie_.piece.getFaces())
		{
			if(faceOr == tempOr)
				return face.getId();
			else
				tempOr = tempOr.getDroite();
		}
		return 0;
	}
}