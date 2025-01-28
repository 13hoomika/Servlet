<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Support Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #d6d4e0;
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
            background-color: #622569;
            color: #fff;
            border: none;
            cursor: pointer;
        }

      </style>
</head>
<body>
<form action="support" method="POST">
    <input type="text" name="name" placeholder="Full Name">
    <input type="email" name="email" placeholder="Email">
    <input type="number" name="orderId" placeholder="Order ID">
    <select name="issueType" id="issueTypeId">
      <option value="issueType">---Issue Type---</option>
      <option value="billing">Billing</option>
      <option value="technical">Technical</option>
    </select>
    <textarea name="description" placeholder="Describe your issue"></textarea>
    <button type="submit">Submit Support Request</button>
</form>

</body>
</html>