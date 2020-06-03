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
                    <form method="post" action="themeList">
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <br/>
                                    </td>
                                    <td>
                                        <br/>
                                        <h3>
                                            <fmt:message key="link.themes.editTheme"/>
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
                                        <input type="text" name="theme" required
                                               placeholder="<fmt:message key="label.theme.theme"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.theme.themeEn"/> *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="theme_en" required
                                               placeholder="<fmt:message key="label.theme.themeEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.theme.description"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="description"
                                            placeholder="<fmt:message key="label.theme.description"/>">
                                    </td>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.theme.descriptionEn"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="description_en"
                                            placeholder="<fmt:message key="label.theme.descriptionEn"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.theme.time"/>
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="time"
                                            placeholder="<fmt:message key="label.theme.time"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <fmt:message key="label.theme.passingGrade"/>, % *
                                    </td>
                                    <td>
                                        <br/>
                                        <input type="text" name="passing_grade" required
                                            placeholder="<fmt:message key="label.theme.passingGrade"/>">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="hidden" name="action" value="add-theme">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="2">
                                        <br/>
                                        <button type="submit" class="btn btn-success" name="commit" value="Create">
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
