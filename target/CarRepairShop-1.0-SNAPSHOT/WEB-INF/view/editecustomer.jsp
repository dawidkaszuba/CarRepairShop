<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>edytuj klienta</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <jsp:include page="/WEB-INF/view/fragments/header.jspf"/>



        <h3>edytuj klienta:</h3>
        <form action="/EditCustomer" method="post" class="row">

            <div class="form-group">
                <input type="hidden" class="form-control" id="id" name="id" value="${customer.id}">
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name">imię</label>
                    <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
                </div>
                <div class="form-group">
                    <label for="surname">nazwisko</label>
                    <input type="text" class="form-control" id="surname" name="surname" value="${customer.surname}">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="birthday">adres</label>
                    <input type="text" class="form-control" id="birthday" name="birthday" value="${customer.birthday}">
                </div>

                <div class="form-group">
                    <label for="email">nr telefonu</label>
                    <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
                </div>
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
    </div>
</body>
</html>
