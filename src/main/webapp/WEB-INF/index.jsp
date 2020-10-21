<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>My Test Jsp</title>
</head>
<body>
    <h1>Hello Jsp!</h1>
<%--    <h1>User Info : ${userInfo}</h1>--%>
    <h1>User Info : </h1>
    <table border="1">
        <tr><th>id</th>
            <th>name</th>
            <th>age</th>
            <th>gender</th>
        </tr>
            <c:forEach items="${userInfo}" var="userInfo">
        <tr>
            <td>${userInfo.id}</td>
            <td>${userInfo.name}</td>
            <td>${userInfo.age}</td>
            <td>${userInfo.gender}</td>
        </tr>
    </c:forEach>
    </table>

    <h1>新增一个用户</h1>
    姓名：<input type="text" name="name" /><br>
    年龄：<select name="age" id="age">
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
    </select>
<br>
    性别：<input type="radio" name="gender" value="male" />male
    <input type="radio" name="gender" value="female"/>female<br>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $('input:radio:first').attr('checked', 'true');
        function login() {
            var myData = {
                "name": $("input[name='name']").val(),
                "age": parseInt($("#age option:selected").val()),
                "gender":$("input[name='gender']:checked").val()
            };
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/user/add/one",
                data: JSON.stringify(myData),
                dataType:"JSON",
                contentType: "application/json;charset=UTF-8",
                success:function (data) {
                    if (data && data.code === 0){
                        alert("新增成功");
                        window.location.reload();
                    }else if (data.code === 10001){
                        alert("姓名不能为空")
                    }
                }
            });
        }
    </script>
    <br>
    <input type="button" value="新增用户" onclick="login()">




</body>
</html>