<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background: #E5D9F2;
        }

        h1 {
            font-family: Arial, sans-serif;
            margin-bottom: 20px;
            margin-left: 35%;
        }

        form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            margin-top: 20px;
            margin-left: 35%;
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
            background-color: #69247C;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Event Registration Form</h1>
    <form action="allEvents" method="POST">
        <input type="text" name="fullName" placeholder="Full Name">
        <input type="email" name="email" placeholder="Email Address">
        <input type="text" name="eventName" placeholder="Event Name">
        <select name="ticketType" id="ticketTypeId">
              <option value="Regular">Regular</option>
              <option value="VIP">VIP</option>
        </select>
        <input type="number" name="attendees" placeholder="Number of Attendees">
        <button type="submit">Register</button>
    </form>
</body>
</html>
