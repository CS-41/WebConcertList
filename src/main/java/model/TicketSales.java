/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 13, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TicketSales {
	@Id
	@GeneratedValue
	private int id;
	
	private LocalDate orderDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Event>listOfEvents;
	
	public TicketSales() {
		super();
	}
	
	public TicketSales(int id, LocalDate orderDate, Customer customer, List<Event>listOfEvents) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.customer = customer;
		this.listOfEvents = listOfEvents;
	}
	
	public TicketSales(LocalDate orderDate, Customer customer, List<Event>listOfEvents) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
		this.listOfEvents = listOfEvents;
	}
	
	public TicketSales(LocalDate orderDate, Customer customer) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
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
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the listOfEvents
	 */
	public List<Event> getListOfEvents() {
		return listOfEvents;
	}

	/**
	 * @param listOfEvents the listOfEvents to set
	 */
	public void setListOfEvents(List<Event> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}

	@Override
	public String toString() {
		return "TicketSales [id=" + id + ", orderDate=" + orderDate + ", customer=" + customer + ", listOfEvents="
				+ listOfEvents + "]";
	}
	
}
