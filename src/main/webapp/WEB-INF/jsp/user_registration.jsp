<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
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
        <jsp:include page="fragments/header_guest.jsp"/>
        <div class="middle1">
            <div class="container1">
                <main class="content1">
                    <form method="post" action="">
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <br/>
                                    </td>
                                    <td>
                                        <br/>
                                        <h3>
                                            <fmt:message key="label.registration.title"/>
                                        </h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        Email
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="email" value="" placeholder="Email">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.login.password"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="password" name="password" value=""
                                            placeholder="<fmt:message key="label.login.password"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.firstName"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="first_name" value=""
                                            placeholder="<fmt:message key="label.user.firstName"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.firstNameEn"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="first_name_en" value=""
                                            placeholder="<fmt:message key="label.user.firstNameEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.lastName"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="last_name" value=""
                                            placeholder="<fmt:message key="label.user.lastName"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.lastNameEn"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="last_name_en" value=""
                                            placeholder="<fmt:message key="label.user.lastNameEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="action" value="registration">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="2">
                                        <br/>
                                        <button type="submit" class="btn btn-success" name="commit">
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
