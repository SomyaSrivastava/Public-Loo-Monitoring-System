<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ttnd.workshop.entities.Loo" %>
<%@ page errorPage="Exception.jsp" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Public Loo Monitoring System</title>
<style>
table#nat {
	width: 50%;
	background-color: #c48ec5;
}
</style>

</head>
<body>
	<%
	if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("index.jsp");
		}
	%>
	<div align="right" style=" margin: 0 auto; float: right;">
		<h3><%=session.getAttribute("uname")%>'s Dashboard</h3>	
	</div>
		<div id="addLoo" style="float:right">
		<a href="addLoo.jsp?uname=<%=session.getAttribute("uname")%>" target="_self">Add Loo</a>
	</div>
	<div align="center" style="margin: 0 auto;">
		<h1>
			Welcome to Public Loo Monitoring System !
		</h1>
	</div>
	
	
	<div id="listLoos">
		<!--Get the list of loos with their ratings on the side -->
		<%
			try{
			// retrieve your list from the request, with casting 
			List<Loo> loo = (List<Loo>) request.getAttribute("loos");

		%>
	
	<center>
	<table border='1'>
	<tr><td>S.No.</td><td>State</td><td>City</td><td>Location</td><td>Rating</td></tr>
		
		<% 
			for(int i=0;i<loo.size();i++) 
			 {
		%>
				<form method="post" action="UpdateLooController">
				<tr>
				<td><%=i+1%></td>
	    		<td><%out.println(loo.get(i).getState());%></td>
	    		<td><%out.println(loo.get(i).getCity());%></td>
	            <td><%out.println(loo.get(i).getLocation());%></td>
	            <td><%out.println(loo.get(i).getRating());%></td>
		 	    <td><input type="submit" name="btn-update" value="Update"/></td>
		 	    <td><input type="submit" value="Delete" name="btn-delete"/></td>
		 	    <input type="hidden" name="id" value="<%=loo.get(i).getId()%>"/>
				
		 	   </tr>
		 	   </form>
			 
	  <% }%>
			  
			</table>
	  <% 
			}
			catch(Exception e)
			{
				response.sendRedirect("Exception.jsp");
			}
		
		%>
	</div>
 </center>

	
	
</body>
</html>