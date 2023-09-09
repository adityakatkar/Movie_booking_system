
	let form = document.querySelector(".form");
	let login_form = document.querySelector(".login-form");
	let signup_form = document.querySelector(".Signup-form");


	let login_click = document.querySelector(".form-login");
	let signup_click = document.querySelector(".form-signup");
	
	signup_click.addEventListener("click",formChangeSignUp);
	login_click.addEventListener("click",formChangeLogin);
	
	
function onLoad()
{
	signup_form.style.display = "none";
}


function formChangeSignUp()
{
	signup_form.style.display = "block";
	signup_form.style.display = "block";
	login_form.style.display = "none";
}


function formChangeLogin()
{
		login_form.style.display="block";
		signup_form.style.display = "none";
}

onLoad();
