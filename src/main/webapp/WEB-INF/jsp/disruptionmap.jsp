<%@include file="include/header.jsp" %>

<style type="text/css">
    div#map{
        width:100%;
        height:350px;
    }
</style>

<div class="panel panel-default">

    <div class="panel-heading">
        <h3 class="panel-title">Disruptions:</h3>
    </div>

    <div class="panel-body">
        <div id="map"></div>
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


<script type="text/javascript">
    function initMap() {
        var locations = ${mapList};;

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 10,
            center: new google.maps.LatLng(51.528837, -0.165653),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        var infowindow = new google.maps.InfoWindow();

        var marker, i;

        for (i = 0; i < locations.length; i++) {
            console.log(locations[i].latitude);
            marker = new google.maps.Marker({
                position: new google.maps.LatLng(locations[i].longitude, locations[i].latitude),
                map: map
            });

            google.maps.event.addListener(marker, 'click', (function(marker, i) {
                return function() {
                    infowindow.setContent(locations[i].severity);
                    infowindow.open(map, marker);
                }
            })(marker, i));
        }
    }
</script>


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDwdGv7u5Cw2whpFGg2q0R5jG1xOk7L5x4&callback=initMap"
        async defer></script>


<%@include file="include/footer.jsp" %>
