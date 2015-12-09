<%-- 
    Document   : index
    Created on : 2/Dez/2015, 1:47:31
    Author     : monkey_001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	org.me.test.CalculatorWS_Service service = new org.me.test.CalculatorWS_Service();
	org.me.test.CalculatorWS port = service.getCalculatorWSPort();
	 // TODO initialize WS operation arguments here
	int i = 3;
	int j = 4;
	// TODO process result here
	int result = port.add(i, j);
	out.println("Result = "+result);
    } catch (Exception ex) {
	out.println("exception:" + ex);
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
