<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Spring Security PreAuth Example Login</title></head>
<body>
<form method="post" action="j_security_check">
    <label>Username</label>
    <input type="text" name="j_username">
    <br>
    <label>Password</label>
    <input type="password" name="j_password">
    <br>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>