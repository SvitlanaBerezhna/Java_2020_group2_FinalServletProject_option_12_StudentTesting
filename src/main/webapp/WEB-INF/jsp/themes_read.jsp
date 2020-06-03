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
                <th class="text-center"><fmt:message key="label.theme.theme"/></th>
                <th class="text-center"><fmt:message key="label.theme.description"/></th>
                <th class="text-center"><fmt:message key="label.theme.time"/></th>
                <th class="text-center"><fmt:message key="label.theme.passingGrade"/>, %</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${themeList}" var="theme" varStatus="counter">
                <tr>
                    <td class="table-warning" align="center">${counter.count}</td>
                    <td class="table-warning">${theme.theme}</td>
                    <td class="table-warning">${theme.description}</td>
                    <td class="table-warning" align="center">${theme.time}</td>
                    <td class="table-warning" align="center">${theme.passing_grade}</td>
                    <td>
                        <input type="button" class="btn btn-info" value="<fmt:message key="button.edit"/>"
                            onClick='location.href="edit-theme?id=${theme.id}"'>
                    </td>
                    <td>
                        <form method="post" action="themeList">
                            <input type="hidden" name="id" value="${theme.id}"/>
                            <input type="hidden" name="action" value="delete-theme"/>
                            <button type="submit" onClick='location.href="delete-theme?id=${theme.id}"'
                                class="btn btn-danger"><fmt:message key="button.delete"/>
                            </button>
                        </form>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href='questionList?id=${theme.id}'">
                                <fmt:message key="label.index.questions"/>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" class="btn btn-success" value="<fmt:message key="link.themes.newTheme"/>"
        onClick='location.href="add-theme"'>
    <br><br><br>
</body>
</html>
