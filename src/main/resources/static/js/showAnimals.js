/**
 * Created by josh on 3/28/17.
 */
const species = document.getElementById("species-drop");
const display = document.getElementById("main-container");
if(display!=null){

	display.addEventListener("click",(e) =>{
		if(e.target.tagName == 'BUTTON'){
			const button = e.target;
			const main = button.parentNode.parentNode;
			const container = main.parentNode;
			const action = button.textContent;
			const id = main.querySelector('.animal-id').textContent;
			//This is a object that holds an object that holds various functions that control
			//Animals Page
			const nameAction = {
				Remove: () =>{
					console.log(id);
					//confirms if user wants to delete
					const response =confirm("Are Sure you want to delete this Animal with ID: "+id);
					//if true
					if(response) {
						//Send animal id to the server
						$.post("/remove-animal", {
							'id': id
						},
							function (data) {
								if(data){
									alert("Animal has been Deleted!")
								}
							}
						);
						//remove element from the dom
						container.removeChild(main);
					}else{

					}
				},
				//sends you to another page loads page based on url
				Details: ()=>{
					document.location.href = '/detail?id='+id;
				}
			};
			nameAction[action]();
		}
	});
	species.addEventListener("change",function (e) {
		const speciesid = e.target.value;
		document.location.href= "/animals/species?speciesid="+speciesid;
	});
}