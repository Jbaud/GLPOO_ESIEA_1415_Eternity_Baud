package main.java.com.graphic;

import java.util.*;

public class Face
{
	private int id;
	private String nom;
	private String url;
	private char type;
	// attention pas de setter, aucune modif d'une face deja creee
	
	public Face(int id, String nom, char type)
	{
		this.type = type;
		this.nom = nom;
		this.url = "faces/"+nom+".png";
		this.id = id;		
 	}

	public char getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}

	public String getUrl() {
		return url;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Face [type=" + type + ", nom=" + nom + ", url=" + url
				+ ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + id;
		result = prime * result + type;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Face other = (Face) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	
}