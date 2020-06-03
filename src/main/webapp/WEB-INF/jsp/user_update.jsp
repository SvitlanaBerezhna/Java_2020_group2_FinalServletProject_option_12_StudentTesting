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
                    <form method="post" action="userList">
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <br/>
                                    </td>
                                    <td>
                                        <br/>
                                        <h3>
                                            <fmt:message key="link.users.editUser"/>
                                        </h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        Email *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="email" value="${user.email}" required
                                            placeholder="Email">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.login.password"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="password" required value="${user.password}"
                                            placeholder="<fmt:message key="label.login.password"/>">
                                    </td>
                                    <td>
                                        <div style = "color:red">
                                            ${msg_password}
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.firstName"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="first_name" required value="${user.first_name}"
                                            placeholder="<fmt:message key="label.user.firstName"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.firstNameEn"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="first_name_en" required value="${user.first_name_en}"
                                            placeholder="<fmt:message key="label.user.firstNameEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.lastName"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="last_name" required value="${user.last_name}"
                                            placeholder="<fmt:message key="label.user.lastName"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.lastNameEn"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="last_name_en" required value="${user.last_name_en}"
                                            placeholder="<fmt:message key="label.user.lastNameEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.grade"/>,%
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="grade" value="${user.grade}"
                                            placeholder="<fmt:message key="label.user.grade"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.user.roles"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="role" value="${user.role}" required
                                            placeholder="<fmt:message key="label.user.roles"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="id" value="${user.id}">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="action" value="edit-user">
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
