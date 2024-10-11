<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 10. 10.
  Time: 오후 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Register Page</h2>
<form action="/todo/register" method="post">
  <div>
    Title : <input type="text" name="title">
  </div>
  <div>
    DueDate : <input type="date" name="dueDate">
  </div>
  <div>
    Writer : <input type="text" name="writer">
  </div>
  <div>
    Finished : <input type="checkbox" name="finished">
  </div>
  <div>
    <button type="submit">Post 요청</button>
  </div>
</form>
</body>
</html>
