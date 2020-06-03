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
                <th class="text-center"><fmt:message key="label.user.firstName"/></th>
                <th class="text-center"><fmt:message key="label.user.lastName"/></th>
                <th class="text-center"><fmt:message key="label.theme.theme"/></th>
                <th class="text-center"><fmt:message key="label.results.correctAnswers"/></th>
                <th class="text-center"><fmt:message key="label.results.totalQuestions"/></th>
                <th class="text-center"><fmt:message key="label.user.grade"/></th>
                <th class="text-center"><fmt:message key="label.statistics.testDate"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${statisticsList}" var="statistics" varStatus="counter">
                <tr>
                    <td class="table-warning" align="center">${counter.count}</td>
                    <td class="table-warning">${statistics.email}</td>
                    <td class="table-warning">${statistics.first_name}</td>
                    <td class="table-warning">${statistics.last_name}</td>
                    <td class="table-warning">${statistics.theme}</td>
                    <td class="table-warning" align="center">${statistics.correct_answers}</td>
                    <td class="table-warning" align="center">${statistics.total_questions}</td>
                    <td class="table-warning" align="center">${statistics.grade}%</td>
                    <td class="table-warning" align="center">${statistics.test_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
