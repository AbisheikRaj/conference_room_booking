<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select Your Room</title>
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
    <link rel="stylesheet" href="/css/home.css" />
</head>
<body>
<div class="home_parent">
    <div class="home_page_form">
        <div style="width: 100%">
            <div class="home_page_header">
                <div style = "margin-bottom: 30px;margin-top: 70px;">
                    <p class="h1">Click on your choice</p>
                </div>
                <div>
                    <a href = "/conference_room_booking/home">
                        <button type="button" class="btn btn-primary">Return to Home</button>
                    </a>
                </div>
            </div>
            <div>
                <div class="booknow">
                    <div class="image">
                        <p style="text-align:center;">
                            <a href="/conference_room_booking/booking_page">
                                <input type="image" src="/image/Booknow.png" alt="Book Now" width="300px" height="160px">
                            </a>
                        </p>
                    </div>
                </div>

                <div class="transfer">
                    <p style="text-align:center;">
                        <a href="/conference_room_booking/transfer_booking">
                            <input type="image" src="/image/Transfer.png" alt="Transfer" width="300px" height="160px">
                        </a>
                    </p>
                </div>

                <div class="cancel">
                    <p style="text-align:center;">
                        <a href="/conference_room_booking/cancel_booking">
                            <input type="image" src="/image/Cancel.png" alt="cancel" width="300px" height="160px">
                        </a>
                    </p>
                </div>

                <div class="logout">
                    <div>
                        <form action="/conference_room_booking/logout" method="POST">
                            <p style="text-align:center;">
                                <button class="btn btn-primary" type="submit">Logout</button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>