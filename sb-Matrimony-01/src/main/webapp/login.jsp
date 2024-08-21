<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <center>
        <form action="login">
            <h2>Welcome to the login page..</h2>
            <table>
                <tr>
                    <th>Enter mail id:</th>
                    <th><input type="text" name="email"></th>
                </tr>
                <tr>
                    <th>Enter password:</th>
                    <th>
                        <input type="password" name="password" id="password">
                        <tr>
                            <th> </th>
                        <th><span class="show-password" onclick="togglePasswordVisibility()">Show password</span></th>
                        </tr>
                    </th>
                </tr>
                <tr>
                    <th></th>
                    <th><input type="submit" value="Login"></th>
                </tr>
            </table>
        </form>
    </center>

    <script>
        function togglePasswordVisibility() {
            var passwordInput = document.getElementById("password");
            if (passwordInput.type === "password") {
                passwordInput.type = "text";
            } else {
                passwordInput.type = "password";
            }
        }
    </script>
</body>
</html>
