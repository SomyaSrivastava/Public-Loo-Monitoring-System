<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!--     page errorPage="Exception.jsp"  -->
<%@ page import="com.ttnd.workshop.entities.Loo" %>
<%@ page import="com.ttnd.workshop.dao.LooDao" %>    
<%@ page import="com.ttnd.workshop.dao.impl.LooDaoImpl" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update loo's information</title>
</head>
<body>

<%
if(session.getAttribute("uname")==null)
{
		response.sendRedirect("index.jsp");
}

		Loo loo=(Loo)request.getAttribute("loo");

%>

<form method="post" action="UpdateDataLooController">
            <center> 
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Update Loo's Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Loo Id</td>
                        <td><input type="text" name="id" value=" <%=loo.getId()%>"  disabled/></td>
                    </tr>
                     <tr>
                        <td>State</td>
                        <td><input type="text" name="state" value="<%= loo.getState() %>" /></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" value="<%= loo.getCity() %>" /></td>
                    </tr>
                    <tr>
                        <td>Area</td>
                        <td><input type="text" name="area" value="<%= loo.getArea() %>" /></td>
                    </tr>
                    <tr>
                        <td>Location</td>
                        <td><input type="text" name="location" value="<%= loo.getLocation() %>" /></td>
                    </tr>
                   <input type="hidden" name="lid" value="<%=loo.getId()%>" />
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                   
                </tbody>
            </table>
            </center>
            
        </form>

</body>
</html>