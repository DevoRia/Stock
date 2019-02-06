<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Stock</title>
</head>
<body>
<div class="container">
    <h1>Total: ${sum}</h1>
    <g:each in="${(1..funds.size())}" var="count" >
        <div class="">
            <h2>${funds.get(count - 1).name}</h2>
            ${funds.get(count - 1).sum()}
        </div>
    </g:each>


</div>

</body>
</html>
