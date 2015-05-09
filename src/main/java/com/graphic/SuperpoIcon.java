import java.util.*;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class SuperpoIcon extends ImageIcon
{
	private ImageIcon base;
	private List<ImageIcon> couches;

	//Constructeur
	public SuperpoIcon(ImageIcon base)
	{
		super(base.getImage());
		this.base = base;
		this.couches = new ArrayList<ImageIcon>();
	}

	//Ajout d'une couche à la liste
	public void ajoutCouche(ImageIcon couche)
	{
		couches.add(couche);
	}

	@Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y)
	{
		base.paintIcon(c,g,x,y);
		for (ImageIcon icone : couches)
		{
			icone.paintIcon(c,g,x,y);
		}
	}
}