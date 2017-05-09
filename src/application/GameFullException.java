package application;

public class GameFullException extends Exception {

	public GameFullException()
	{
		super("Cannot add more than 8 participants");
	}
}
