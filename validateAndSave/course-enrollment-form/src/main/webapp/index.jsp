<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course Enrollment Form</title>
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
            background: #fbefcc;
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
            background-color: #e0876a;
            color: #fff;
            border: none;
            cursor: pointer;
        }

      </style>
</head>
<body>
<form action="enrollments" method="POST">
    <input type="text" name="name" placeholder="Full Name">
    <input type="email" name="email" placeholder="Email">
    <select name="courseName" id="courseNameID">
      <option value="courseName">---courseName---</option>
      <option value="javaFullStack">Java Full Stack Development</option>
      <option value="pythonFullStack">Python Full Stack Development</option>
      <option value="coreJava">Core Java</option>
    </select>
    <label for ="startDateId">Preferred Start Date</label>
    <input type="date" name="startDate" id="startDateId">
    <input type="text" name="comments" placeholder="Comments (Optional)">
    <button type="submit">Enroll</button>
</form>

</body>
</html>