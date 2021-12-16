<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
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
        <% if (session.getAttribute("response_message") != null) {
            if (session.getAttribute("response_status").equals(true)) {
        %>
        <div class="alert alert-danger" role="alert">
            <b>${response_message}</b>
        </div>
        <%
        } else {
        %>
        <div class="alert alert-success" role="alert">
            <b>${response_message}</b>
        </div>
        <%
                }}
        %>
    </div>
    <div class = "forgotpassword__parent">
        <div class = "forgotpassword__page">
            <div class = "forgotpassword__heading">
                <p class="h1">Forgot Password</p>
            </div>
            <div class="forgotpassword__form">
                <%
                    if (session.getAttribute("security_form") == null) {
                %>
                <form autocomplete="off" action = "/conference_room_booking/forgot_password" method="POST" onsubmit="return forgot_password_validation();">
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="email" name = "emailId" placeholder="Registered Email ID">
                        <label for="email">Registered Email ID</label>
                        <div id = "email_id_message"></div>
                    </div>
                    <div class = "forgotpassword__button">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                    <div class="forgotpassword__button">
                        <a href = "/conference_room_booking/login">
                            <button type="button" class="btn btn-outline-primary">Return to login</button>
                        </a>
                    </div>
                </form>
                <%
                    } if (session.getAttribute("security_form") != null) {
                %>
                <div>
                    <form autocomplete="off" action = "/conference_room_booking/reset_password" method="POST" onsubmit="return forgot_security_question();">
                        <div class="form-floating mb-4">
                            <input type="text" class="form-control" id="security_question" name="securityQuestion" value = ${security_question} readonly>
                            <label for="security_question">Security Question</label>
                        </div>
                        <div class="form-floating mb-4">
                            <input type="text" class="form-control" id="securityAnswer" name="securityAnswer" placeholder="Registered Keyword">
                            <label for="securityAnswer">Registered Keyword</label>
                            <div id = "keyword_message"></div>
                        </div>
                        <div class = "forgotpassword__button">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                        <div class="forgotpassword__button">
                            <a href = "/conference_room_booking/login">
                                <button type="button" class="btn btn-outline-primary">Return to login</button>
                            </a>
                        </div>
                    </form>
                </div>
                <%
                    }
                %>
            </div>
            <div class = "password__instruction">
                <div class="card" style="width: 24rem;">
                    <div class="card-body">
                        <h5 class="card-title">Instructions</h5>
                        <p class="card-text">
                        <ul>
                            <li>Enter your Registered Email ID.</li>
                            <li>Enter your Account Keyword. <br>(In case if you forgot your keyword, Kindly contact our system administrator. He will help you.)</li>
                        </ul>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src = "../js/forgotpassword.js" type="text/javascript"></script>
</body>
</html>