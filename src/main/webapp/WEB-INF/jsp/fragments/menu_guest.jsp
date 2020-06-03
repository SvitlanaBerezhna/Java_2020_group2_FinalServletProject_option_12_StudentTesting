<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${param.lang}">
<head>
    <title><fmt:message key="label.index.title"/></title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="WEB-INF/resources/css/style.css">
</head>
<aside class="left-sidebar1">
    <a href="${pageContext.request.contextPath}/login">login</a>
    <a href="./login">Click here to see servlets</a>
    <a href="${pageContext.request.contextPath}/login.jsp">Login1</a>
    <button class="btn btn-light" onclick="window.location.href='/login'">
        <fmt:message key="label.index.signIn"/>
    </button>
    <button class="btn btn-light" onclick="window.location.href='/registration'">
        <fmt:message key="label.index.register"/>
    </button>
    <img src="resources/images/student_testing.jpg" alt="student testing" height="250" width="250">
</aside>
