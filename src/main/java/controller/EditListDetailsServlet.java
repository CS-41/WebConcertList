package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Event;
import model.TicketSales;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TicketSalesHelper tsh = new TicketSalesHelper();
		EventHelper eh = new EventHelper();
		CustomerHelper ch = new CustomerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		TicketSales saleToUpdate = tsh.searchForSaleById(tempId);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");
		Customer newCustomer = ch.findCustomer(customerName);
		
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedEvents = request.getParameterValues("allEventsToAdd");
			List<Event> selectedEventsInList = new ArrayList<Event>();
			
			for (int i = 0; i < selectedEvents.length; i++) {
				System.out.println(selectedEvents[i]);
				Event e = eh.searchForEventById(Integer.parseInt(selectedEvents[i]));
				selectedEventsInList.add(e);
			}
			
			saleToUpdate.setListOfEvents(selectedEventsInList);
		} catch (NullPointerException ex) {
			List<Event> selectedEventsInList = new ArrayList<Event>();
			saleToUpdate.setListOfEvents(selectedEventsInList);
		}
		
		saleToUpdate.setOrderDate(ld);
		saleToUpdate.setCustomer(newCustomer);
		
		tsh.updateSale(saleToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
