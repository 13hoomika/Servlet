<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Passport Seva</title>
	<style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
            }

            h1 {
                font-family: Arial, sans-serif;
                font-size:20px;
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

            input[type="submit"] {
                background-color: #007bff;
                color: #fff;
                border: none;
                cursor: pointer;
            }
        </style>
</head>
<body>
	<form action="applyPassport" method="post">
		<h1>Passport Application Form</h1>
		<label>Enter Applicant Name:</label>
		<input type="text" name="applicantName"><br>

		<label>Enter Date of Birth:</label>
		<input type="date" name="dob"><br>

		<label>Enter Email ID:</label>
		<input type="email" name="emailId"><br>

		<label>Enter Mobile Number:</label>
		<input type="tel" name="mobileNumber"><br>

		<label>Enter Address:</label>
		<input type="text" name="address"><br>

		<label>Enter PIN Code:</label>
		<input type="text" name="pinCode"><br>
		<input type="submit" value="Apply for Passport" name="applyPassport">
	</form>
</body>
</html>