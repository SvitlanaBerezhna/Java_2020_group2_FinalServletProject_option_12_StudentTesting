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
                <th class="text-center"><fmt:message key="label.questions.question"/></th>
                <th class="text-center"><fmt:message key="label.results.explanation"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionList}" var="question" varStatus="counter">
                <div ${counter.first ? 'style = "color:blue"' : 'style = "display:none"'}>
                    <strong>
                        <h3>
                            <fmt:message key="label.statistics.test"/> - ${question.theme}
                        </h3>
                    </strong>
                </div>
                <tr>
                    <td class="table-warning" align="center">${counter.count}</td>
                    <td class="table-warning">${question.theme}</td>
                    <td class="table-warning">${question.question}</td>
                    <td class="table-warning">${question.explanation}</td>
                    <td>
                        <input type="button" class="btn btn-info" value="<fmt:message key="button.edit"/>"
                            onClick='location.href="edit-question?id=${question.question_id}"'>
                    </td>
                    <td>
                        <form method="post" action="questionList">
                            <input type="hidden" name="id" value="${question.question_id}"/>
                            <input type="hidden" name="action" value="delete-question"/>
                            <button type="submit" onClick='location.href="delete-question?id=${question.question_id}"'
                                class="btn btn-danger"><fmt:message key="button.delete"/>
                            </button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="answerList">
                            <input type="hidden" name="id" value="${question.question_id}"/>
                            <input type="hidden" name="question" value="${question.question}"/>
                            <input type="hidden" name="action" value="answerList"/>
                            <button type="submit" onClick='location.href="answerList?id=${question.question_id}"'
                                class="btn btn-primary"><fmt:message key="label.index.answers"/>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" class="btn btn-success" value="<fmt:message key="link.questions.newQuestion"/>"
        onClick='location.href="add-question"'>
    <br><br><br>
</body>
</html>
