<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #FEF9F2;
        }

        form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input, select, textarea, button {
            width: 100%;
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            background-color: #789DBC;
            color: #fff;
            border: none;
            cursor: pointer;
        }

      </style>
</head>
<body>
<form action="allBookings" method="POST">
    <label for="nameId">Enter Your Name</label>
    <input type="text" id="nameId" name="name" placeholder="Full Name">

    <label for="checkInDateID">Email</label>
    <input type="email" name="email" placeholder="example@gmail.com">

    <label for="checkInDateID">Check-in Date</label>
    <input type="date" id="checkInDateID" name="checkInDate" placeholder="Check-in Date">

    <label for="checkOutDateID">Check-out Date</label>
    <input type="date"id="checkOutDateID" name="checkOutDate" placeholder="Check-out Date">

    <label for="noOfRoomsId">Number of Rooms</label>
    <input type="number" id="noOfRoomsId" name="roomCount">
    <button type="submit">Book Now</button>
</form>

</body>
</html>