package application;

public class NoRefereeException extends Exception {

	NoRefereeException()
	{
		super("You need to assign at least one Referee for this game");
	}
}
