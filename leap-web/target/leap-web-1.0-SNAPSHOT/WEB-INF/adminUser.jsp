<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 2019/11/12
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin-user.css"/>">
    <script type="text/javascript" src="<c:url value="/js/admin-user.js"/>"></script>
    <script src="<c:url value="/js/jquery-3.4.1.js"/>" type="text/javascript"></script>
</head>
<body>
<div>

    <%-- 导航栏 --%>
        <div class="searchSum">
            <div class="search">
                <form action="">
                    <input id="search" type="text" name="search"/>
                    <input id="userSearch" type="button" value="用户搜索">
                </form>
            </div>
            <div class="funBuild">
                <a href="addUserAdmin">增加</a>
                <input type="button" id="inform" name="inform" value="通知">
                <input type="button" id="lock" name="lock" value="锁定">
            </div>
        </div>

    <%-- 数据显示区 --%>
        <div class="dataShow">
            <c:forEach items="${adminUserInfo}" var="userInfo">
                <ul class="ul">
                    <input name="uId" type="hidden" value="${userInfo.uId}">
                    <li>姓名：${userInfo.uName}</li>
                    <li>年龄：${userInfo.uAge}</li>
                    <li>电话号码：${userInfo.uSex}</li>
                    <li>电话号码：${userInfo.uPhone}</li>
                    <li>兴趣爱好：${userInfo.interest}</li>
                    <li>用户介绍：${userInfo.uIntroduce}</li>
                    <li>会员：${userInfo.isMember}</li>
                    <li>注册时间：${userInfo.uRegistrationTime}</li>
                    <li>最后登录时间：${userInfo.uLoginTime}</li>
                    <li><a id="updateUser" name="updateUser">修改</a></li>
                    <li><a onclick="deleteUsers(this)">删除</a></li>
                </ul>
            </c:forEach>
        </div>

    <%-- 底部 --%>
        <div class="base">

        </div>

</div>

</body>
</html>
