<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="eng">
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
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

    <style>
        .container{
            margin-top: 50px;
        }
        body{
            background-repeat: no-repeat;
            background-size: cover;
            background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLHFSG65veMMPtHX6smhELfNvyK6443CGWCQ&usqp=CAU");
        }
        .card
        {

            width: 90px;
        }
        .book__form__button {
            display: flex;
            justify-content: space-evenly;
            align-items: center;

        }
    </style>
    <script>
        window.setTimeout(function() {
            $(".alert").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 3000);
    </script>
</head>
<body>
    <%
        if (session.getAttribute("response_message") != null) {
            if (session.getAttribute("response_message").equals("approval")) {
    %>
        <div class="alert alert-success" id = "success-alert" role="alert">
            <b>Your booking details are waiting for approval.</b>
        </div>
    <%
    } else {

    %>
        <div class="alert alert-danger" id = "danger-alert" role="alert">
            <b>${response_message}</b>
        </div>
    <%
            } session.removeAttribute("response_message");
        }
    %>

<div class="container">
    <div class="card" style="width: 20cm;">
        <div class="card-header" style="align-content: center;">
            <strong>Enter Booking Details</strong>
        </div>
        <div class="card-body">

            <form action="/conference_room_booking/booking_data" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Room ID</strong></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="roomId" readonly name="roomId" placeholder="Room ID" value = "${roomId}">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Booking Date</strong></label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="bookingDate" name="bookingDate" placeholder="Date">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Timings From</strong></label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="bookingTimeFrom" name="bookingTimeFrom" placeholder="Start Time">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Timings To</strong></label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="bookingTimeTo" name="bookingTimeTo" placeholder="End Time">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Duration</strong></label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="bookingDuration" name="bookingDuration" placeholder="Duration">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Description</strong></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="description" name="description" placeholder="Description">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Email-Id</strong></label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="emailId" name="emailId" placeholder="Email-Id">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Host Name</strong></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hostName" name="hostName" placeholder="Name">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Project Id</strong></label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="projectId" name="projectId" placeholder="Project Id">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"><strong>Project Name</strong></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="projectName" name="projectName" placeholder="Project Name">
                    </div>
                </div>
                <div class = "book__form__button">
                    <button type="submit" class="btn btn-primary" style="align-content: center;"><strong>SUBMIT</strong></button>
                    <a href = "/conference_room_booking/home">
                        <button type="button" class="btn btn-primary" style="align-content: center;"><strong>RETURN TO HOME</strong></button>
                    </a>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>