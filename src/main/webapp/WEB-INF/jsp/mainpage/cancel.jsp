<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="eng">
<head>
    <meta charset="ISO-8859-1">
    <title>Cancel</title>
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
        .container
        {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 100px;
        }
        body{
            background-repeat: no-repeat;
            background-size: cover;
            background-image:url("data:image/jpeg;base64,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");
        }
        .logoutbutton{
            margin-top: 40px;
            margin-right: 60px;
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

<div style="display: flex; justify-content: center;align-items: center;margin-top: 50px">
    <a href = "/conference_room_booking/home">
        <button type="button" class="btn btn-primary">Return to Home</button>
    </a>
</div>
<div class="container">
    <div class="card " style="height: 60px">
        <div class="card-header" style="height: 60px">
            <h3 style="text-align: center;"> BOOKING DETAILS</h3>
        </div>
    </div>
    <br>
    <br>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th scope="col" style="text-align: center">Booking_id</th>
            <th scope="col" style="text-align: center">Booking_Date</th>
            <th scope="col" style="text-align: center">Booking_time_from</th>
            <th scope="col" style="text-align: center">Booking_time_to</th>
            <th scope="col" style="text-align: center">Status</th>
            <th scope="col" style="text-align: center">Description</th>
            <th scope="col" style="text-align: center">Room_id</th>
            <th scope="col" style="text-align: center">emailId</th>
            <th scope="col" style="text-align: center">Action</th>
        </tr>
        </thead>
        <tbody>
        <div>
            <%
                if (session.getAttribute("response_message") != null) {
            %>
                <div class="alert alert-danger" id = "danger-alert" role="alert">
                    <b>${response_message}</b>
                </div>
            <%
                } session.removeAttribute("response_message");
            %>

        </div>
        <c:forEach items="${bookings}" var="id">
            <tr>
                <td class="table-dark" style="text-align: center">${id.getBookingId()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingDate()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingTimeFrom()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingTimeTo()}</td>
                <td class="table-dark" style="text-align: center">${id.getApprovalStatus()}</td>
                <td class="table-dark" style="text-align: center">${id.getDescription()}</td>
                <td class="table-dark" style="text-align: center">${id.getRoomDetails().getRoomId()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingUserDetails().getEmailId()}</td>
                <td class="table-dark" style="text-align: center">
                    <a href="/conference_room_booking/cancel/${id.getBookingId()}" role="button" class="btn btn-danger"><strong>CANCEL</strong></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>