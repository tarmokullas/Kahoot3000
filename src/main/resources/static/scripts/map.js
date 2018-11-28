function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(58.3777964,26.7146504),
        zoom:15
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
    var marker = new google.maps.Marker({position: {lat: 58.3777964, lng: 26.7146504}, map: map});
}
