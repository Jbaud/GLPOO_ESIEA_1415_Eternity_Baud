package com.graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel
{
	private Object[][] donnees;
	private String[] titre;

	//Constructeur
	public ModeleTable (Object[][] donnees, String[] titre)
	{
		this.donnees = donnees;
		this.titre = titre;
	}

	//Getter nombre colonnes
	public int getColumnCount()
	{
		return this.titre.length;
	}

	//Getter nombre lignes
	public int getRowCount()
	{
		return this.donnees.length;
	}

	//Getter valeur selon coordonnees
	public Object getValueAt(int lin, int col)
	{
		return this.donnees[lin][col];
	}

	//Retourne la classe de la donnée par colonne
	public Class getColumnClass (int col)
	{
		if(col==1)
			return Color.class;
		else
			return getValueAt(0,col).getClass();
	}

	//Rendre les cellules editables
	public boolean isCellEditable(int lin, int col)
	{
		return true;
	}
}