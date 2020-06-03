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
    <h3><fmt:message key="label.index.title"/></h3>
    <jsp:include page="../jsp/fragments/menu.jsp"/>
    <br><br><br>
    <div style="color : blue" }>
        <strong>
            <h3>
                <fmt:message key="label.questions.question"/> - ${question}
            </h3>
        </strong>
    </div>
    <table cellpadding="10" cellspacing="0" border="1">
        <thead class="table-dark">
            <tr>
                <th class="text-center">№</th>
                <th class="text-center">
                    <fmt:message key="link.answers.option"/>
                </th>
                <th class="text-center">
                    <fmt:message key="label.questions.correctAnswer"/>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${answerList}" var="answer" varStatus="counter">
                <tr>
                    <td class="table-warning" align="center">${counter.count}</td>
                    <td class="table-warning">${answer.answer_option}</td>
                    <td class="table-warning" align="center">
                        <c:choose>
                            <c:when test="${answer.is_correct == 1}">
                                <img src="resources/images/correctAnswer.png" alt="correct answer" height="13" width="13">
                            </c:when>
                        </c:choose>
                    </td>
                    <td>
                        <input type="button" class="btn btn-info" value="<fmt:message key="button.edit"/>"
                            onClick='location.href="edit-answer?id=${answer.answer_id}"'>
                    </td>
                    <td>
                        <form method="post" action="answerList">
                            <input type="hidden" name="id" value="${answer.answer_id}"/>
                            <input type="hidden" name="action" value="delete-answer"/>
                            <button type="submit" onClick='location.href="delete-answer?id=${answer.answer_id}"'
                                class="btn btn-danger"><fmt:message key="button.delete"/>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" class="btn btn-success" value="<fmt:message key="link.answers.newAnswer"/>"
        onClick='location.href="add-answer?id=${question_id}"'>
    <br><br><br>
</body>
</html>
