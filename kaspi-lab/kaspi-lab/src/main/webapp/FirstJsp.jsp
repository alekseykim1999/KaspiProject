<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 17.05.2020
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <%
        Integer visits = (Integer)session.getAttribute("count");
        if(visits==null)
            visits=1;
    %>
    <h1>Number Of Visits = <%=visits%></h1>
    <% String answer = request.getParameter("user"); %>
    <p>
        <%@ page import="java.util.Date, kz.kaspi.lab.TestClass" %>
        <%@ page import="testing.Cart" %>
        <%@ page import="testing.DataDisplayer" %>
        <%@ page import="java.util.List" %>

        <% TestClass informator = new TestClass(); %>
        <%="Test Page"%>
        <%= new Date()%>
        <%=informator.getData(answer)%>
    </p>
    <% Cart cart = (Cart)session.getAttribute("cart"); %>
    <p>Name of Cart = <%=cart.getName()%></p>
    <p>Qunatity in Cart = <%=cart.getQuantity()%></p>


    <% DataDisplayer displayer = new DataDisplayer();
       displayer.setDataFromServer();
       List<String> information= displayer.getInformation();
       List<String> positions = displayer.getPositions();
       for(String data : information)
           out.println("<h5>" + data + "</h5>");
       out.println("_______________________________");
       for(String position : positions)
           out.println("<h5>" + position + "</h5>");
    %>

</body>
</html>
