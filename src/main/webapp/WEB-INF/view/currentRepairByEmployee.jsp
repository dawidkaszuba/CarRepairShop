<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>w naprawie</title>
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

<h3>w naprawie:</h3>
<table class="table">


    <th>Data przyjęcia do naprawy</th>
    <th>Planowana data rozpoczęcia naprawy</th>
    <th>Data rozpoczęcia naprawy</th>
    <th>Przypisany do naprawy pracownik</th>
    <th>Opis problemu</th>
    <th>Status</th>
    <th>Pojazd którego dotyczy naprawa</th>
    <th>Koszt naprawy dla klienta</th>
    <th>Koszt wykorzystanych części</th>
    <th>Koszt roboczogodziny</th>
    <th>Ilość roboczogodzin</th>
    <th>klient</th>




    <c:forEach items="${orders}" var="order">

        <tr>
            <td>${order.dateOfAcceptanceForRepair}</td>
            <td>${order.plannedRepairDate}</td>
            <td>${order.startedDateOfRepair}</td>
            <td>${order.idOfEmployee}</td>
            <td>${order.descriptionOfProblem}</td>
            <td>${order.status}</td>
            <td>${order.idOfVehicle}</td>
            <td>${order.costOfWork}</td>
            <td>${order.costOfAutoParts}</td>
            <td>${order.costOfWorkHour}</td>
            <td>${order.quantityOfWorkHour}</td>
            <td>${order.idOfCustomer}</td>

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
