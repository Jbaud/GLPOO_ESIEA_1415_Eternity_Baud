import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Piece
{
	private List<String> faces;

	public Piece(List<String> faces)
	{
		this.faces = faces;
	}

	public List<String> getFaces()
	{
		return faces;
	}
}