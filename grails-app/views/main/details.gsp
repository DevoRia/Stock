<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Stock</title>
</head>
<body>
<div class="container">
    <a href="<g:createLink controller="main" action="index"/>">
        ${fund?.name}
    </a>
    : ${fund?.sum()}
    <a href="<g:createLink controller="main" action="transaction" params="${[id:fund?.id, isFinal: false]}"/>" >
    Add
    </a>
    <a href="<g:createLink controller="main" action="transaction" params="${[id:fund?.id, isFinal: true]}"/>" >
        Finalize
    </a>
    <a href="<g:createLink controller="main" action="transfer" params="${[id:fund?.id]}"/>" >
        Transfer
    </a>
    <table id="table" class="table table-condensed table-striped table-responsive custom-table">
        <tr>
            <g:sortableColumn property="value" title="Val"/>
            <g:sortableColumn property="timestamp" title="Date"/>
            <g:sortableColumn property="comment" title="Comment"/>
            <g:sortableColumn property="description" title="Desc"/>
            <g:sortableColumn property="twinTransaction" title="With"/>

        </tr>
        <g:render template="transactionList" var="transaction" collection="${transactions}"/>
    </table>

</div>

</body>
</html>