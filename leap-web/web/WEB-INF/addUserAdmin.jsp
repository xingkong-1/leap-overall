<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 2019/11/14
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
</head>
<body>
    <div class="addUserAdmin">
        <form action="addUserAdmin" method="post">
            <label for="uName">用户名：</label><input type="text" id="uName" name="uName"> <br>
            <label for="uPassword">用户密码：</label><input type="password" id="uPassword" name="uPassword"><br>
            <label for="uPassword1">再次输入密码：</label><input type="password" id="uPassword1" name="uPassword1"><br>
            <label for="uAge">年龄：</label><input type="text" id="uAge" name="uAge"><br>
            性别：<label>
            男<input type="radio" name="uSex" value="0">
            </label>
            <label>女
            <input type="radio" name="uSex" value="1">
            </label><br>
            <label for="uPhone">电话号码：</label><input type="text" id="uPhone" name="uPhone"><br>
            <label for="interest">兴趣爱好：</label><textarea id="interest" name="interest"></textarea><br>
            <label for="uIntroduce">用户介绍：</label><textarea id="uIntroduce" name="uIntroduce"></textarea><br>
            <label>会员：
            <input type="radio" name="isMember" value="0">
            </label>
            <label>非会员：
            <input type="radio" name="isMember" value="1">
            </label><br>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
