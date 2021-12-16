<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
<%
    if (session.getAttribute("accept_sa") == null) {
        response.sendRedirect("/conference_room_booking/login");
    }
    session.invalidate();
%>
<h1 style = "font-size: 90px;">System Administrator</h1>
<form action="/conference_room_booking/logout" method="POST">
    <button class="btn btn-primary" type="submit">Logout</button>
</form>
</body>
</html>