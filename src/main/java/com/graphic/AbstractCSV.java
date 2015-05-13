public abstract class AbstractCSV
{
	public static final String _separateur = " ";
	public static final String _commentaire = "#";
	
	protected final String separateur;
	protected final String commentaire;
	
	public AbstractCSV(String separateur, String commentaire )
	{
		this.separateur = separateur;
		this.commentaire = commentaire;
		
	}
	
	public final String getSeparateur()
	{
		return separateur;
	}

	public final String getCommentaire()
	{
		return commentaire;
	}
}