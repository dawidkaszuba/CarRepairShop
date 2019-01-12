<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista statusów</title>
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

        <h3>Dodaj status:</h3>
        <div class="row">
            <form action="/AddState" method="post" class="col-md-6">
                <div class="form-group">
                    <label for="name">nazwa</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="nazwa">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>


            <div class="col-md-6">
                <h3>statusy:</h3>
                <table class="table">


                    <th>nazwa</th>
                    <th>akcja</th>

                    <c:forEach items="${states}" var="state">

                        <tr>
                            <td>${state.name}</td>
                            <td><a href="/DeleteState?id=${state.id}">usuń</a> / <a href="/EditState?id=${state.id}">edytuj</a></td>
                        </tr>

                    </c:forEach>


                </table>
            </div>
        </div>


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
