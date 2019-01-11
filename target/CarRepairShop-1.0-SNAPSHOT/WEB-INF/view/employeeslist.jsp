<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista pracowników</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/view/fragments/header.jspf"/>

<h3>Dodaj pracownika:</h3>
<form action="/AddEmployee" method="post">
    <div class="form-group">
        <label for="name">imię</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="imię">
    </div>
    <div class="form-group">
        <label for="surname">nazwisko</label>
        <input type="text" class="form-control" id="surname" name="surname" placeholder="nazwisko">
    </div>
    <div class="form-group">
        <label for="address">adres</label>
        <input type="text" class="form-control" id="address" name="address" placeholder="ulica, nr budynku, kod pocztowy, miejscowość">
    </div>

    <div class="form-group">
        <label for="phoneNumber">nr telefonu</label>
        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="nr tel">
    </div>

    <div class="form-group">
        <label for="note">uwagi</label>
        <input type="textarea" class="form-control" id="note" name="note" placeholder="uwagi...">
    </div>

    <div class="form-group">
        <label for="costOfWorkHour">koszt roboczogodziny</label>
        <input type="text" class="form-control" id="costOfWorkHour" name="costOfWorkHour">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<h3>pracownicy:</h3>
<table class="table">


    <th>imię</th>
    <th>nazwisko</th>
    <th>adres</th>
    <th>numer telefonu</th>
    <th>uwagi</th>
    <th>koszt robocizny</th>
    <th>akcja</th>
    <th>akcja</th>

    <c:forEach items="${employees}" var="employee">

        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.address}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.note}</td>
            <td>${employee.costOfWorkHour}</td>
            <td><a href="/DeleteEmployee?id=${employee.id}">usuń</a> / <a href="/EditEmployee?id=${employee.id}">edytuj</a></td>
            <td><a href="CurrentOrders?id=${employee.id}">aktualne zlecenia</a> / <a href="/GetWorkHoursEmployee?id=${employee.id}">pokaż roboczogodziny</a></td>
        </tr>

    </c:forEach>


</table>


<jsp:include page="/WEB-INF/view/fragments/footer.jspf"/>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>
