package application;

public class TooFewAthleteException extends Exception {

	TooFewAthleteException()
	{
		super("Select a least 4 participants for this game");
	}
}
