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
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <jsp:include page="../jsp/fragments/header.jsp"/>
    <h3>
        <fmt:message key="label.index.title"/>
    </h3>
    <jsp:include page="../jsp/fragments/menu.jsp"/>
    <br><br><br>
    <table cellpadding="10" cellspacing="0" border="1">
        <thead class="table-dark">
            <tr>
                <th class="text-center">№</th>
                <th class="text-center">Email</th>
                <th class="text-center"><fmt:message key="label.login.password"/></th>
                <th class="text-center"><fmt:message key="label.user.firstName"/></th>
                <th class="text-center"><fmt:message key="label.user.lastName"/></th>
                <th class="text-center"><fmt:message key="label.user.grade"/>,%</th>
                <th class="text-center"><fmt:message key="label.user.roles"/></th>
            </tr>
        </thead>
        <c:forEach items="${userList}" var="user" varStatus="counter">
            <tr>
                <td class="table-warning" align="center">${counter.count}</td>
                <td class="table-warning">${user.email}</td>
                <td class="table-warning">${user.password}</td>
                <td class="table-warning">${user.first_name}</td>
                <td class="table-warning">${user.last_name}</td>
                <td class="table-warning" align="center">${user.grade}</td>
                <td class="table-warning">${user.role}</td>
                <td>
                    <input type="button" class="btn btn-info" value="<fmt:message key="button.edit"/>"
                        onClick='location.href="edit-user?id=${user.id}"'>
                </td>
                <td>
                    <form method="post" action="userList">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete-user"/>
                        <button type="submit" onClick='location.href="delete-user?id=${user.id}"'
                            class="btn btn-danger"><fmt:message key="button.delete"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <input type="button" class="btn btn-success" value="<fmt:message key="link.users.newUser"/>"
        onClick='location.href="add-user"'>
    <br><br><br>
</body>
</html>
