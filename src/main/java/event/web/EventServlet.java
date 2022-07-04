package event.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.EventDAO;
import event.model.Event;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private EventDAO eventDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
    	this.eventDAO = new EventDAO();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertEvent(request, response);
			break;
		case "/delete":
			deleteEvent(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateEvent(request, response);
			break;
		default:
			//handle list
			listEvent(request, response);
			break;
		}
	}
	
	
	private void listEvent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			List<Event> listEvent = eventDAO.selectAllEvent();
			request.setAttribute("listEvent", listEvent);
			RequestDispatcher dispatcher = request.getRequestDispatcher("event-list.jsp");
			dispatcher.forward(request, response);
		}
	
	private void updateEvent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String decoration = request.getParameter("decoration");
		String catering = request.getParameter("catering");
		String transportation = request.getParameter("transportation");
		String sound = request.getParameter("sound");
		String light = request.getParameter("light");
		
		Event event = new Event(id, no, name, decoration, catering, transportation, sound, light);
		try {
			eventDAO.updateEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void deleteEvent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			eventDAO.deleteEvent(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Event existingEvent = eventDAO.selectEvent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("event-form.jsp");
		request.setAttribute("event", existingEvent);
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("event-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertEvent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String decoration = request.getParameter("decoration");
		String catering = request.getParameter("catering");
		String transportation = request.getParameter("transportation");
		String sound = request.getParameter("sound");
		String light = request.getParameter("light");
		Event newEvent = new Event(0, no, name, decoration, catering, transportation, sound, light);
		try {
			eventDAO.insertEvent(newEvent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
}
