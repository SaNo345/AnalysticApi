<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Index</title>
    <sx:head/>
</head>
    <body>
    <s:form action="downloadDAU">
        <sx:datetimepicker label="Enter DAU day"  name="Inputdate" displayFormat="dd-MM-yyyy" value="${'06-09-2017'}" />
        <s:submit value="Download DAU"></s:submit>
    </s:form>
    <hr>
    <s:url action="register" var="reg"/>
    <s:url action="login" var="log"/>
    <s:url action="logout" var="logOut"/>
    <s:a href="%{reg}" >Registration</s:a>
    <s:a href="%{log}"> Login</s:a>
    <s:a href="%{logOut}">Logout</s:a>
    </body>
</html>