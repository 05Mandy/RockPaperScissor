<%-- 
    Document   : choice_outcome
    Created on : 11 Jun 2024, 4:12:56 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        
        <%
            String playerName = pageContext.getServletContext().getInitParameter("player_name");
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
            Character playerChoice = (Character)request.getAttribute("playerChoice");
            Character computerChoice = (Character)request.getAttribute("computerChoice");
            String outcome = (String)request.getAttribute("outcome");
        %>
        
        <table>
            <tr>
                <td><strong><%=playerName%></strong>: </td>
                <td><%=playerChoice%></td>
            </tr>
            
            <tr>
                <td><strong><%=computerName%></strong>: </td>
                <td><%=computerChoice%></td>
            </tr>
            
             <tr>
                <td><strong>Outcome</strong>: </td>
                <td><%=outcome%></td>
            </tr>
        </table>
            
            <p>
                Please click <a href="choice.jsp">here</a> to continue playing.
                OR <a href="index.html">here</a> to go back to the main page
            </p>
    </body>
</html>
