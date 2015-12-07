/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    var jsonPath = (location.pathname).slice(0,-5) + ".json";
    $.getJSON(jsonPath, function(json) {
        $.each(json, function(key, val) {
            $("body").append(val);
        });
    });
});