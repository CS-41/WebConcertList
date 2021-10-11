/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 5, 2021
 */
package model;

import java.time.LocalDate;
//Comment, comment,comment.
public class Event {

	private String eventName;
	private LocalDate tripDate;
	private double costPerTicket;
	
	public Event()
	{
		super();
	}

	public Event(String eventName, LocalDate tripDate, double costPerTicket) 
	{
		super();
		this.eventName = eventName;
		this.tripDate = tripDate;
		this.costPerTicket = costPerTicket;
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
	 * @return the tripDate
	 */
	public LocalDate getTripDate() {
		return tripDate;
	}

	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	/**
	 * @return the costPerTicket
	 */
	public double getCostPerTicket() {
		return costPerTicket;
	}

	/**
	 * @param costPerTicket the costPerTicket to set
	 */
	public void setCostPerTicket(double costPerTicket) {
		this.costPerTicket = costPerTicket;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", tripDate=" + tripDate + ", costPerTicket=" + costPerTicket + "]";
	}
	
	
	
	
}
