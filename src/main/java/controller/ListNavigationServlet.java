package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TicketSales;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		
		TicketSalesHelper dao = new TicketSalesHelper();
		String act = request.getParameter("doThisToList");

		if (act == null) {
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				
				TicketSales saleToDelete = dao.searchForSaleById(tempId);
				dao.deleteSale(saleToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				
				TicketSales saleToEdit = dao.searchForSaleById(tempId);
				request.setAttribute("saleToEdit", saleToEdit);
				
				request.setAttribute("month", saleToEdit.getOrderDate().getMonthValue());
				request.setAttribute("date", saleToEdit.getOrderDate().getDayOfMonth());
				request.setAttribute("year", saleToEdit.getOrderDate().getYear());
				
				EventHelper daoForEvents = new EventHelper();
				
				request.setAttribute("allEvents", daoForEvents.showAllEvents());
				
				if(daoForEvents.showAllEvents().isEmpty()) {
					request.setAttribute("allEvents", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
		
	}

}
