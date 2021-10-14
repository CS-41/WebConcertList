/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 13, 2021
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.TicketSales;


public class TicketSalesHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebConcertList");
	
	public void insertNewTicketSales (TicketSales t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TicketSales>getSales() {
		EntityManager em = emfactory.createEntityManager();
		List<TicketSales> allSales = em.createQuery("SELECT s FROM TicketSales s").getResultList();
		return allSales;
	}
	
	public void deleteSale(TicketSales saleToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TicketSales> typedQuery = 
				em.createQuery("SELECT sale from TicketSales sale where sale.id= :selectedId", TicketSales.class);
		
		//Sub parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", saleToDelete.getId());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		TicketSales result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public TicketSales searchForSaleById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TicketSales found = em.find(TicketSales.class, tempId);
		em.close();
		return found;
	}
	
	public void updateSale(TicketSales toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
