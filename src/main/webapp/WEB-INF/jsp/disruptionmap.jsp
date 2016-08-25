<%@include file="include/header.jsp" %>

<div class="panel panel-default">

    <div class="panel-heading">
        <h3 class="panel-title">Disruptions:</h3>
    </div>

    <div class="panel-body">

        <%--Put the map here--%>

    </div>

    <div class="panel-body">

        <table class="table table-striped" id="disruption-table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Severity</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Latitude</th>
                <th>Longitude</th>
            </tr>
            </thead>
            <tbody>

            <c:if test="${not empty disruptionlists}">
                <c:forEach var="disruption" items="${disruptionlists}">
                    <tr>
                        <td>${disruption.id}</td>
                        <td>${disruption.severity}</td>
                        <td>${disruption.startdate}</td>
                        <td>${disruption.enddate}</td>
                        <td>${disruption.latitude}</td>
                        <td>${disruption.longitude}</td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>
        </table>

    </div>

</div>

<%@include file="include/footer.jsp" %>
