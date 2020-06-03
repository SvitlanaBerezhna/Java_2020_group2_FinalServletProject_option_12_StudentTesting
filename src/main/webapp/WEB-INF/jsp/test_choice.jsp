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
    <form class="form-horizontal" action="test" method="post">
        <div style="color : blue" }>
            <strong>
                <h3>
                    <fmt:message key="label.test.theme"/>:
                </h3>
            </strong>
        </div>
        <h5>
            <select required="required" name="theme_id" id="select">
                <option disabled="disabled" selected="selected">
                    <fmt:message key="label.test.select"/>
                </option>
                <c:forEach items="${themeList}" var="theme">
                    <option value="${theme.id}">
                        ${theme.theme}
                    </option>
                </c:forEach>
            </select>
        </h5>
        <br>
        <h5>
            <fmt:message key="label.testing.rules"/>:
        </h5>
        <ul>
            <li>
                <fmt:message key="label.testing.rule1"/>.
            </li>
            <li>
                <fmt:message key="label.testing.rule2"/>.
            </li>
            <li>
                <fmt:message key="label.testing.rule3"/>.
            </li>
        </ul>
        <br>
        <button type="submit" class="btn btn-primary">
            <fmt:message key="button.startTest"/>
        </button>
        <input type="hidden" name="action" value="test">
    </form>
</body>
</html>
