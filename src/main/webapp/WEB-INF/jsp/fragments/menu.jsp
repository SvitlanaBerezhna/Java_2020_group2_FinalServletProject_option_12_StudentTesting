<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="label.index.title"/></title>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
    <div class="btn-group" role="group"  >
        <c:if test="${sessionScope.user.role=='admin'}">
            <button type="button" class="btn btn-secondary" onclick="window.location.href='userList'">
                <fmt:message key="label.index.users"/>
            </button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='themeList'">
                <fmt:message key="label.index.themes"/>
            </button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='questionList'">
                <fmt:message key="label.index.questions"/>
            </button>
        </c:if>
        <button type="button" class="btn btn-secondary" onclick="window.location.href='testChoice'">
            <fmt:message key="label.index.tests"/>
        </button>
        <c:if test="${sessionScope.user.role=='admin'}">
            <button type="button" class="btn btn-secondary" onclick="window.location.href='statisticsList'">
                <fmt:message key="label.index.statistics"/>
            </button>
        </c:if>
    </div>
</body>
</html>
