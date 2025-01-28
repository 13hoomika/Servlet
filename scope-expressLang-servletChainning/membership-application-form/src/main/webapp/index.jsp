<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Membership Application Form</title>
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
<form action="applyMembership" method="POST">
  Full Name <input type="text" name="name">
  Email <input type="email" name="email" placeholder="example@gmail.com">
  Membership Type (e.g., Gold, Silver) <input type="text" name="membershipType">
  Preferred Start Date <input type="date" name="startDate" placeholder="Preferred Start Date">
  Referral Code (if any) <input type="text" name="referral" placeholder="RDC2025">
  <button type="submit">Apply for Membership</button>
</form>

</body>
</html>