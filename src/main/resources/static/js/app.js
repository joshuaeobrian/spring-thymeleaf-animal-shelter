///**
// * Created by josh on 3/24/17.
// */
//const submit  = document.getElementById('submit');
//const label = document.getElementById('success');
//const form = document.querySelectorAll("form input");
//const display = document.getElementById("main-container");
//let fileName;
////
////$(document).ready(function () {
////	$('#submit').click(function (event) {
////		event.preventDefault();
////
////		$.post("/form",
////			{
////				"name" : $('#name').val(),
////				'species' : $("#specie").val(),
////				'breed' : $("#breed").val(),
////				'age'   : $('#age').val(),
////				'description' : $("#description").val(),
////				'image' :   "cat1",
////
////				success :function (response) {
////					label.textContent = 'Animal has been added!';
////				}
////			}
////
////		);
////
////		for(let i =0; i < form.length;i++){
////			form[i].value = '';
////		}
////		$('#animal-image').show();
////		$('#the-image').attr('src','#')
////
////	});
////
////
////
////
////
////
////});
//
//$.post(
//{
//	"id": "",
//	"answer":"" ,
//	"score": ""
//}
//);
//
//
//
//
//function readURL(input) {
//	if (input.files && input.files[0]) {
//		var reader = new FileReader();
//
//		reader.onload = function (e) {
//			$('#the-image').attr('src', e.target.result);
//			fileName = e.target.result;
//			$('#animal-image').hide();
//		}
//
//		reader.readAsDataURL(input.files[0]);
//	}
//}
//
//$("#animal-image").change(function(){
//	readURL(this);
//});
//
//if(display!=null){
//
//	display.addEventListener("click",(e) =>{
//		if(e.target.tagName == 'BUTTON'){
//			const button = e.target;
//			const main = button.parentNode.parentNode;
//			const container = main.parentNode;
//			const action = button.textContent;
//			const id = main.querySelector('.animal-id').textContent;
//			const nameAction = {
//				Remove: () =>{
//					console.log(id);
//					$.post("/remove-animal",{
//						'id' : id
//					});
//
//					container.removeChild(main);
//				},
//				Edit: () => {
//					console.log(main)
//				},
//				Details: ()=>{
//					document.location.href = '/detail/'+id;
//				}
//			};
//			nameAction[action]();
//
//
//		}
//	});

//}

