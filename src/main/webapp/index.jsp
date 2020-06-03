<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${param.lang}">
<head>
    <title><fmt:message key="label.index.title"/></title>
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <div class="wrapper">
        <jsp:include page="WEB-INF/jsp/fragments/header_guest.jsp"/>
        <div class="middle1">
            <div class="container1">
                <main class="content1">
                    <h3>
                        <fmt:message key="label.login.login"/>
                    </h3>
                    <form class="formOne" method="get" action="login" name="myForm" onsubmit="return validateForm()">
                        <fieldset>
                            <label>
                                Email * <input name="email" type="text" required placeholder="Email" value=""
                                            autofocus="true"/>
                            </label>
                            <div style = "color : red">
                                ${msg_email}
                            </div>
                            <label>
                                <fmt:message key="label.login.password"/> *
                                <input name="password" required placeholder=<fmt:message key="label.login.password"/>
                                    type="password"/>
                            </label>
                            <div style = "color : red">
                                ${msg_password}
                            </div>
                            <input type="hidden" name="action" value="login">
                            <input type="hidden" name="lang" value="${param.lang}">
                            <br/>
                            <button type="button" class="btn btn-success" onclick="window.location.href='registration'">
                                <fmt:message key="label.registration.title"/>
                            </button>
                            <button type="submit" class="btn btn-primary" name="commit" value="Login">
                                <fmt:message key="button.login.logIn"/>
                            </button>
                            <br><br><br>
                            <div style="color : red">
                                <br><br>
                            </div>
                        </fieldset>
                    </form>
                </main>
            </div>
        </div>
    </div>
</body>
<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
</html>
