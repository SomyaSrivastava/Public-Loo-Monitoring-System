package com.ttnd.workshop.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttnd.workshop.dao.LooDao;
import com.ttnd.workshop.dao.impl.LooDaoImpl;
import com.ttnd.workshop.entities.Loo;

/**
 * Servlet implementation class AddLooController
 */
public class AddLooController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLooController() {
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
		//doGet(request, response);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String state = request.getParameter("state");
		String location = request.getParameter("location");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String uname = request.getParameter("uname");
		
		if(state.isEmpty()||location.isEmpty()||city.isEmpty()||area.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("addLoo.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			Loo loo=new Loo();
			loo.setArea(area);
			loo.setCity(city);
			loo.setLocation(location);
			loo.setState(state);
			
			LooDao looDao=new LooDaoImpl();
			looDao.save(loo);
			
			
			List<Loo> loos=looDao.get();
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			request.setAttribute("loos", loos);
			rd.forward(request, response);

			//response.sendRedirect("Welcome.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp?uname="+uname);
			
		    //rd.forward(request, response);
			
		    //rd.include(request, response);
			out.println("<font color=red>Loo added Successfully!!</font>");
			
		}
		
		
	}

}
