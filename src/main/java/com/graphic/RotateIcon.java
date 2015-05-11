package com.graphic;

import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class RotateIcon extends ImageIcon
{
	private ImageIcon icone;
	private Orientation orientation;
	private double angle;
	public enum Orientation
	{
		NORD,
		EST,
		SUD,
		OUEST;
	}

	//Constructeur nord par défaut
	public RotateIcon(ImageIcon icone)
	{
		this(icone, Orientation.NORD);
	}

	//Constructeur avec orientation
	public RotateIcon(ImageIcon icone, Orientation orientation)
	{
		this.icone = icone;
		this.orientation = orientation;
	}

	//getter icone
	public ImageIcon getIcone()
	{
		return icone;
	}

	//getter orientation
	public Orientation getOrientation()
	{
		return orientation;
	}

	//
	@Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2d = (Graphics2D)g.create();

		if (orientation == Orientation.NORD)
		{
			g2d.translate(x-150,y-150);
			icone.paintIcon(c,g2d,x,y);
		}
		else if (orientation == Orientation.EST)
		{
			g2d.translate(x+150,y-150);
			g2d.rotate(Math.toRadians(90));
			icone.paintIcon(c,g2d,x,y);
		}
		else if (orientation == Orientation.SUD)
		{
			g2d.translate(x+150,y+150);
			g2d.rotate(Math.toRadians(180));
			icone.paintIcon(c,g2d,x,y);
		}
		else if (orientation == Orientation.OUEST)
		{
			g2d.translate(x-150,y+150);
			g2d.rotate(Math.toRadians(-90));
			icone.paintIcon(c,g2d,x,y);
		}
	}
}