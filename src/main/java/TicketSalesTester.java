import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import controller.CustomerHelper;
import controller.TicketSalesHelper;
import model.Customer;
import model.Event;
import model.TicketSales;

/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 13, 2021
 */

public class TicketSalesTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Customer sam = new Customer("Sam");
		
		//CustomerHelper ch = new CustomerHelper();
		
		//ch.insertCustomer(sam);
		
		Event play = new Event("Theater", "play");
		Event concert = new Event("Theater", "concert");
		
		List<Event> samTickets = new ArrayList<Event>();
		samTickets.add(play);
		samTickets.add(concert);
		
		TicketSalesHelper tsh = new TicketSalesHelper();
		
		TicketSales samSales = new TicketSales(LocalDate.now(), sam);
		samSales.setListOfEvents(samTickets);
		
		tsh.insertNewTicketSales(samSales);
		
		List<TicketSales> allSales = tsh.getSales();
		
		for(TicketSales t : allSales) {
			System.out.println(t.toString());
		}
			
	}

}
