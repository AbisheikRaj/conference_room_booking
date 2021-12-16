
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove();
    });
}, 3000);


function forgot_password_validation() {
    let mail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let element_emailId = document.getElementById("email");

    if (element_emailId.value === "") {
        element_emailId.classList.add("invalid__input");
        document.getElementById("email_id_message").innerHTML = "Email ID is Required";
        return false;
    }
    if (!(element_emailId.value.match(mail))) {
        element_emailId.classList.add("invalid__input");
        document.getElementById("email_id_message").innerHTML = "Email ID is Invalid";
        return false;
    }
}

function forgot_security_question() {
    let element_keyword = document.getElementById("securityAnswer");
    if (element_keyword.value === "") {
        element_keyword.classList.add("invalid__input");
        document.getElementById("keyword_message").innerHTML = "Keyword is Required";
        return false;
    }
    return true;
}