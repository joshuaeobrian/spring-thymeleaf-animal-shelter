/**
 * Created by josh on 3/28/17.
 */

$(document).ready(function () {




	$("#menu-slide").click(function () {
		$("#left-nav").animate({width:'toggle'},500);
		//toggle("slide");
	});

	$("#create").click(function () {
		document.location.href = '/';
	});
	$("#showAnimals").click(function () {
		document.location.href = '/animals';
	});
});




