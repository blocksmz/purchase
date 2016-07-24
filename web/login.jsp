<%-- 
    Document   : login
    Created on : Jul 23, 2016, 2:15:27 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录</title>
    </head>
    <body>
        
        <%
            request.setCharacterEncoding("utf-8");
        %>
    <center>
        <form action="purchase.jsp" method="post">
            <table>
                <tr>
                    <td>
                        用户名：
                    </td>
                    <td>
                        <input type="text" name="uname">    
                    </td>
                </tr>
                <tr>
                    <td>
                        密码：
                    </td>
                    <td>
                        <input type="text" name="upass">
                    </td>
                </tr>
                 </table>    
                        <input type="submit" value="登录">

                        <input type="reset" value="重置">
        </form>

    </center>
    </body>
</html>
