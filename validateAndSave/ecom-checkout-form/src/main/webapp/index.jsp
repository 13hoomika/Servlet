<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-commerce Checkout Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #F6F4F0;
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
            background-color: #2E5077;
            color: #fff;
            border: none;
            cursor: pointer;
        }

      </style>
</head>
<body>
<form action="checkout" method="POST">
    <input type="text" name="fullName" placeholder="Full Name">
    <input type="email" name="email" placeholder="Email">
    <input type="text" name="address" placeholder="Shipping Address">

    <select name="paymentMethod">
      <option value="paymentMethod">--- paymentMethod ---</option>
      <option value="paypal">Paypall</option>
      <option value="upi">UPI</option>
      <option value="rupay">RuPay</option>
      <option value="card">Card</option>
    </select>

    <input type="text" name="orderNotes" placeholder="Order Notes (Optional)">
    <button type="submit">Checkout</button>
</form>

</body>
</html>