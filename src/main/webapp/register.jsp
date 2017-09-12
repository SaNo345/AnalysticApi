<%--
  Created by IntelliJ IDEA.
  User: Sano
  Date: 30.08.2017
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Register</title>
</head>
    <body>
    <h1>Registration</h1>
      <s:form action="register">
          <s:textfield name="name" label="Your Name"/>
          <s:textfield name="mail" label="Email"/>
          <s:password name="password" label="Password"/>
          <s:submit value="Register"/>
          <s:reset />
      </s:form>
    </body>
</html>
