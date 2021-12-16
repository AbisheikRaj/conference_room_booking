
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove();
    });
}, 3000);


function reset_password_validation() {
    let passwordFormat = new RegExp(`^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,20})`);
    let element_new_password = document.getElementById("new_password");
    let element_confirm_password = document.getElementById("confirm_password");

    if (element_new_password.value === "") {
        element_new_password.classList.add("invalid__input");
        document.getElementById("new_password_message").innerHTML = "Password is Required";
        return false;
    }
    if (!(passwordFormat.test(element_new_password.value))) {
        element_new_password.classList.add("invalid__input");
        document.getElementById("new_password_message").innerHTML = "Strong Password is required";
        return false;
    }
    if (element_confirm_password.value === "") {
        element_confirm_password.classList.add("invalid__input");
        document.getElementById("confirm_password_message").innerHTML = "Confirm Password is Required";
        return false;
    }
    if (element_new_password.value !== element_confirm_password.value) {
        element_confirm_password.classList.add("invalid__input");
        document.getElementById("confirm_password_message").innerHTML = "Password and Confirm Password must be same";
        return false;
    }
    return true;
}