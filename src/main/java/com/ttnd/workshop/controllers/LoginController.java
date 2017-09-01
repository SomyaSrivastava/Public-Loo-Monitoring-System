package com.ttnd.workshop.controllers;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttnd.workshop.dao.UserDao;
import com.ttnd.workshop.dao.impl.UserDaoImpl;
import com.ttnd.workshop.entities.User;

import com.ttnd.workshop.dao.LooDao;
import com.ttnd.workshop.dao.impl.LooDaoImpl;
import com.ttnd.workshop.entities.Loo;
import java.util.List;
/**
 * Servlet implementation class UserDataServlet
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(uname.isEmpty()||pass.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			
			UserDao userDao=new UserDaoImpl();
			User user=userDao.findByUserNameAndPass(uname, pass);
			if(user!=null)
			{
				HttpSession session = request.getSession();
			    String username =uname;
			    session.setAttribute("uname", username);
				//Create a list of loos
				LooDao looDao=new LooDaoImpl();
				List<Loo> loos=looDao.get();
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				request.setAttribute("loos", loos);
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
				out.println("<font color=red><center>Invalid User!!</center></font>");
				rd.include(request, response);
			}
			
		}
	}

}
