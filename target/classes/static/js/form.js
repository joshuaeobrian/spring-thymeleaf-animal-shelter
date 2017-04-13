/**
 * Created by josh on 3/28/17.
 */

const species = document.getElementById('species-creation');
const form = document.querySelectorAll("form input");


$(document).ready(function () {

	species.addEventListener('change',function (e) {


		$("#breed").empty();
		const breed = e.target.value;
		$.post("/breeds",{
			id:breed,
		},
			function (data) {
				console.log(data);
				for(let i=0; i < data.length;i++){
				  const option = document.createElement('option');
				  option.value = data[i]["id"];
				  option.textContent = data[i]["breed"];
				  $('#breed').append(option);
					console.log(option);

				}
			}
		);
	});

	$('#submit').click(function (event) {
		event.preventDefault();

		$.post("/form",
			{
				"id": 0,
				"name": $('#name').val(),
				'species': $("#species-creation option:selected").text(),// document.getElementById("species-creation").textContent,
				'breed': $("#breed option:selected").text(),
				'age': $('#age').val(),
				'gender': $("#gender-creation option:selected").text(),
				'description': $("#description").val(),
				'dateReceived': null,
				'image': "cat1",

				},
				function (response) {
					//document.location.href = ""+response;

				}

		);
		console.log();

		for (let i = 0; i < form.length; i++) {
			form[i].value = '';
		}
		$('#animal-image').show();
		$('#the-image').attr('src', '#')

	});


});
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function (e) {
			$('#the-image').attr('src', e.target.result);
			fileName = e.target.result;
			$('#animal-image').hide();
		}

		reader.readAsDataURL(input.files[0]);
	}
}

	$("#animal-image").change(function() {
		readURL(this);
});
