import java.util.Enumeration;

public enum Orientation
	{
		NORD,
		EST,
		SUD,
		OUEST;

		//getter orientation clockwise
		public Orientation getDroite()
		{
			return values()[(ordinal() + 1) % values().length];
		}

		//getter orientation counterclockwise (add length cause % can return negative)
		public Orientation getGauche()
		{
			return values()[(ordinal() - 1 + values().length) % values().length];
		}
	}