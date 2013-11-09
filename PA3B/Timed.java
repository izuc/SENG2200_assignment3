/**
* The Timed class extends Event and also implements Comparable<Timed>. It stores the 
* timed attempt as a singular double value, allowing only one attempt, and implements
* the lessThan method (which uses the compareTo). It also implements the setData method 
* which behaves as a setter for the time attribute.
* @author Lance Baker (c3128034).
*/

public class Timed extends Event implements Comparable<Timed> {
	private static final String SPACE = " ";
	private double time;
	
	/**
	* The constructor accepts the athelete's name and country code. It will then
	* pass that data to the super constructor. It then sets the time attribute to -1,
	* which indicates it doesn't have a value.
	*/
	public Timed(String name, String country) {
		super(name, country);
		this.time = -1;
	}
	
	/**
	* The getter for the time attempt.
	*/
	public double getTime() {
		return this.time;
	}
	
	/**
	* The setter for the time attempt.
	*/
	public void setData(double value) {
		this.time = value;
	}
	
	/**
	* The compareTo method receives the Timed event, and compares the received object against itself.
	* If the time on both objects actually has a value than it just compares which one is greater. Otherwise,
	* if both objects are not set, or foul attempts, then they are both the same. A foul attempt is better than
	* a not set value, and a value exceeds both of them.
	* @param Timed - The Timed event that will be compared.
	* @return int - Returns 1 if the param is better, -1 if the object is better, and 0 if they are the same.
	*/
	public int compareTo(Timed event) {
		// If both values are greater than 0, then they can be compared as normal.
		if ((this.getTime() > 0) && (event.getTime() > 0)) {
			return ((this.getTime() < event.getTime()) ? -1 : (this.getTime() > event.getTime()) ? 1 : 0);
		// Otherwise, if both values are not set or foul attempts.
		} else if (((this.getTime() == -1) && (event.getTime() == -1)) 
					|| ((this.getTime() == 0) && (event.getTime() == 0))) {
			return 0; // Both the same.
		} else {
			// If the object is not set and the param is a foul.
			if ((this.getTime() == -1) && (event.getTime() == 0)) {
				return 1; // The param is better.
			// If the object is a foul and the param is not set.
			} else if ((this.getTime() == 0) && (event.getTime() == -1)) {
				return -1; // The object is better.
			// Otherwise, the one that isn't a foul or a not set value is better.
			} else {
				return (((this.getTime() == -1) || (this.getTime() == 0)) ? 1
						: ((event.getTime() == -1) || (event.getTime() == 0)) ? -1 : 0);
			}
		}		
	}
	
	/**
	* The lessThan method receives the Event, and compares it with itself.
	* @return boolean - true if this object is less than or equal to the Event received.
	*/
	public boolean lessThan(Event event) throws OlympicEventException {
		if (event instanceof Timed) {
			return (this.compareTo((Timed)event) >=0);
		} else {
			throw new OlympicEventException();
		}
	}
	
	/**
	* The toString method provides a formatted String of the Event contents.
	*/
	public String toString() {
		// A StringBuilder is used to gather the output.
		StringBuilder builder = new StringBuilder();
		char[] name = this.name.toCharArray(); // Converts the name to the char array.
		for (int i = 0; i < 15; i++) { // Iterates until 15.
			// If it's not out of bounds, it appends the char element. 
			// Otherwise appends a space.
			builder.append((i < name.length) ? name[i] : SPACE);
		}
		builder.append(SPACE);
		builder.append(this.country); // Appends the country code.
		builder.append(SPACE);
		builder.append(String.format("%7.2f", this.getTime()));
		builder.append(SPACE);
		return builder.toString(); // Returns the built String.
	}

}