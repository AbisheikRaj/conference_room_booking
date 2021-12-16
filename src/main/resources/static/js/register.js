
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove();
    });
}, 3000);


function register_validation() {
    let element_name = document.getElementById("name");
    let element_employeeId = document.getElementById("employeeId");
    let element_emailId = document.getElementById("emailId");
    let element_securityQuestion = document.getElementById("securityQuestion");
    let element_answer = document.getElementById("answer");
    let element_mobileNumber = document.getElementById("mobileNumber");
    let element_password = document.getElementById("password");
    let element_confirmPassword = document.getElementById("confirmPassword");
    let passwordFormat = new RegExp(`^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,20})`);
    let characters = /^[a-zA-Z- ,]+(\s?[a-zA-Z- ,])*$/;
    let numbers = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    let mail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (element_name.value === "") {
        element_name.classList.add("invalid__input")
        document.getElementById("name_message").innerHTML = "Name is Required";
        return false;
    }

    if (!(element_name.value.match(characters))) {
        element_name.classList.add("invalid__input")
        document.getElementById("name_message").innerHTML = "Name is Invalid";
        return false;
    }

    if (element_employeeId.value === "") {
        element_employeeId.classList.add("invalid__input");
        document.getElementById("employee_id_message").innerHTML = "Employee ID is Required";
        return false;
    }
    if (element_employeeId.length < 6) {
        element_employeeId.classList.add("invalid__input");
        document.getElementById("employee_id_message").innerHTML = "Employee ID is Invalid";
        return false;
    }

    if (element_emailId.value === "") {
        element_emailId.classList.add("invalid__input");
        document.getElementById("email_id_message").innerHTML = "Email ID is required";
        return false;
    }

    if (!(element_emailId.value.match(mail))) {
        console.log("email id");
        element_emailId.classList.add("invalid__input");
        document.getElementById("email_id_message").innerHTML = "Email ID is Invalid";
        return false;
    }

    if (!(element_password.value.length >= 8 && element_password.value.length <= 20)) {
        element_password.classList.add("invalid__input");
        document.getElementById("password_message").innerHTML = "Password must be greater than or equal to 8";
        return false;
    }

    if (!(passwordFormat.test(element_password.value))) {
        element_password.classList.add("invalid__input");
        document.querySelector("ul").classList.add("incorrect_password");
        document.getElementById("password_message").innerHTML = "Strong Password is required";
        return false;
    }

    if (element_confirmPassword.value === "") {
        console.log("enter");
        element_confirmPassword.classList.add("invalid__input");
        document.getElementById("confirm_password_message").innerHTML = "Confirm Password is Required";
        return false;
    }

    if (element_password.value !== element_confirmPassword.value) {
        console.log('same');
        element_confirmPassword.classList.add("invalid__input");
        document.getElementById("confirm_password_message").innerHTML = "Password and Confirm Password must be same";
        return false;
    }

    if (element_securityQuestion.value === "") {
        element_securityQuestion.classList.add("invalid__input");
        document.getElementById("security_question_message").innerHTML = "Security Question is Required";
        return false;
    }
    if (element_answer.value === "") {
        element_answer.classList.add("invalid__input");
        document.getElementById("answer_message").innerHTML = "Answer is Required";
        return false;
    }
    if (element_mobileNumber.value === "") {
        element_mobileNumber.classList.add("invalid__input");
        document.getElementById("mobile_number_message").innerHTML = "Mobile Number is Required";
        return false;
    }
    if (!(element_mobileNumber.value.match(numbers))) {
        console.log("asdas");
        element_mobileNumber.classList.add("invalid__input");
        document.getElementById("mobile_number_message").innerHTML = "Mobile Number is Invalid";
        return false;
    }
    return true;
}
