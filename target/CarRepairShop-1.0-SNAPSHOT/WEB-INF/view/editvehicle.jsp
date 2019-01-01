<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>edytuj</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/view/fragments/header.jspf"/>



<h3>edytuj pojazd:</h3>
<form action="/EditVehicle" method="post" id="form">
    <div class="form-group">
        <input type="hidden" class="form-control" id="id" name="id" value="${vehicle.id}">
    </div>
    <div class="form-group">
        <label for="brand">marka</label>
        <input type="text" class="form-control" id="brand" name="brand" value="${vehicle.brand}">
    </div>
    <div class="form-group">
        <label for="model">model</label>
        <input type="text" class="form-control" id="model" name="model" value="${vehicle.model}">
    </div>
    <div class="form-group">
        <label for="yearOfProduction">rok produkcji</label>
        <input type="number" class="form-control" id="yearOfProduction" name="yearOfProduction" value="${vehicle.yearOfProduction}">
    </div>
    <div class="form-group">
        <label for="registrationNumber">numer rejestracyjny</label>
        <input type="text" class="form-control" id="registrationNumber" name="registrationNumber" value="${vehicle.registrationNumber}">
    </div>

    <div class="form-group">
        <label for="nextTechnicalReview">nastepny przegląd</label>
        <input type="date" class="form-control" id="nextTechnicalReview" name="nextTechnicalReview" value="${vehicle.nextTechnicalReview}">
    </div>

    <div class="form-group">
        <label for="idOfOwner">właściciel pojazdu</label>
        <select id="idOfOwner" class="form-control" name="idOfOwner">


                <option  value="${customer.id}">${customer.name}&nbsp${customer.surname}&nbsp${customer.email}</option>

        </select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>


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
