<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title>Login</title>
    <sx:head/>
</head>
    <body>
    <s:form action="downloadDAU">
        <sx:datetimepicker label="Enter DAU day"  name="Inputdate" displayFormat="dd-MM-yyyy" value="${'06-09-2017'}" />
        <s:submit value="Download DAU"></s:submit>
    </s:form>
    <hr>
    <s:url action="reg" var="reg"/>
    <s:a href="%{reg}" >Register</s:a>

    </body>
</html>