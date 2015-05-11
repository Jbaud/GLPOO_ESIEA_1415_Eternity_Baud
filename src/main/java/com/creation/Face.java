package com.creation;

public class Face {

	public String type;
	public int id;
	public String couleur_fond;
	public String forme;
	public String couleur_forme;
	

// TO-DO définir les méthodes de la classe Face
	
public Face(String type, int id, String couleur_fond, String forme, String couleur_forme){
	this.type=type;
	this.id=id;
	this.couleur_fond=couleur_fond;
	this.forme=forme;
	this.couleur_forme=couleur_forme;
	
	}
@Override
public String toString(){
	return "type: "+type+" id: "+id+" couleur_fond: "+couleur_fond+" forme: "+forme+" couleur_forme: "+couleur_forme;
}
	
}