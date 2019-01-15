<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista zleceń</title>
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
    <hr>

    <h3>Dodaj zlecenie:</h3>

    <form action="/AddOrder" method="post" class="row">

        <div class="col-md-6">
            <div class="form-group">
                <label for="dateOfAcceptanceForRepair">Data przyjęcia do naprawy</label>
                <input type="date" class="form-control" id="dateOfAcceptanceForRepair" name="dateOfAcceptanceForRepair" placeholder="Data przyjęcia do naprawy">
            </div>
            <div class="form-group">
                <label for="startedDateOfRepair">Planowana data rozpoczęcia naprawy</label>
                <input type="date" class="form-control" id="plannedRepairDate" name="plannedRepairDate" placeholder="Planowana data rozpoczęcia naprawy">
            </div>
            <div class="form-group">
                <label for="startedDateOfRepair">Data rozpoczęcia naprawy</label>
                <input type="date" class="form-control" id="startedDateOfRepair" name="startedDateOfRepair" placeholder="Data rozpoczęcia naprawy">
            </div>

            <div class="form-group">
                <label for="idOfEmployee">pracownik</label>
                <select id="idOfEmployee" class="form-control" name="idOfEmployee">
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.id}">${employee.name}&nbsp${employee.surname}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="descriptionOfProblem">Opis problemu</label>
                <input type="text" class="form-control" id="descriptionOfProblem" name="descriptionOfProblem" placeholder="Opis problemu">
            </div>
        </div>

        <div class="col-md-6">

            <div class="form-group">
                <label for="status">status</label>
                <select id="status" class="form-control" name="status">
                    <c:forEach items="${states}" var="status">
                        <option value="${status.name}">${status.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="idOfVehicle">pojazd</label>
                <select id="idOfVehicle" class="form-control" name="idOfVehicle">
                    <c:forEach items="${vehicles}" var="vehicle">
                        <option value="${vehicle.id}">${vehicle.brand}&nbsp${vehicle.model}&nbsp${vehicle.registrationNumber}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="costOfAutoParts">Koszt części</label>
                <input type="number" min="0.01" step="0.01" class="form-control" id="costOfAutoParts" name="costOfAutoParts" placeholder="Koszt części">
            </div>

            <div class="form-group">
                <label for="quantityOfWorkHour">Ilość roboczogodzin</label>
                <input type="number" min="1" step="1" class="form-control" id="quantityOfWorkHour" name="quantityOfWorkHour" placeholder="Ilość roboczogodzin">
            </div>
            <div class="form-group">
                <label for="profit">Narzut</label>
                <input type="number" min="0.01" step="0.01"  class="form-control" id="profit" name="profit" placeholder="W przypadku kwoty 100 i narzutu 0,8 kwota dla klienta to 125">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <h3>zlecenia:</h3>
            <c:forEach  items="${list}" var="i">
                <c:forEach begin="0" end="0" items="${i}">
                    <hr style="border-width: 4px">
                <div class="row">
                        <div class="col-md-4">
                            <div><p><span>Data przyjęcia do naprawy</span><br>${i[0]}</p></div>
                            <div><p><span>Planowana data naprawy</span><br>${i[14]}</p></div>
                            <div><p><span>Data rozpoczęcia naprawy</span><br>${i[1]}</p></div>
                            <div><p><span>pracownik<br></span>${i[2]}&nbsp${i[3]}</p></div>

                        </div>
                        <div class="col-md-4">
                            <div><p><span>Status</span><br>${i[5]}</p></div>
                            <div><p><span>Pojazd</span><br>${i[6]}&nbsp${i[7]}</p></div>
                            <div><p><span>Koszt naprawy</span><br>${i[8]}</p></div>
                            <div><p><span>Koszt części</span><br>${i[9]}</p></div>
                        </div>
                        <div class="col-md-4">
                            <div><p><span>Koszt roboczogodziny</span><br>${i[10]}</p></div>
                            <div><p><span>Ilość roboczogodzin</span><br>${i[11]}</p></div>
                            <div><p><span>klient</span><br>${i[12]}&nbsp${i[13]}</p></div>
                            <div><p><span>akcja</span><br><a href="/DeleteOrder?id=${i[15]}">usuń</a> /
                                <a href="/EditOrder?id=${i[15]}">edytuj</a></p></div>
                        </div>
                        <div class="col-lg-12"><div><p><span>Opis problemu</span><br>${i[4]}</p></div></div>
                </div>
                </c:forEach>
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
