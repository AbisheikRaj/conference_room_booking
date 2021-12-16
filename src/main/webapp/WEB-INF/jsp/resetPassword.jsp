<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
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
<div class = "forgotpassword__parent">
    <div class = "forgotpassword__page">
        <div class = "forgotpassword__heading">
            <p class="h1">Reset Password</p>
        </div>
        <div class = "reset__password__body">
            <div class="forgotpassword__form">
                <form autocomplete="off" action = "/conference_room_booking/update_password" method="POST" onSubmit="return reset_password_validation();">
                    <div class="form-floating mb-4">
                        <input type="password" class="form-control" id="new_password" name = "password" placeholder="New Password">
                        <label for="new_password">New Password</label>
                        <div id = "new_password_message"></div>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="password" class="form-control" id="confirm_password" name = "confirm_password" placeholder="Confirm Password">
                        <label for="confirm_password">Confirm Password Message</label>
                        <div id = "confirm_password_message"></div>
                    </div>
                    <div class = "forgotpassword__button">
                        <button type="submit" class="btn btn-primary">Reset Password</button>
                    </div>
                    <div class="forgotpassword__button">
                        <a href = "/conference_room_booking/login">
                            <button type="button" class="btn btn-outline-primary">Cancel</button>
                        </a>
                    </div>
                </form>
            </div>
        </div>
        <div class = "password__instruction">
            <div class="card" style="width: 24rem;">
                <div class="card-body">
                    <h5 class="card-title">Password Instruction</h5>
                    <p class="card-text">
                    <ul>
                        <li>It contains at least 8 characters and at most 20 characters.</li>
                        <li>It contains at least one digit.</li>
                        <li>It contains at least one upper case alphabet.</li>
                        <li>It contains at least one lower case alphabet.</li>
                        <li>It contains at least one special character which includes !@#$%&*()-+=^.</li>
                    </ul>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src = "../js/resetpassword.js" type="text/javascript"></script>
</body>
</html>