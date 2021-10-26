<%--
  Created by IntelliJ IDEA.
  User: hui
  Date: 2021/10/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>验证码</title>
    <script>
      window.onload = function (){
        var img = document.getElementById("img");
        img.onclick = function (){
          var date = new Date().getTime();
          img.src="/imgs.do?"+date;
        }
      }
    </script>

  </head>
  <body>
  <img src="/imgs.do" id="img">
  <a href="" id="a">看不清换一张?</a>
  </body>
</html>
