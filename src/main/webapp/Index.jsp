<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.ttnd.workshop.entities.Loo" %>
<!--page errorPage="Exception.jsp" --> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Public Loo Monitoring</title>
    </head>
    <body>
    <div align="center" style="margin: 0 auto;">
		<h1>
			Welcome to Public Loo Monitoring System !
		</h1>
	</div>
	
	<div id="listLoos" >
		<!--Get the list of loos with their ratings on the side -->
		<%
			try{
			// retrieve your list from the request, with casting 
			List<Loo> loo = (List<Loo>) request.getAttribute("loos");

		%>
	<table border='1' style="width: 100%;">
	<tr><td>S.No.</td><td>State</td><td>City</td><td>Location</td><td>Current Rating</td>
	<td colspan='4'>Rate the Loo</td>
	</tr>
		
		<% 
		for(int i=0;i<loo.size();i++)
		{
		%>
				
				<tr>
				<form method="post" action="RatingController">
				<input type="hidden" value="<%= loo.get(i).getId()%>" name="id"/>
				<td><%=i+1%></td>
	    		<td><%out.println(loo.get(i).getState());%></td>
	    		<td><%out.println(loo.get(i).getCity());%></td>
	            <td><%out.println(loo.get(i).getLocation());%></td>
	            <td><%out.println(loo.get(i).getRating());%></td>
	            <td><input type="radio" name="rating" value="-1">Unclean</td>
	            <td><input type="radio" name="rating" value="0">Neutral</td>
	            <td><input type="radio" name="rating" value="1">Clean</td>
	            <td><input type="submit" name="Submit rating" ></td>
	            </form>
	       
		 	   </tr>
		 	   
  
			 
	  <% 
	 
			 
			 }%>
			  
			</table>
			
	  <% 
			}
			catch(Exception e)
			{
				response.sendRedirect("Exception.jsp");
			}
		
		%>
	</div>


    </body>
</html>