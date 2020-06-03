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
                    <div style="color:blue" }>
                        <strong>
                            <h3>
                                <fmt:message key="label.questions.question"/> - ${question}
                            </h3>
                        </strong>
                    </div>
                    <form method="post" action="answerList">
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <br/>
                                    </td>
                                    <td>
                                        <br/>
                                        <h3>
                                            <fmt:message key="link.answers.editAnswer"/>
                                        </h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="link.answers.option"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="answer_option" required value="${answer.answer_option}"
                                            placeholder="<fmt:message key="link.answers.option"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="link.answers.optionEn"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="answer_option_en" required value="${answer.answer_option_en}"
                                            placeholder="<fmt:message key="link.answers.optionEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <input type="checkbox"  id="is_correct" name="is_correct"
                                               value="1" ${answer.is_correct == 1 ? 'checked' : ''}>
                                               <fmt:message key="label.questions.correctAnswer"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="answer_id" value="${answer.answer_id}">
                                        <input type="hidden" name="question_id" value="${answer.question_id}">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="action" value="edit-answer">
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
