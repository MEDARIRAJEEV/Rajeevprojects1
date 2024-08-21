<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: #f7f7f7;
            font-family: Arial, sans-serif;
        }

        center {
            margin-top: 100px;
        }

        h1 {
            color: #333;
            font-size: 36px;
            margin-bottom: 30px;
        }

        form {
            display: inline-block;
            margin-right: 20px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <center>
        <h1>Welcome to Matrimony....</h1>
        <form action="register.jsp">
            <input type="submit" value="Register">
        </form>
        <form action="login.jsp">
            <input type="submit" value="Login">
        </form>
    </center>
</body>
</html>
