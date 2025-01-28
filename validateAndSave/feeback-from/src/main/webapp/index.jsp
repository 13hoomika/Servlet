<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background: linear-gradient(to right, blue, pink);

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

        input, textarea, button {
            width: 100%;
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            background-color: #3936d4;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <form action="feedbackResponse" method="POST">
        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your full name" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email address" required>

        <label for="feedback">Your Feedback:</label>
        <textarea id="feedback" name="feedback" rows="5" placeholder="Write your feedback here..." required></textarea>

        <button type="submit">Submit Feedback</button>
    </form>
</body>
</html>
