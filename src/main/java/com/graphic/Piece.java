import java.util.*;

public class Piece
{
	private int id;
	private List<Face> faces;
	// attention pas de setter, aucune modif d'une piece deja creee
	
	public Piece (int id, List<Face> faces)
	{
		this.faces = faces;
		this.id = id;
		this.faces = faces;		
	}

	public int getId()
	{
		return id;
	}

	public List<Face> getFaces()
	{
		return faces;
	}

	@Override
	public String toString()
	{
		return "Piece [id=" + id + ", faces=" + faces + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((faces == null) ? 0 : faces.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Piece other = (Piece) obj;
		if (faces == null) {
			if (other.faces != null)
				return false;
		} else if (!faces.equals(other.faces))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}