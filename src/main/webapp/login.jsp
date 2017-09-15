<%--
  Created by IntelliJ IDEA.
  User: Sano
  Date: 30.08.2017
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page session="false" %>

<html>
<head>
    <title>Login</title>
</head>
    <body>

        <h1>Login</h1>
        <s:form action="login">
            <s:textfield name="mail" label="Email"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>
