package csv.com.dao;

import java.awt.List;
import java.util.ArrayList;

public class Piece {

	public int numero;
	public ArrayList<Face> list_face = new ArrayList<Face>();
	
	public Piece( int numero, Face forme_haut,Face forme_droite,Face forme_bas,Face forme_gauche){
		this.numero = numero;
		this.list_face.add(forme_haut);
		this.list_face.add(forme_droite);
		this.list_face.add(forme_bas);
		this.list_face.add(forme_gauche);
		
		
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Face> getList_face() {
		return list_face;
	}

	public void setList_face(ArrayList<Face> list_face) {
		this.list_face = list_face;
	}

	@Override
	public String toString() {
		return "Piece [numero=" + numero + ", list_face=" + list_face + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((list_face == null) ? 0 : list_face.hashCode());
		result = prime * result + numero;
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
		Piece other = (Piece) obj;
		if (list_face == null) {
			if (other.list_face != null)
				return false;
		} else if (!list_face.equals(other.list_face))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	
}