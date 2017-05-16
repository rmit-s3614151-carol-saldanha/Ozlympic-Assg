package application;

/**
 * 
 * @author Carol Benita Saldanha
 * @version 1.0
 * @superclass Exception
 * @ClassDescription TooFewAthleteException displays custom made exception if
 *                   there are not a minimum of 4 athletes
 *
 */
public class TooFewAthleteException extends Exception {

	public TooFewAthleteException() {
		super("Select a least 4 participants for this game");
	}
}
