/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
package controller;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Event;


public class EventHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebConcertList");
	
	public void insertEvent(Event e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Event> showAllEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<Event> allEvents = em.createQuery("SELECT i from Event i").getResultList();
		return allEvents;
	}
	
	
	public void deleteEvent(Event toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Event>typedQuery=em.createQuery("select e from Event e where e.eventName =:selectedEventName and e.eventLocation =:selectedeventLocation", Event.class);
		
		typedQuery.setParameter("selectedEventName", toDelete.getEventName());
		typedQuery.setParameter("selectedeventLocation", toDelete.getEventLocation());
				
		typedQuery.setMaxResults(1);
		
		Event result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
		
	
	public Event searchForEventById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Event found = em.find(Event.class, idToEdit);
		em.close();
		return found;
	}
		
	
	public List<Event> searchForEventByLocation(String eventLocation){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Event>typedQuery = em.createQuery("select e from Event e where e.eventLocation =:selectedeventLocation", Event.class);
		typedQuery.setParameter("selectedeventLocation", eventLocation);
		
		List<Event>foundEvents = typedQuery.getResultList();
		em.close();
		return foundEvents;
	}
	
	public List<Event> searchForEventByEvent(String eventName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Event>typedQuery = em.createQuery("select e from Event e where e.eventName =:selectedEventName", Event.class); 
		typedQuery.setParameter("selectedEventName", eventName);
		
		List<Event>foundEvents = typedQuery.getResultList();
		em.close();
		return foundEvents;
	}
	
	
	public void updateEvent(Event toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
