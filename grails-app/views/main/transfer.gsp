<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Stock</title>
</head>
<body>
<div class="container">
    <g:form action="transferTo">
        <input name="value" type="number" step="0.01"/>
        <input name="comment"/>
        <input name="anotherFund" value="${fundId}" />
        <input name="fundId" value="${fundId}" />
        <input type="submit"/>
    </g:form>
</div>

</body>
</html>
