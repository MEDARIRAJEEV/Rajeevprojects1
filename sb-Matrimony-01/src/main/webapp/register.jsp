<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: #f7f7f7;
            font-family: Arial, sans-serif;
        }

        center {
            margin-top: 50px;
        }

        h1 {
            color: #333;
            font-size: 36px;
            margin-bottom: 20px;
        }

        h3 {
            color: #555;
            font-size: 24px;
            margin-bottom: 30px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 500px;
        }

        th {
            text-align: left;
            padding: 8px;
            color: #333;
        }

        td {
            padding: 8px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="checkbox"] {
            margin-top: 8px;
            margin-left: 5px;
            cursor: pointer;
        }

        input[type="submit"] {
            padding: 12px 20px;
            background-color: #ff6347;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #e53e3e;
        }
    </style>
</head>
<body>
    <center>
        <form action="register">
            <h1>Welcome to the register page..</h1>
            <h3>Enter your details..</h3>
            <table>
                <tr>
                    <th>Enter name:</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Enter mobile no:</th>
                    <td><input type="text" name="mobileno"></td>
                </tr>
                <tr>
                    <th>Enter designation:</th>
                    <td><input type="text" name="job"></td>
                </tr>
                <tr>
                    <th>Enter email id:</th>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <th>Enter password:</th>
                    <td>
                        <input type="password" id="password" name="password">
                        <input type="checkbox" onclick="togglePassword()"> Show Password
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </center>

    <script>
        function togglePassword() {
            var passwordField = document.getElementById("password");
            if (passwordField.type === "password") {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }
    </script>
</body>
</html>
