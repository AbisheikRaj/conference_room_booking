<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
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
    <script src="../js/login.js" type="text/javascript"></script>
</head>
<body>
    <div class = "login__parent">
        <div class = "response__message">
            <%
                if (session.getAttribute("response_message") != null) {
                if (session.getAttribute("response_status").equals(true)) {
            %>
            <div class="alert alert-danger" id = "success-alert" role="alert">
                <b>${response_message}</b>
            </div>
            <%
            } else {
            %>
            <div class="alert alert-success" id = "success-alert" role="alert">
                <strong>${response_message}</strong>
            </div>
            <%
                }} session.invalidate();
            %>
        </div>
        <div>
            <img src="../image/login_image.png" alt = "login_form_image" height="200px"/>
        </div>
        <div class = "login__page">
            <div class = "login__heading">
                <p class="h1">Sign in to your account</p>
            </div>
            <div class="login__form">
                <form autocomplete="off" action = "/conference_room_booking/validate_login" method="POST" onsubmit="return login_validation();">
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="emailId" name = "emailId" placeholder="Email ID">
                        <label for="emailId">Email address</label>
                        <div id = "email_id_message"></div>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="password" name = "password" placeholder="Password">
                        <label for="password">Password</label>
                        <div id = "password_message"></div>
                    </div>
                    <div class = "login__button">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                </form>
                <div class = "login__newuser">
                    <div>
                        <a href = "/conference_room_booking/register">
                            <button type="button" class="btn btn-outline-primary">Register a user</button>
                        </a>
                    </div>
                    <div>
                        <a href = "/conference_room_booking/forgot_password">
                            <button type="button" class="btn btn-outline-primary">Forgot Password</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
