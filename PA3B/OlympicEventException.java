/**
* The OlympicEventException is used in the case where a Event instance isn't the right sub-type to be compared. 
* It extends from ClassNotFoundException, and on instantiation it just passes in an error message.
* @author Lance Baker (c3128034).
*/
public class OlympicEventException extends ClassNotFoundException {
	private static final String WRONG_EVENT = "Error: Cannot compare different Events.";
	public OlympicEventException() {
		super(WRONG_EVENT);
	}
}