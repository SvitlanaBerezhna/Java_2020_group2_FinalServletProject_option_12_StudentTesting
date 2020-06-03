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
    <script src="resources/js/jquery-2.2.2.min.js"></script>
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
                        <form class="form-horizontal" method="post" action="result">
                            <fieldset>
                                <c:forEach items="${questionList}" var="question" varStatus="counter">
                                    <input type="hidden" value="${question.time}" id="time" name="time">
                                    <div ${counter.first ? 'style = "color:blue"' : 'style = "display:none"'}>
                                        <strong>
                                            <h3>
                                                <fmt:message key="label.statistics.test"/> - ${question.theme}
                                            </h3>
                                        </strong>
                                    </div>
                                    <div ${counter.first ? '' : 'style = "display:none"'}>
                                        <span id="timeleft" class="text-right"></span>
                                        <br><br>
                                    </div>
                                    <input type="hidden" value="${question.question_id}" name="question_id_${counter.count}">
                                    <h5>
                                            ${counter.count}. ${question.question}
                                    </h5>
                                    <input type="hidden" value="${question.answers_count}" name="answers_count">
                                    <c:forEach items="${question.answers}" var="answer" varStatus="counter">
                                        <p>
                                            <input type="checkbox" name="answer_${answer.question_id}_${counter.count}"
                                            value="${answer.answer_id}">${counter.count}. ${answer.answer_option}
                                        </p>
                                    </c:forEach>
                                </c:forEach>
                                <input type="hidden" name="action" value="result">
                                <button type="submit" class="btn btn-primary">
                                    <fmt:message key="button.test.finishTest"/>
                                </button>
                            </fieldset>
                        </form>
                    </table>
                    <br><br><br>
                </main>
            </div>
        </div>
    </div>
</body>
<script>
    var x = setInterval(function () {
        myTimer()
    }, 1000);
    var d = document.getElementById("time").getAttribute("value") * 60;
    var min, sec;

    function myTimer() {
        if (d > 0) {
            d--;
            min = parseInt(d / 60);
            sec = parseInt((d / 60 - min) * 59);
            document.getElementById("timeleft").innerHTML = min + " <fmt:message key='label.test.minutes'/> " + sec +
                " <fmt:message key='label.test.secondsLeft'/>";
            if (d < 0) {
                clearInterval(x);
                document.getElementById("timeleft").innerHTML = "expired";
                myFunction()
            }
        }

        function myFunction() {
            alert("Test session expired.\nMoving to the home page...");
            location.replace("home?action=home");
        }
    }
</script>
</html>
