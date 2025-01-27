<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Newsletter form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
        }

        form {
            background: linear-gradient(to right, lavender, purple);
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
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
      </style>
</head>
<body>
<form action="subscribe" method="POST">
    <input type="text" name="fullName" placeholder="Full Name">
    <input type="email" name="emailId" placeholder="Email">
    <input type="text" name="interests" placeholder="Topics of Interest">
    <input type="text" name="country" placeholder="Country">
    <input type="text" name="frequency" placeholder="Newsletter Frequency eg: Weekly, Daily, Monthly">
    <button type="submit">Subscribe</button>
</form>

</body>
</html>