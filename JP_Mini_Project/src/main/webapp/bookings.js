const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row.seat:not(.occupied');

const movie_ticket_count = document.getElementById("ticketcount");


const selectedSeats = document.querySelectorAll('.row .seat.selected');

if(selectedSeats.length == 0)
{
	const bookBtn = document.querySelector("#button-book");
	bookBtn.style.backgroundColor = "#696969";
	let bookDiv = document.querySelector('.booking').getElementsByTagName('*');
	for(var i = 0; i < bookDiv.length; i++)
	{
		bookDiv[i].setAttribute('disabled', true);
	}
	console.log(selectedSeats);
}



container.addEventListener('click', (e) => {
if(e.target.classList.contains('seat') && !e.target.classList.contains('occupied')){
	console.log(e.target);
	e.target.classList.toggle('selected');
	
	const selectedSeats = document.querySelectorAll('.row .seat.selected');
	
	if(selectedSeats.length == 0)
	{
		const bookBtn = document.querySelector("#button-book");
		bookBtn.style.backgroundColor = "#696969";
		let bookDiv = document.querySelector('.booking').getElementsByTagName('*');
		for(var i = 0; i < bookDiv.length; i++)
		{
			bookDiv[i].setAttribute('disabled', true);
		}
		console.log(selectedSeats);
	}
	else if(selectedSeats.length > 0)
	{
		const bookBtn = document.querySelector("#button-book")
		bookBtn.style.backgroundColor = '#231F20';
		let bookDiv = document.querySelector('.booking').getElementsByTagName('*');
		for(var i = 0; i < bookDiv.length; i++)
		{
			bookDiv[i].disabled = false;
		}
		movie_ticket_count.value =  selectedSeats.length.toString();
		console.log("ticket count value ",movie_ticket_count.value);
		console.log(selectedSeats);
		
	}
}
});