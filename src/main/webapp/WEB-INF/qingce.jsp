<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019/3/17
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <title>清册List</title>
</head>
<body>
<form enctype="multipart/form-data" action="handler.htm" method="post">
    文件:<input id="file" type="file" name="file"/>
    <input type="submit" id="download" value="下载文件"></input>
</form>
<%--<button id="upload">上传文件</button>--%>

</body>
<script type="text/javascript">
    $(function () {
        $("#upload").click(function () {
            var formData = new FormData($('#uploadForm')[0]);
            alert(1);
            $.ajax({
                type: 'post',
                url: "handler.htm",
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
            }).success(function (data) {
                alert(data);
            }).error(function () {
                alert("上传失败");
            });
        });
    });
</script>
</html>
