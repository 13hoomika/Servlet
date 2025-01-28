<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Job application form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #E2E0C8;
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
            background-color: #5C7285;
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
<form action="allApplication" method="POST">
    <label for="nameId">Full Name</label>
    <input type="text" id= "nameId" name="fullName" placeholder="Enter your full name">

    <label for="emailId">Email</label>
    <input type="email" id="emailId" name="email" placeholder="example@gmail.com">

    <label for="phoneId">Phone</label>
    <input type="number" id="phoneId" name="phone" placeholder="10 digit number">

    <label for="posId">Position Applied For</label>
    <select name="position" id="posId">
      <option value="javaFullStackDev">Java Full Stock Developer</option>
      <option value="pythonFullStackDev">Python Full Stock Developer</option>
      <option value="dataAnalyst">Data Analyst</option>
      <option value="softwareEngineer">Software Engineer</option>
    </select>

    <label for="experienceId">Years of Experience</label>
    <input type="number" id="experienceId" name="experience" placeholder="Years of Experience">
    <button type="submit">Apply</button>
</form>

</body>
</html>