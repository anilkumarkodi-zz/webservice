<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get Direction</title>
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&libraries=geometry"></script>
    <script type="text/javascript"
            src="http://maps.google.com/maps/api/js?sensor=false&libraries=places&language=en-AU"></script>
    <script type="text/javascript" src="./static/javascript/googleDistance.js"></script>
    <script type="text/javascript" src="./static/handlerbar/handlebars.js"></script>
    <script id="template" type="text/x-handlebars-template">
        <div>
            Distance is: {{ distance }} Km
        </div>
    </script>
</head>
<body>
<div>    ${distance}
    Location From:<input type="text" name="fromAddress" id="fromAddress" size="30">
    <script>
        var autocomplete = new google.maps.places.Autocomplete(document.getElementById('fromAddress'));
        google.maps.event.addListener(autocomplete, 'place_changed', function() {
        var place = autocomplete.getPlace();
        });
    </script>
   </div><div>
        Location  To :<input type="text" name="toAddress" id="toAddress" size="30"><br/>
    <script>
        var autocomplete = new google.maps.places.Autocomplete(document.getElementById('toAddress'));
        google.maps.event.addListener(autocomplete, 'place_changed', function() {
        var place = autocomplete.getPlace();
        });
    </script>
   </div><div>
   <input type="button" name="getDirection" value="Get Length"
              onclick="checkDistance()">

    <div id="content"></div>
</body>
</html>