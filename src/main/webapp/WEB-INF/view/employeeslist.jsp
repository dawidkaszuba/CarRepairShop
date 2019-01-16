<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista pracowników</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        span{
            font-weight: bold;
        }

    </style>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <jsp:include page="/WEB-INF/view/fragments/header.jspf"/>


        <h3>pracownicy:</h3>

        <c:forEach items="${employees}" var="employee">
            <hr style="border-width: 4px">

        <div class="row">
               <div class="col-md-6">

                    <div><p><span>imię i nazwisko</span><br>${employee.name}&nbsp${employee.surname}</p></div>
                    <div><p><span>adres</span><br>${employee.address}</p></div>
                    <div><p><span>numer telefonu</span><br>${employee.phoneNumber}</p></div>
               </div>
               <div class="col-md-6">
                    <div><p><span>uwagi</span><br>${employee.note}</p></div>
                    <div><p><span>koszt robocizny</span><br>${employee.costOfWorkHour}</p></div>
                    <div><p><span>akcja</span><br><a href="/DeleteEmployee?id=${employee.id}">usuń</a> /
                        <a href="/EditEmployee?id=${employee.id}">edytuj</a> /
                        <a href="CurrentOrders?id=${employee.id}">aktualne zlecenia</a></p></div>
               </div>
        </div>

            </c:forEach>




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
