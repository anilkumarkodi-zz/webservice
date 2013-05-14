<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get Direction</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&libraries=places&language=en-AU"></script>
        <script type="text/javascript" src="./static/javascript/googleDistance.js"></script>
        <script type="text/javascript" src="./static/handlerbar/handlebars.js"></script>
        <script id="template" type="text/x-handlebars-template">
        <div style="padding-left: 350px;">
            Distance is:<span style="color:#00FF00;"> {{ distance }} </span>
        </div>
        </script>
</head>
<body>
    <div style="color:#CC00CC" align="center">
        My Google Map
    </div>
    <div style=" padding:20;padding-left: 300px;">
        <div>
            Travel Mode:
            <span style="padding-left: 29px;">
                <select id="travelMode" name="travelMode">
                    <option value="driving">Driving</option>
                    <option value="walking">Walking</option>
                </select>
            </span>
        </div>
        <div>
            Location From:<span style="padding-left: 20px;"><input type="text" name="fromAddress" id="fromAddress" size="30"></span>
                <script>
                    var autocomplete = new google.maps.places.Autocomplete(document.getElementById('fromAddress'));
                    google.maps.event.addListener(autocomplete, 'place_changed', function() {
                    var place = autocomplete.getPlace();
                    });
                </script>
        </div>
        <div>
            Location  To :<span style="padding-left: 33px;"><input type="text" name="toAddress" id="toAddress" size="30"></span>
                <script>
                    var autocomplete = new google.maps.places.Autocomplete(document.getElementById('toAddress'));
                    google.maps.event.addListener(autocomplete, 'place_changed', function() {
                    var place = autocomplete.getPlace();
                    });
                </script>
        </div>
        <div style="padding-left: 287px;">
            <input type="button" name="getDistance" value="Get Distance" onclick="checkDistance(document.getElementById('travelMode').value)">
        </div>
    </div>
   <div id="content"></div>
</body>
</html>