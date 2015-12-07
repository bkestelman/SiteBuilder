/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    var jsonName = (location.pathname).slice(0,-5);
    $.getJSON(jsonName + ".json", function(json) {
        $("body").append(json.layoutHTML);
        $("banner").css("background-image", "url(" + "img/" + jsonName + "/" + json.bannerImg + ")");
    });
});