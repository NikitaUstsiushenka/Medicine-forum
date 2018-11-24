<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.bsuir.medicineforum.database.DrugDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <c:url var="url_1" value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${url_1}"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <c:url var="url_2" value="/styles/main_style.css"/>
    <link rel="stylesheet" href="${url_2}">
    <c:url var="url_3" value="/styles/table_style.css"/>
    <link rel="stylesheet" href="${url_3}"/>
    <c:url var="image_url" value="/images/cross.png"/>
    <link rel="icon" href="${image_url}" type="images/x-icon">
    <title><c:out value="Medicine-forum"/></title>
</head>
<body>
<div id="wrap">
    <header>
        <div class="title"><c:out value="Medicine-forum"/></div>
        <form method="post" action="pharmacy">
            <div class="input-form">
                <div class="input-group">
                    <input type="hidden" name="action" value="search_medicine">
                    <input type="text" title="Enter name of the medicine" class="form-control"
                           pattern="[A-Z]{1}[a-zA-Z-]*" name="drug_name" maxlength="35"
                           placeholder="Name of the medicine" required>
                    <div class="input-group-btn">
                        <button title="Search medicine" class="btn btn-info" type="submit">Search</button>
                    </div>
                </div>
            </div>
        </form>
    </header>
</div>
<main>
    <div id="button_back">
        <form action="pharmacy" method="post">
            <input type="hidden" name="action" value="back_user">
            <button class="btn btn-info" title=""><c:out value="Back"/></button>
        </form>
    </div>
    <div id="button_all">
        <form action="pharmacy" method="post">
            <input type="hidden" name="action" value="all">
            <button title="Show all medicines" class="btn btn-info"><c:out value="All"/></button>
        </form>
    </div>
    <div id="basic_content">
        <c:set var="dao" value="${DrugDao()}"/>
        <c:set var="start_drugs" value="${dao.select()}"/>
        <table class="table_blur">
            <thead>
            <tr>
                <th><c:out value="Name"/></th>
                <th><c:out value="Description"/></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${drugs == null}">
            <c:forEach var="drug" items="${start_drugs}">
            <tr>
                <td><c:out value="${drug.getName()}"/></td>
                <td><c:out value="${drug.getDescription()}"/></td>
            </tr>
            </c:forEach>
            </c:if>
            <c:if test="${drugs != null}">
            <c:forEach var="drug" items="${drugs}">
            <tr>
                <td><c:out value="${drug.getName()}"/></td>
                <td><c:out value="${drug.getDescription()}"/></td>
            </tr>
            </c:forEach>
            </c:if>
        </table>
    </div>
</main>
</body>
</html>