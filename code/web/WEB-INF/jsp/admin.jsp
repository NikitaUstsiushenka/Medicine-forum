<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.bsuir.medicineforum.database.DrugDao" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <c:url var="url_1" value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${url_1}"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <c:url var="url_2" value="/styles/admin_style.css"/>
    <link rel="stylesheet" href="${url_2}">
    <c:url var="image_url" value="/images/cross.png"/>
    <link rel="icon" href="${image_url}" type="images/x-icon">
    <title><c:out value="Admin"/></title>
</head>
<body>
<div id="modal_add_drug" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><c:out value="Add Medicine"/></h4>
                <button type="button" class="close" data-dismiss="modal">×</button>
            </div>
            <div class="modal-body">
                <form method="post" action="pharmacy">
                    <div class="form-group">
                        <label for="drug_name"><c:out value="Name:"/></label>
                        <input type="text" class="form-control" pattern="[A-Z]{1}[a-zA-Z-]*" name="drug_name"
                               id="drug_name"
                               maxlength="35" placeholder="Enter medicine name" required>
                    </div>
                    <div class="form-group">
                        <label for="drug_name"><c:out value="Substance:"/></label>
                        <input type="text" class="form-control" pattern="[A-Z]{1}[a-zA-Z-]*" name="substance_name"
                               id="substance_name"
                               maxlength="20" placeholder="Enter substance name" required>
                    </div>
                    <div class="form-group">
                        <label for="description1"><c:out value="Description:"/></label>
                        <textarea class="form-control" rows="5" id="description1" name="description"></textarea>
                    </div>
                    <div>
                        <input type="hidden" name="action" value="add_medicine">
                        <input type="submit" class="btn btn-info" value="Add">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="modal_delete_drug" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><c:out value="Delete Medicine"/></h4>
                <button type="button" class="close" data-dismiss="modal">×</button>
            </div>
            <div class="modal-body">
                <c:set var="dao" value="${DrugDao()}"/>
                <c:set var="drugs" value="${dao.select()}"/>
                <c:if test="${drugs.size() != 0}">
                    <form method="post" action="pharmacy">
                        <div class="form-group">
                            <select id="combobox1" class="combobox" name="medicine_name">
                                <c:forEach var="drug" items="${drugs}">
                                    <option value="${drug.getName()}">${drug.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <input type="hidden" name="action" value="delete_medicine">
                            <input type="submit" class="btn btn-info" value="Delete">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><c:out
                                    value="Close"/></button>
                        </div>
                    </form>
                </c:if>
                <c:if test="${drugs.size() == 0}">
                    <div class="form-group">
                        <label><c:out value="List of medicines is empty."/></label>
                    </div>
                    <div>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><c:out
                                value="Close"/></button>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div id="modal_change_drug" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><c:out value="Change Medicine"/></h4>
                <button type="button" class="close" data-dismiss="modal">×</button>
            </div>
            <div class="modal-body">
                <c:set var="dao" value="${DrugDao()}"/>
                <c:set var="drugs" value="${dao.select()}"/>
                <c:if test="${drugs.size() != 0}">
                    <form method="post" action="pharmacy">
                        <div class="form-group">
                            <select id="combobox2" class="combobox" name="medicine_name">
                                <c:forEach var="drug" items="${drugs}">
                                    <option value="${drug.getName()}">${drug.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="description2"><c:out value="Description:"/></label>
                            <textarea class="form-control" rows="5" id="description2" name="description"></textarea>
                        </div>
                        <div>
                            <input type="hidden" name="action" value="change_medicine">
                            <input type="submit" class="btn btn-info" value="Change">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><c:out
                                    value="Close"/></button>
                        </div>
                    </form>
                </c:if>
                <c:if test="${drugs.size() == 0}">
                    <div class="form-group">
                        <label><c:out value="List of medicines is empty."/></label>
                    </div>
                    <div>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><c:out
                                value="Close"/></button>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div id="wrap">
    <header>
        <div class="title"><c:out value="Medicine-forum"/></div>
    </header>
</div>
<main>
    <div id="menu_title"><h2><c:out value="Administrator menu"/></h2></div>
    <div id="show_medicines">
        <form method="get" action="pharmacy">
            <input type="hidden" name="action" value="show_medicines">
            <button class="btn btn-info menu"><c:out value="Show Medicines"/></button>
        </form>
    </div>
    <div id="add_medicine">
        <button class="btn btn-info menu" data-toggle="modal" data-target="#modal_add_drug"
                title="Add medicine in database"><c:out value="Add Medicine"/></button>
    </div>
    <div id="delete_medicine">
        <button class="btn btn-info menu" data-toggle="modal" data-target="#modal_delete_drug"
                title="Delete medicine from database"><c:out value="Delete Medicine"/></button>
    </div>
    <div id="change_medicine">
        <button class="btn btn-info menu" data-toggle="modal" data-target="#modal_change_drug"
                title="Change info about medicine"><c:out value="Change Medicine"/></button>
    </div>
    <div id="logout">
        <form method="post" action="pharmacy">
            <input type="hidden" name="action" value="logout">
            <button class="btn btn-info menu"><c:out value="Logout"/></button>
        </form>
    </div>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<c:url var="script_1" value="https://code.jquery.com/jquery-3.3.1.slim.min.js"/>
<script src="${script_1}"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<c:url var="script_2" value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"/>
<script src="${script_2}"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<c:url var="script_3" value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"/>
<script src="${script_3}"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
