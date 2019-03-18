<%--
  Created by IntelliJ IDEA.
  User: janarthan
  Date: 2019-03-18
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="form-group form">
    <form action='login' method="post">
        <div>
            <label>Username:</label>
            <input type="text" id="userId" name="username" placeholder="user name" class="form-control"/>
        </div>
        <div>
            <label>Password:</label>
            <input type="password" id="password" name="password" placeholder="password" class="form-control"/>
        </div>
        <button id="loginButton" class="form-control">Login</button>
    </form>
</div>

</body>
</html>
