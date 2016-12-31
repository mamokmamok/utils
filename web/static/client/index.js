/**
 * Created by Mamok-Laptop on 12/25/2016.
 */
var svgNS = "http://www.w3.org/2000/svg";

// Real stations
var count = 0;
var maxLat = 0;
var maxLon = 0;
var minLat = 1000;
var minLon = 1000;



for (i in data) {
    count++;
    var stop = data[i];

    maxLat = Math.max(stop.lat, maxLat);
    minLat = Math.min(stop.lat, minLat);

    maxLon = Math.max(stop.lon, maxLon);
    minLon = Math.min(stop.lon, minLon);
}

var n = 10000;

console.info("maxLat:" + maxLat);
console.info("minLat:" + minLat);
var stepLat = (maxLat - minLat) / n;
console.info("[max - min] / 1000:" + stepLat);


console.info("maxLon:" + maxLon);
console.info("minLon:" + minLon);
var stepLon = (maxLon - minLon) / n;
console.info("[max - min] / 1000:" + stepLon);

var lastx = n / 2;
var lasty = n / 2;

for (i in positions) {

    var stop = positions[i];

    var lat = calcLat(stop.lat);
    var lon = calcLon(stop.lon);

    craetePlace(lat, lon, stop.name);


    //createLine(lat, lon, lastx, lasty);

    //lastx = lat;
    //lasty = lon;

}

for (i in stops) {

    var stop = stops[i];

    var lat = calcLat(stop.lat);
    var lon = calcLon(stop.lon);

    createCircle(lat, lon, stop.name);
}


function calcLat(lat) {
    return Math.round((lat - minLat) / stepLat, 0);
}
function calcLon(lon) {
    return Math.round((lon - minLon) / stepLon, 0);
}

console.info("count:" + count);
function createCircle(lat, lon, text) {
    var myCircle = document.createElementNS(svgNS, "circle"); //to create a circle. for rectangle use "rectangle"
    myCircle.setAttributeNS(null, "id", "mycircle");
    myCircle.setAttributeNS(null, "cx", lon);
    myCircle.setAttributeNS(null, "cy", lat);
    myCircle.setAttributeNS(null, "text", "mamok");
    myCircle.setAttributeNS(null, "r", 14);
    myCircle.setAttributeNS(null, "fill", getRandomColor());
    myCircle.setAttributeNS(null, "stroke", "black");

    createText(lat + 10, lon + 10, text);
    document.getElementById("map").appendChild(myCircle);
}

function craetePlace(lat, lon, text) {
    var myCircle = document.createElementNS(svgNS, "circle"); //to create a circle. for rectangle use "rectangle"
    myCircle.setAttributeNS(null, "id", "mycircle");
    myCircle.setAttributeNS(null, "cx", lon);
    myCircle.setAttributeNS(null, "cy", lat);
    myCircle.setAttributeNS(null, "text", text);
    myCircle.setAttributeNS(null, "r", 30);
    myCircle.setAttributeNS(null, "fill", "red");
    myCircle.setAttributeNS(null, "stroke", "black");

    createText(lat + 10, lon + 10, text);
    document.getElementById("map").appendChild(myCircle);
}
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function createText(lat, lon, string) {

    var newText = document.createElementNS(svgNS, "text");
    newText.setAttributeNS(null, "x", lon);
    newText.setAttributeNS(null, "y", lat);
    newText.setAttributeNS(null, "font-size", "20");

    var textNode = document.createTextNode(string);
    newText.appendChild(textNode);

    document.getElementById("map").appendChild(newText);
}

function createLine(x1, y1, x2, y2) {
    var line = document.createElementNS("http://www.w3.org/2000/svg", "line");
    line.setAttribute("stroke", getRandomColor());
    line.setAttribute("stroke-width", "2");
    line.setAttribute("x1", x1);
    line.setAttribute("y1", y1);
    line.setAttribute("x2", x2);
    line.setAttribute("y2", y2);
    document.getElementById("map").appendChild(line);
}