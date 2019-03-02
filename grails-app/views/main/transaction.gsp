<%@ page import="stock.Transaction" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Stock</title>
</head>
<body>
<div class="container">
    <%
        String action = "income"
        if (isFinal) {
            action = "finalizeMoney"
        }else {
            action = "income"
        }
    %>
    <g:form action="${action}">
        <input name="value" type="number"/>
        <input name="comment"/>
        <input name="fundId" value="${fundId}" />
        <input type="submit"/>
    </g:form>
</div>

</body>
</html>
