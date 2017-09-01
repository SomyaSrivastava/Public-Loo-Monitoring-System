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
 * Servlet implementation class UpdateLooController
 */
public class UpdateLooController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLooController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		
		out.print("ID FROM UPDATE :"+id);
		if(request.getParameter("btn-update")!=null)
		{
			notifyUpdateView(id,request,response);
		}
		else if(request.getParameter("btn-delete")!=null)
		{
			notifyDeleteView(id,request,response);
		}
		
	}

	protected void notifyUpdateView(String id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		
		LooDao loodao=new LooDaoImpl();
		Loo loo=loodao.findByID(Integer.parseInt(id));
		out.print("ID FROM UPDATE :"+Integer.parseInt(id));
		request.setAttribute("loo",loo);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateLoo.jsp");
		rd.forward(request, response);		
	}
	
	protected void notifyDeleteView(String id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		
		LooDao loodao=new LooDaoImpl();
		Loo loo=loodao.findByID(Integer.parseInt(id));
		out.print("ID FROM delete :"+Integer.parseInt(id));
		request.setAttribute("loo",loo);
		RequestDispatcher rd = request.getRequestDispatcher("DeleteLoo.jsp");
		rd.forward(request, response);		
	}
	
}
