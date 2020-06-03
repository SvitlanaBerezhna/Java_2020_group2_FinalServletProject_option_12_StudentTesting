<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="label.index.title"/></title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="WEB-INF/resources/css/style.css">
</head>
<header class="header">
    <div>
        <span>
            <a href="home?action=home"><fmt:message key="link.users.home"/></a>&nbsp;&nbsp;
            <a href="/logout"><fmt:message key="label.index.aboutUs"/></a>&nbsp;
            <a href="/logout"><fmt:message key="label.index.contactUs"/></a>&nbsp;&nbsp;
            <fmt:message key="label.header.hi"/>, ${sessionScope.user.email}!&nbsp;&nbsp;&nbsp;
            <a href="logout"><fmt:message key="label.index.signOut"/></a>
        </span>
    </div>
</header>
