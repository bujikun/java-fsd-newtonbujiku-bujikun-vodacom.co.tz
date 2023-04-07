$(document).ready(() => {

});
const setActiveNavLink =navLinkId=>{
    $(navLinkId).addClass("active");
};
let total = Number(0);

setTimeout(()=>{
    $(".alert-dismissible").remove();
},3000);

const displayError =(errorMessage)=>{
    $("#message").html(errorMessage);
    //document.getElementById("message").innerText=errorMessage;
    //console.log($("#message"));
    $("#passwordAlert").removeClass("d-none").addClass("show");
    setTimeout(()=>{
        $("#passwordAlert").removeClass("show").addClass("d-none")
    },3000);
};

const verifyPassword =()=>{

    const password = $("#password").val();
    const rPassword = $("#repeatPassword").val();
    if(password.length<8){
        displayError("Password too short! Must be 8 characters or more!")
        return false;
    }
    if(password !== rPassword){
        displayError("Passwords do not match!")
        return false;
    }
    return true;

};






