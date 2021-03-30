

const myForm = document.querySelector('#my-form');
const variableOne = document.querySelector('#variableOne');
const variableTwo = document.querySelector('#variableTwo');
const msg = document.querySelector('.msg');
var solution = document.querySelector('#solution');
const equationType = document.querySelector('#equationType');
const finalAnswer = document.querySelector('#finalAnswer');


myForm.addEventListener('submit', onSubmit); 

function onSubmit(e){
    e.preventDefault(); //pevents the button from doing its default action which would reload the page
    // console.log(variableOne.value);
    // console.log(variableTwo.value);
    console.log(equationType.value);
    
    if(variableOne.value === ''|| variableTwo.value === ''){
        msg.classList.add('error');
        msg.innerHTML = 'Please enter all fields';
        setTimeout(() => msg.remove(), 3000); // removes the error message in 3000 milliseconds
    } else {
        switch(equationType.value) {
            case 'addition' : 
                solution = +variableOne.value + +variableTwo.value;
                finalAnswer.innerHTML = solution;
                console.log(solution);
                break;
            case 'subtraction' :
                solution = variableOne.value - variableTwo.value;
                finalAnswer.innerHTML = solution;
                console.log(solution);
                break;
            case 'multiplication' :
                solution = variableOne.value * variableTwo.value;
                finalAnswer.innerHTML = solution;
                console.log(solution);
                break;
            case 'division' :
                solution = variableOne.value / variableTwo.value;
                finalAnswer.innerHTML = solution;
                console.log(solution);
                break;
        }
    }
}

