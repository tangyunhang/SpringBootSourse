<%--
  Created by IntelliJ IDEA.
  User: tangyunhang
  Date: 2021/7/13
  Time: 9:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="some2/register" method="post">
        姓名：<input type="text" name="name"> <br>
        年龄：<input type="text" name="age"> <br>
        <input type="submit" value="注册">
    </form>
     <hr>
    <form action="some2/find" method="post">
            年龄上限：<input type="text" name="age">
        <input type="submit" value="查询">
    </form>
    <hr>
    <a href="some2/count">查询总人数</a>
</body>
</html>
