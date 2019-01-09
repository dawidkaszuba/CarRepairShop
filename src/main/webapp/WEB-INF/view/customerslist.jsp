<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista klientów</title>
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

<h3>Dodaj klienta:</h3>
<form action="/AddCustomer" method="post">
    <div class="form-group">
        <label for="name">imię</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="imię">
    </div>
    <div class="form-group">
        <label for="surname">nazwisko</label>
        <input type="text" class="form-control" id="surname" name="surname" placeholder="nazwisko">
    </div>
    <div class="form-group">
        <label for="surname">urodziny</label>
        <input type="date" class="form-control" id="birthday" name="birthday" placeholder="urodziny">
    </div>
    <div class="form-group">
        <label for="email">email</label>
        <input type="email" class="form-control" id="email" name="email">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<div><a href="/FindCustomer">wyszukaj klienta-->></a></div>



<h3>klienci:</h3>
<table class="table">


    <th>imię</th>
    <th>nazwisko</th>
    <th>urodziny</th>
    <th>email</th>
    <th>akcja</th>
    <th>akcja</th>

    <c:forEach items="${customers}" var="customer">

        <tr>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthday}</td>
            <td>${customer.email}</td>
            <td><a href="/DeleteCustomer?id=${customer.id}">usuń</a> / <a href="/EditCustomer?id=${customer.id}">edytuj</a></td>
            <td><a href="/OrdersOfCustomer?id=${customer.id}">zlecenia</a> / <a href="/VehiclesOfCustomer?id=${customer.id}">pojazdy</a></td>
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
