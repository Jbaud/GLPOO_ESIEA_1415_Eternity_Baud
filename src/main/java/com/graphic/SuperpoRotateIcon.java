import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class SuperpoRotateIcon extends ImageIcon
{
	private List<ImageIcon> couches;
	private List<String> faces;
	private Orientation orientation;

	//Constructeur nord par défaut
	public SuperpoRotateIcon(Piece piece)
	{
		this.faces = piece.getFaces();
		this.couches = new ArrayList<ImageIcon>();
		//boucle for qui transforme liste string en liste imageicon
		for (String str : faces)
		{
			couches.add(new ImageIcon(str));
		}
		this.orientation = Orientation.NORD;
	}

	//Constructeur ave orientation
	public SuperpoRotateIcon(Piece piece, Orientation orientation)
	{
		this.faces = piece.getFaces();
		this.couches = new ArrayList<ImageIcon>();
		//boucle for qui transforme liste string en liste imageicon
		for (String str : faces)
		{
			couches.add(new ImageIcon(str));
		}
		this.orientation = orientation;
	}

	public void rotateDroite()
	{
		this.orientation = this.orientation.getDroite();
	}

	public void rotateGauche()
	{
		this.orientation = this.orientation.getGauche();
	}

	//
	@Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2d = (Graphics2D)g.create();
		int count = 1;

		int xAdjustment = +225;
		int yAdjustment = -75;

		for (ImageIcon couche : couches)
		{
			if (count == 1)
			{
				//translation et rotation
				if (this.orientation == Orientation.NORD)
				{
					g2d.translate(x-150,y-150);
					g2d.rotate(Math.toRadians(0));
				}
				else if (this.orientation == Orientation.EST)
				{
					g2d.translate(x+150,y-150);
					g2d.rotate(Math.toRadians(90));
				}
				else if (this.orientation == Orientation.SUD)
				{
					g2d.translate(x+150,y+150);
					g2d.rotate(Math.toRadians(180));
				}
				else if (this.orientation == Orientation.OUEST)
				{
					g2d.translate(x-150,y+150);
					g2d.rotate(Math.toRadians(270));
				}
				//affichage
				couche.paintIcon(c,g2d,x,y+1);
			}
			else
			{
				//translation
				g2d.translate(x+xAdjustment,y+yAdjustment);
				//rotation
				g2d.rotate(Math.toRadians(90));
				//affichage
				couche.paintIcon(c,g2d,x,y);
			}
			count++;
		}
	}
}