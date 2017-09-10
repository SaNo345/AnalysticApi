<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
    <body>
    <s:form action="myAction">
        <s:date name="Inputdate" var="formattedVal"/>
        <s:submit value="OK"></s:submit>
    </s:form>

    </body>
</html>