/**
 * Created by josh on 3/28/17.
 */

//grabs the key container to the page
const display = document.getElementById("main-container");

//id display is not null make this available
if(display!=null){
//Adds event listener to the display
	display.addEventListener("click",(e) =>{
		//if item clicked equals a button collect info and run the proper function
		if(e.target.tagName == 'BUTTON') {
			const button     = e.target;
			const main       = button.parentNode.parentNode;
			const container  = main.querySelector('.animal-detail');
			const action     = button.textContent;
			const id         = main.querySelector('.animal-id').textContent;
			const li         =  container.querySelectorAll("li");
			const nameAction = {
				Remove: () => {
					console.log(id);
					let response = confirm("Are you sure you would like to remove this animal?");
					console.log(response);
					if(response) {
						$.post("/remove-animal",{
							'id' : id
						},
							function (data) {
								if(data){
									alert("Animal has been Deleted!")
									document.location.href = "/animals"
								}
							}
						);

						//container.removeChild(main);

					}else{

					}
				},
				Edit: () => {
					console.log(container);
					for(let i = 0; i < li.length;i++){
						console.log(li[i].textContent)
						const span = li[i].firstElementChild;
						//creates new input element and assigns
						const input = document.createElement('input');
						input.type = 'text';
						input.value = span.textContent;
						li[i].insertBefore(input,span);
						li[i].removeChild(span);
						button.textContent = 'Save';
					}
					button.textContent = 'Save';
				},
				Save: () => {
					for(let i = 0; i < li.length;i++) {
						const input      = li[i].firstElementChild;
						const span       = document.createElement('span')
						span.textContent = input.value;
						li[i].insertBefore(span, input);
						li[i].removeChild(input);

					}
					button.textContent = "Edit";
					//POST
				}

			};
			nameAction[action]();
		}
		});

}