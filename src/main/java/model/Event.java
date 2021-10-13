/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 5, 2021
 */
package model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Note: Feel free to change things - I've adjusted names based on what I think
//will be easiest to track.

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue
	@Column(name = "EVENTID")
	private int id;
	@Column(name = "EVENTNAME")
	private String eventName;
	//Changed for clarity and updated the getters/setters/toString
	@Column(name = "eventLocation")
	private String eventLocation;
	
	//Based on her notes, I think the cost per ticket can go into the "TicketSales"
	//class - which will combine this class with the "Customer Class".
	//private double costPerTicket;
	
	public Event()
	{
		super();
	}

	public Event(int id, String eventName, String eventLocation) 
	{
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
	}
	
	public Event(String eventName, String eventLocation) 
	{
		super();
		this.eventName = eventName;
		this.eventLocation = eventLocation;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventLocation
	 */
	public String getEventLocation() {
		return eventLocation;
	}

	/**
	 * @param eventLocation the eventLocation to set
	 */
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String returnEventDetails() {
		return this.eventName + ": " + this.eventLocation;
	}
		
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", eventLocation=" + eventLocation + "]";
	}

}
