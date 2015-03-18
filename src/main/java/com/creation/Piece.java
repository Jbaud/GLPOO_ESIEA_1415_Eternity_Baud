package com.creation;

public class Piece {

	public int id_piece;
	public int id_forme_nord;
	public int id_forme_est;
	public int id_forme_sud;
	public int id_forme_ouest;


public Piece(int id_piece, int id_forme_nord,int id_forme_est, int id_forme_sud, int id_forme_ouest ){
	this.id_piece=id_piece;
	this.id_forme_nord=id_forme_nord;
	this.id_forme_est=id_forme_est;
	this.id_forme_sud=id_forme_sud;
	this.id_forme_ouest=id_forme_ouest;
	
}
@Override
public String toString(){
	return "id_piece: "+id_piece+" id_forme_nord: "+id_forme_nord+" id_forme_est: "+id_forme_est+" id_forme_sud: "+id_forme_sud+" id_forme_ouest: "+id_forme_ouest;
}
}
