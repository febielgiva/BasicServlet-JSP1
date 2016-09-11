package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.Messaging.SyncScopeHelper;

import model.ToDoList;

/**
 * Servlet implementation class DeleteToDoList
 */
@WebServlet("/DeleteToDoList")
public class DeleteToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteToDoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext con = request.getSession().getServletContext();
//		Integer id =  (Integer) request.getSession().getServletContext().getAttribute("id");
		System.out.println(request.getParameter("id"));
		@SuppressWarnings("unchecked")

		Integer id =Integer.parseInt(request.getParameter("id"));
		List<ToDoList> userDetailslist = (List<ToDoList>) con.getAttribute("userDetailslist");
		if(userDetailslist != null){
		for (ToDoList toDoList : userDetailslist) {
			if((id != null) && (id == toDoList.getId())){
				toDoList.setCheck(false);
			}
		}
		}
		con.setAttribute("userDetailslist",userDetailslist);
		response.sendRedirect("DisplayToDoList.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("DisplayToDoList.jsp");
		doGet(request, response);
	}

}