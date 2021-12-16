
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="eng">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Book Your Slot</title>
    <style>
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
</head>
<body>
<div class="logoutbutton">
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <form action="/conference_room_booking/logout" method="POST">
            <button class="btn btn-primary" type="submit">Logout</button>
        </form>
    </div>
</div>
<br>
<div class="container">
    <div class="card " style="height: 60px">
        <div class="card-header" style="height: 60px">
            <h3 style="text-align: center;"> BOOKING DETAILS</h3>
        </div>
    </div>

    <br>

    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <a href="/conference_room_booking/booking_form/${roomId}" class="btn btn-success">Add Booking</a>
    </div>
    <br>
    <table class="table table-dark table-striped">
        <thead>

        <tr>
            <th scope="col" style="text-align: center">BookingId</th>
            <th scope="col" style="text-align: center">BookingDate</th>
            <th scope="col" style="text-align: center">BookingTimeFrom</th>
            <th scope="col" style="text-align: center">BookingTimeTo</th>
            <th scope="col" style="text-align: center">Status</th>
            <th scope="col" style="text-align: center">Description</th>
            <th scope="col" style="text-align: center">RoomId</th>
            <th scope="col" style="text-align: center">HostName</th>
            <th scope="col" style="text-align: center">EmailId</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookings}" var="id">
            <tr>
                <td class="table-dark" style="text-align: center">${id.getBookingId()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingDate()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingTimeFrom()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingTimeTo()}</td>
                <td class="table-dark" style="text-align: center">${id.getApprovalStatus()}</td>
                <td class="table-dark" style="text-align: center">${id.getDescription()}</td>
                <td class="table-dark" style="text-align: center">${id.getRoomDetails().getRoomId()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingUserDetails().getHostName()}</td>
                <td class="table-dark" style="text-align: center">${id.getBookingUserDetails().getEmailId()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>