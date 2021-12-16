<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/login.css" />
</head>
<body>
    <div class = "response__message">
        <%
            if (session.getAttribute("response_message") != null) {
                if (session.getAttribute("response_status").equals(true)) {
        %>
            <div class="alert alert-danger" role="alert">
                <b>${response_message}</b>
            </div>
        <%
            }} session.invalidate();
        %>
    </div>
    <div class = "register__parent">
        <div>
            <img src="../image/register_form.png" alt = "register_form_image" width="400px" height="500px"/>
        </div>
        <div style="display: flex; justify-content: center; flex-direction: column; align-items: center; margin-bottom: 50px">
            <div class = "register__heading">
                <p class="h1">Register your account</p>
            </div>
            <div class = "register__form">
                <form action = "/conference_room_booking/validate_register" method="POST" autocomplete="off" onSubmit="return register_validation();">
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        <label for="name" class="form-label">Name</label>
                        <div id = "name_message"></div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="Employee ID">
                        <label for="employeeId" class="form-label">Employee ID</label>
                        <div id = "employee_id_message"></div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="emailId" name="emailId" placeholder="Email ID">
                        <label for="emailId" class="form-label">Email ID</label>
                        <div id = "email_id_message"></div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                        <label for="password" class="form-label">Password</label>
                        <div id = "password_message"></div>
                        <div class="instruction-box">
                            <ul>
                                <li>It contains at least 8 characters and at most 20 characters.</li>
                                <li>It contains at least one digit.</li>
                                <li>It contains at least one upper case alphabet.</li>
                                <li>It contains at least one lower case alphabet.</li>
                                <li>It contains at least one special character which includes !@#$%&*()-+=^.</li>
                            </ul>
                        </div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <div id = "confirm_password_message"></div>
                    </div>
                    <div style="margin-bottom: 1.5rem">
                        <select class="form-select" aria-label="Default select example" id = "securityQuestion" name = "securityQuestion">
                            <option value = "" selected hidden>Security Question</option>
                            <option value="What is your pet name ?">What is your pet name ?</option>
                            <option value="Who is your childhood friend ?">Who is your childhood friend ?</option>
                            <option value="What is your mother tongue ?">What is your mother tongue ?</option>
                            <option value="Who is your favourite hero ?">Who is your favourite hero ?</option>
                            <option value="Which place is your favourite in your city ?">Which place is your favourite in your city ?</option>
                        </select>
                        <div id = "security_question_message"></div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="answer" name="answer" placeholder="Answer">
                        <label for="answer" class="form-label">Answer</label>
                        <div id = "answer_message"></div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="Mobile Number">
                        <label for="mobileNumber" class="form-label">Mobile Number</label>
                        <div id = "mobile_number_message"></div>
                    </div>
                    <div class="register__button">
                        <button type="submit" id = "register__button__final" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
            <div class="gotologin__button">
                <a href = "/conference_room_booking/login">
                    <button type="button" class="btn btn-outline-primary">Go to Login Page</button>
                </a>
            </div>
        </div>
    </div>
    <script src = "../js/register.js" type="text/javascript"></script>
</body>
</html>