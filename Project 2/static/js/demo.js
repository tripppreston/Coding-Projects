

function buttonFunction(){
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    if(email.includes("@"))
    {
        document.getElementById("display-name").innerHTML = "";
    document.getElementById("display-name").innerHTML = "Thank you " + name + " for signing up!";
    document.form1.text1.focus();
    return true;
    }
    else
    {
    alert("You have entered an invalid email address!");
   
    
}
}


