/**
* The Event is an abstract class which stores the athlete's name, and their country code. It also
* enforces a method signature called lessThan(Event event) and also setData(double value) to be
* implemented in extending classes; enabling for the application to run polymorphically when comparing events.
* @author Lance Baker (c3128034).
*/
public abstract class Event {
		
	protected String name; // The athlete's name.
	protected String country; // The country of the athlete.
	
	
	public Event(String name, String country) {
		this.name = name;
		this.country = country;
	}	
	
	/**
	* The getter used to retrieve the athlete's name.
	*/
	public String getName() {
		return this.name;
	}
	
	/**
	* The setter used to set the athlete's name.
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* The getter used to retrieve the country code.
	*/
	public String getCountry() {
		return this.country;
	}
	
	/**
	* The setter used to set the country code.
	*/
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	* The lessThan method receives the Event, and compares it with itself.
	* @param Event - The event to be compared with.
	* @return boolean - true if this object is less than or equal to the Event received.
	*/
	public abstract boolean lessThan(Event event) throws OlympicEventException;
	
	/**
	* The setData method is used as a setter to add data to the Event.
	* @param double - The attempt value to be added.
	*/
	public abstract void setData(double value);
	
	/**
	* Enforces the implementation of it's own toString().
	* @return String - A String representation of the Event.
	*/
	public abstract String toString();
}