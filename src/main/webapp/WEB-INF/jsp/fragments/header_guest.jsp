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
<header class="header">
    <div>
        <span>
            <a href="?lang=ua"><img src="resources/images/langUa.png" width="25" height="25" border="0" alt="lang ua"></a>
            <a href="?lang=en"><img src="resources/images/langEn.png" width="25" height="25" border="0" alt="lang en"></a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/"><fmt:message key="link.users.home"/></a>&nbsp;&nbsp;
            <a href="/logout"><fmt:message key="label.index.aboutUs"/></a>&nbsp;
            <a href="/logout"><fmt:message key="label.index.contactUs"/></a>&nbsp;&nbsp;
            <fmt:message key="label.header.hi"/>, <fmt:message key="label.header.guest"/>!
         </span>
    </div>
</header>
