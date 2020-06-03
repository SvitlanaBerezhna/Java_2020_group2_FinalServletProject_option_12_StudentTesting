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
                    <br>
                    <form method="post" action="questionList">
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <br/>
                                    </td>
                                    <td>
                                        <br/>
                                        <h3>
                                            <fmt:message key="link.questions.editQuestion"/>
                                        </h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.theme.theme"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <select name="theme_id">
                                            <c:forEach items="${themeList}" var="theme">
                                                <option ${theme.id == question.theme_id ? 'selected' : ''}
                                                    value="${theme.id}">${theme.theme}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.questions.question"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="question" required value="${question.question}"
                                            placeholder="<fmt:message key="label.questions.question"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.question.questionEn"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="question_en" required value="${question.question_en}"
                                            placeholder="<fmt:message key="label.question.questionEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.results.explanation"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="explanation" value="${question.explanation}"
                                            placeholder="<fmt:message key="label.results.explanation"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.results.explanationEn"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="explanation_en" value="${question.explanation_en}"
                                            placeholder="<fmt:message key="label.results.explanationEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="question_id" value="${question.question_id}">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="action" value="edit-question">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="2">
                                        <br/>
                                        <button type="submit" class="btn btn-success" name="commit" value="update">
                                            <fmt:message key="label.user.submit"/>
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </main>
            </div>
        </div>
    </div>
</body>
</html>
