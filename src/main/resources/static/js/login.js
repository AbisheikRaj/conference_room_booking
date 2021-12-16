
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove();
    });
}, 3000);

function login_validation() {
    let element_emailId = document.getElementById("emailId");
    let element_password = document.getElementById("password");
    let mail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (!(element_emailId.value.match(mail))) {
        element_emailId.classList.add("invalid__input");
        document.getElementById("email_id_message").innerHTML = "Email ID is Invalid";
        return false;
    }
    if (element_password.value === "") {
        element_password.classList.add("invalid__input");
        document.getElementById("password_message").innerHTML = "Password is Required";
        return false;
    }
    return true;
}


