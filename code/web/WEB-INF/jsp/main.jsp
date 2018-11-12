<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <c:url var="url_1" value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${url_1}"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <c:url var="url_2" value="/styles/index_style.css"/>
    <link rel="stylesheet" href="${url_2}">
    <c:url var="url_3" value="/styles/table_style.css"/>
    <link rel="stylesheet" href="${url_3}">
    <c:url var="image_url" value="/images/cross.png"/>
    <link rel="icon" href="${image_url}" type="images/x-icon">
    <title><c:out value="Online-pharmacy"/></title>
</head>
<body>
<div id="modal_registration" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><c:out value="Registration"/></h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <form method="post" action="pharmacy">
                    <div class="form-group">
                        <label for="user_name"><c:out value="First Name:"/></label>
                        <input type="text" class="form-control" pattern="[A-Z]{1}[a-z]*" name="user_name" id="user_name"
                               maxlength="30" placeholder="Enter first name" required>
                    </div>
                    <div class="form-group">
                        <label for="user_lastname"><c:out value="Last Name:"/></label>
                        <input type="text" class="form-control" pattern="[A-Z]{1}[a-z]*" name="user_lastname"
                               id="user_lastname" maxlength="50" placeholder="Enter last name" required>
                    </div>
                    <div class="form-group">
                        <label for="user_email"><c:out value="E-mail:"/></label>
                        <input type="email" class="form-control" name="email" id="user_email" maxlength="264"
                               placeholder="Enter e-mail" required>
                    </div>
                    <div class="form-group">
                        <label for="user_password"><c:out value="Password:"/></label>
                        <input type="password" class="form-control" name="password" id="user_password" minlength="8"
                               maxlength="64" placeholder="Enter password" required>
                    </div>
                    <div class="form-group">
                        <label for="user_repeat"><c:out value="Repeat password:"/></label>
                        <input type="password" class="form-control" name="repeat_pas" id="user_repeat" minlength="8"
                               maxlength="64" placeholder="Enter repeat password" required>
                    </div>
                    <div>
                        <input type="hidden" name="action" value="registration">
                        <input type="submit" class="btn btn-info" value="Registration">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="modal_signin" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><c:out value="Sign in"/></h4>
                <button type="button" class="close" data-dismiss="modal">×</button>
            </div>
            <div class="modal-body">
                <form method="post" action="pharmacy">
                    <div class="form-group">
                        <label for="email"><c:out value="Email:"/></label>
                        <input type="email" class="form-control" name="email" id="email" maxlength="264"
                               placeholder="Enter email" required>
                    </div>
                    <div class="form-group">
                        <label for="us_password"><c:out value="Password:"/></label>
                        <input type="password" class="form-control" name="password" id="us_password" minlength="8"
                               maxlength="64" placeholder="Enter password" required>
                    </div>
                    <div>
                        <input type="hidden" name="action" value="signin">
                        <input type="submit" class="btn btn-info" value="Sign in">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="wrap">
    <header>
        <div class="title"><c:out value="Medicine-forum"/></div>
        <div class="btn-group">
            <button type="button" title="Show pills" class="btn btn-info" data-toggle="modal"
                    data-target="#modal_signin"><c:out value="Pills"/>
            </button>
            <button type="button" title="Show solutions">
                <c:out value="Solution"/>
            </button>
            <button type="button" title="Show ointments">
                <c:out value="Ointment"/>
            </button>
            <button type="button" title="Show drops">
                <c:out value="Drops"/>
            </button>
            <button type="button" title="Show syrups">
                <c:out value="Syrup"/>
            </button>
        </div>
        <form method="post" action="pharmacy">
            <div class="input-form">
                <div class="input-group">
                    <input type="hidden" name="action" value="search_unknown">
                    <input type="text" title="Enter name of the medicine" class="form-control"
                           pattern="[A-Z]{1}[a-zA-Z-]*" name="drug_name" maxlength="35"
                           placeholder="Name of the medicine" required>
                    <div class="input-group-btn">
                        <button title="Search medicine" class="btn btn-info" type="submit">Search</button>
                    </div>
                </div>
                <div class="checkbox">
                    <label style="color: white"><input type="checkbox" name="checkbox" value="true"><c:out
                            value=" Including analogues"/></label>
                </div>
            </div>
        </form>
    </header>
</div>
<main>
    <div id="basic_content">
        <c:set var="dao" value="${DrugDao()}"/>
        <c:set var="start_drugs" value="${dao.selectAll()}"/>
        <table class="table_blur">
            <thead>
            <tr>
                <th><c:out value="Name"/></th>
                <th><c:out value="Form of issue"/></th>
                <th><c:out value="Company/Country"/></th>
                <th><c:out value="Substance"/></th>
                <th><c:out value="Recipe"/></th>
                <th><c:out value="Price"/></th>
                <th><c:out value="Count"/></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${drugs == null}">
                <c:forEach var="element" items="${start_drugs}">
                    <tr>
                        <td><c:out value="${element.getDrugName()}"/></td>
                        <td><c:out value="${element.getType()} ${element.getDosage()}Mg"/></td>
                        <td><c:out value="${element.getCompany()}/${element.getCompanyCountry()}"/></td>
                        <td><c:out value="${element.getSubstance().getName()}"/></td>
                        <td>
                            <c:if test="${element.isRequiredRecipe() == true}">
                                <c:out value="Yes"/>
                            </c:if>
                            <c:if test="${element.isRequiredRecipe() == false}">
                                <c:out value="No"/>
                            </c:if>
                        </td>
                        <td><c:out value="${element.getPrice()}"/></td>
                        <td><c:out value="${element.getDrugsCount()}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${drugs != null}">
                <c:forEach var="element" items="${drugs}">
                    <tr>
                        <td><c:out value="${element.getDrugName()}"/></td>
                        <td><c:out value="${element.getType()} ${element.getDosage()}Mg"/></td>
                        <td><c:out value="${element.getCompany()}/${element.getCompanyCountry()}"/></td>
                        <td><c:out value="${element.getSubstance().getName()}"/></td>
                        <td>
                            <c:if test="${element.isRequiredRecipe() == true}">
                                <c:out value="Yes"/>
                            </c:if>
                            <c:if test="${element.isRequiredRecipe() == false}">
                                <c:out value="No"/>
                            </c:if>
                        </td>
                        <td><c:out value="${element.getPrice()}"/></td>
                        <td><c:out value="${element.getDrugsCount()}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>