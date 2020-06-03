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
    <div class="wrapper">
        <jsp:include page="../jsp/fragments/header.jsp"/>
        <div class="middle1">
            <div class="container1">
                <main class="content1">
                    <h3>
                        <fmt:message key="label.index.title"/>
                    </h3>
                    <jsp:include page="../jsp/fragments/menu.jsp"/>
                    <br><br>
                    <table cellpadding="0" cellspacing="0" border="0">
                        <form class="form-horizontal" method="post" action="check">
                            <c:forEach items="${resultList}" var="result" varStatus="counter">
                                <div ${counter.first ? 'style = "color:blue"' : 'style = "display:none"'}>
                                    <strong>
                                        <h3>
                                            <fmt:message key="label.statistics.test"/>
                                        </h3>
                                    </strong>
                                    <br><br>
                                </div>
                                <h5>
                                    <input type="hidden" value="${result.id}" name="result_id+${counter.count}">
                                        ${counter.count}. ${result.question}
                                </h5>
                                <input type="hidden" value="${result.answers_count}" name="answers_count">
                                <c:forEach items="${result.answers}" var="answer" varStatus="counter">
                                    <p>
                                        <div ${answer.is_correct == 1 ? 'style = "color:green"' : 'style = "color:black"'}>
                                            <c:choose>
                                                <c:when test="${answer.grade == 1}">
                                                    <img src="resources/images/correctAnswer.png"
                                                        alt="correct answer" height="13" width="13">
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="resources/images/incorrectAnswer.png"
                                                        alt="incorrect answer" height="13" width="13">
                                                </c:otherwise>
                                            </c:choose>
                                &nbsp;&nbsp;          <input type="checkbox" disabled
                                                <c:choose>
                                                    <c:when test="${answer.answer == 1}">
                                                        checked="checked"
                                                    </c:when>
                                                </c:choose>
                                                name="answer_${answer.question_id}_${counter.count}"
                                                value="${answer.answer_id}">
                                            ${counter.count}. ${answer.answer_option}
                                        </div>
                                    </p>
                                </c:forEach>
                                <p>
                                    <b>
                                        <fmt:message key="label.results.explanation"/>:
                                    </b> ${result.explanation}
                                </p>
                                <br>
                            </c:forEach>
                        </form>
                    </table>
                    <br><br>
                </main>
            </div>
        </div>
    </div>
</body>
</html>
