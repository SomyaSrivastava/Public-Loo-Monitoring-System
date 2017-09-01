package com.ttnd.workshop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ttnd.workshop.dao.LooDao;
import com.ttnd.workshop.dao.impl.LooDaoImpl;

/**
 * Servlet implementation class RatingController
 */
public class RatingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		LooDao loodao=new LooDaoImpl();
		int rating=Integer.parseInt(request.getParameter("rating"));
		int id=Integer.parseInt(request.getParameter("id"));
		
		loodao.setRating(id,rating);
		
		response.sendRedirect("PublicViewController");
		
	}

}
