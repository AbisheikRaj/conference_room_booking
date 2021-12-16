<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
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
</head>
<body>
    <div class="home_parent">

        <div class= "conference_room_image">
            <div style="float:left ;width:45%;  ">
                <img src="../image/conf.png" alt = "Conference_rooom_image" width="750px" height="740px" >
            </div>
        </div>

        <div class="home_page_form">
            <div style="float:right; width:52%; padding-top:100px;padding-left:200px; padding-bottom:50px;background-color:#4db3b3;">
               <div style="display: flex; justify-content: center; flex-direction: column; align-items: center; margin-bottom: 50px">
                <div class="home_page_header">
                    <div style="text-align:center; padding-right:200px; padding-bottom:50px; font-weight:bold">
                        <p class="h1">Welcome, Choose a Conference Room</p>
                    </div>

                    <div class="apoorva">
                        <form action="/conference_room_booking/apoorva/1" method="POST" autocomplete="off">
                            <div class="image">
                                <input type="image" src="../image/Apoorva.png" alt="Apoorva" width="400px" height="145px" value="1" id = "apoorva_id">
                            </div>
                        </form>
                    </div>
                    <br>
                    <br>
                    <div class="ananya">
                        <form action="/conference_room_booking/ananya/2" method="POST" autocomplete="off">
                            <input type="image" src="../image/Ananya.png" alt="Ananya" width="400px" height="145px"  value="2" id = "roomId">
                        </form>
                    </div>

                    <br><br>
                    <div class="logout">
                        <div style="padding-left:150px; ">
                            <form action="/conference_room_booking/logout" method="POST">
                                <button class="btn btn-primary" type="submit">Logout</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
</html>