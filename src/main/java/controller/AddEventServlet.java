package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String event = request.getParameter("event");
		String eventLocation = request.getParameter("location");
		
		Event li = new Event(event, eventLocation);
		EventHelper dao = new EventHelper();
		dao.insertEvent(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
