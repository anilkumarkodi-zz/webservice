var LatLng1;
var LatLng2;
var from_address;
var to_address;

function whetherBothResultsHaveBeenFetched() {
    return (undefined != LatLng1 && undefined != LatLng2 );
}

function getLatLong(address, successCallback) {
    var geocoder = new google.maps.Geocoder();
     geocoder.geocode( { 'address': address }, successCallback);
}

function whetherResultSuccessful( status) {
    return status == google.maps.GeocoderStatus.OK;
}

var callback1 = function (results, status){
    if (whetherResultSuccessful(status)) {
        LatLng1 = results[0].geometry.location;
        triggerCalculation();
    }
}

var callback2 = function (results, status){
    if (whetherResultSuccessful(status)) {
        LatLng2 = results[0].geometry.location;
        triggerCalculation();
    }
}

function triggerCalculation() {
     if(whetherBothResultsHaveBeenFetched())
         callback();
}

var callback = function(){
      var p1 = new google.maps.LatLng(LatLng1.lat(), LatLng1.lng());
      var p2 = new google.maps.LatLng(LatLng2.lat(), LatLng2.lng());
       var distance_is= calcDistance(p1, p2);
      displayOnBody(distance_is);
      saveToDB(distance_is);
}

function calcDistance(p1, p2){
    return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
}


function getDistance(fromAddress, toAddress){
    from_address=fromAddress;
    to_address=toAddress;
    getLatLong(fromAddress, callback1);
    getLatLong(toAddress,callback2);
}


function saveToDB(distance){
    xmlhttp=new XMLHttpRequest();
    xmlhttp.open("GET","saveDistance?from_address="+from_address+"&to_address="+to_address+"&distance="+distance,true);
    xmlhttp.send();
}

function checkDistance(){
    var fromAddress=document.getElementById("fromAddress").value;
    var toAddress=document.getElementById("toAddress").value;
    xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
       if (xmlhttp.readyState==4 && xmlhttp.status==200){
           if(!(xmlhttp.responseText=="Not Found")){
                displayOnBody(xmlhttp.responseText);
           }else{
              getDistance(fromAddress,toAddress);
           }
       }
    }
    xmlhttp.open("GET","findDistance?fromAddress="+fromAddress+"&toAddress="+toAddress,true);
    xmlhttp.send();
}


function displayOnBody(actualDistance){
      var data = {distance:actualDistance};
      var templateScript = document.getElementById("template").innerHTML;
      var template = Handlebars.compile(templateScript);
      var divContents = template(data);
      document.getElementById("content").innerHTML = divContents;
}
