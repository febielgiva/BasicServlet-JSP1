package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ToDoList;

/**
 * Servlet implementation class DisplayToDoList
 */
@WebServlet("/DisplayToDoList")
public class DisplayToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayToDoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		List<ToDoList> userDetailslist = new ArrayList<ToDoList>();
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			userDetailslist.add(new ToDoList("Take out trash",format.parse("8/28/2016"),true));
			userDetailslist.add(new ToDoList("Buy milk",format.parse("8/26/2016"),true));
			userDetailslist.add(new ToDoList("Watch \"Suicide Squad\"",format.parse("8/20/2016"),true));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config.getServletContext().setAttribute("userDetailslist",userDetailslist); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendRedirect("DisplayToDoList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("item");
		ServletContext con = request.getSession().getServletContext();
		if(value !=null){
			List<ToDoList> userDetailslist = (List<ToDoList>) con.getAttribute("userDetailslist");
			//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			userDetailslist.add(new ToDoList(value,(new Date()),true));
			con.setAttribute("userDetailslist",userDetailslist);
		}
		doGet(request, response);
	}

}