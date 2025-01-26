<html>
<head>
  <title>Health Check Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      padding: 20px;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
    input, select, textarea, button {
      width: 100%;
      padding: 10px;
      font-size: 14px;
    }
    button {
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
    }
    button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <h2>Health Check Form</h2>
  <form action="healthCheck" method="POST">
    <div class="form-group">
      <label for="fullName">Full Name</label>
      <input type="text" id="fullName" name="fullName" placeholder="Enter your full name" required>
    </div>
    <div class="form-group">
      <label for="age">Age</label>
      <input type="number" id="age" name="age" placeholder="Enter your age" required>
    </div>
    <div class="form-group">
      <label for="gender">Gender</label>
      <select id="gender" name="gender" required>
        <option value="" disabled selected>Select your gender</option>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
      </select>
    </div>

    <div class="form-group">
      <label for="symptoms">Are you experiencing any of the following symptoms? (Check all that apply)</label>
      <input type="checkbox" name="symptoms" value="fever" id="fever"> Fever<br>
      <input type="checkbox" name="symptoms" value="cough" id="cough"> Cough<br>
      <input type="checkbox" name="symptoms" value="fatigue" id="fatigue"> Fatigue<br>
      <input type="checkbox" name="symptoms" value="breathing" id="breathing"> Difficulty Breathing<br>
    </div>

    <div class="form-group">
      <label for="existingConditions">Do you have any existing health conditions?</label>
      <textarea id="existingConditions" name="existingConditions" rows="4" placeholder="List any pre-existing conditions or write 'None'" required></textarea>
    </div>

    <div class="form-group">
      <label for="travel">Have you traveled internationally in the last 14 days?</label>
      <select id="travel" name="travel" required>
        <option value="" disabled selected>Select</option>
        <option value="yes">Yes</option>
        <option value="no">No</option>
      </select>
    </div>

    <button type="submit">Submit</button>
  </form>
</body>
</html>
