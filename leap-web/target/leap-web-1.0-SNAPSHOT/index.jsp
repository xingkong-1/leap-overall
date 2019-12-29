<%--
  Created by IntelliJ IDEA.
  User: kong
  Date: 2019/11/11
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="adminUser">user</a>
    <a href="vidoeInfo">video</a>

    <form action="insertVideo" method="post" enctype="multipart/form-data">
        <input type="text" name="desc">
        <input type="file" name="file">
        <input type="submit" value="提交">
    </form>


    <form action="insertVideo" method="post">
        <label>
            视频名称：<input type="file" name="videoFile">
        </label>
        <label>
            视频来源：<input type="text" name="vSource" >
        </label>
        <label>
            视频清晰度：<input type="text" name="vDefinition" >
        </label>
        <label>
            视频简介：<input type="text" name="vIntro">
        </label>
        <label>
            视频备注：<input type="text" name="vRemark" >
        </label>
        <!--      <div class="file">-->
        文件上传<input type="file" id="file" name="file">
        <!--      </div>-->
        <input type="submit" value="添加">
    </form>
</body>
</html>
