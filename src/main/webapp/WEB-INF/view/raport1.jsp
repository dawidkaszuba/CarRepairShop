<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>roboczogodziny</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
    <div class="container">
            <jsp:include page="/WEB-INF/view/fragments/header.jspf"/>
            <h3>Raport roboczogodzin pracownika:</h3>
            <table class="table">
                <tr>
                    <th>Imię i nazwisko pracownika</th>&nbsp<th>Ilość roboczogodzin</th><th>Przedział czasowy</th><th>Pobierz plik tekstowy</th>

                </tr>
                <tr>
                    <td>${employee.name}&nbsp;${employee.surname}</td><td>${workHours}</td><td>Od:&nbsp${startedDateOfRepair}&nbspDo:&nbsp${date}</td>
                    <td><a>raport1.txt</a></td>
                </tr>


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
    </div>
</body>
</html>
