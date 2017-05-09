package application;

public class WrongTypeException extends Exception {

	WrongTypeException()
	{
		super("Athlete assigned to a wrong game");
	}
}
