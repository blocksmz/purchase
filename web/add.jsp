<%-- 
    Document   : add
    Created on : Jul 30, 2016, 9:46:01 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>增加商品</title>
    </head>
    
    <% request.setCharacterEncoding("utf-8"); %>
    <body>
    <center>
        <h1>增加商品</h1>
        <form action="process.jsp" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>商品id</td>
                    <td><input type="text" name="pid"></td>
                </tr>
                <tr>
                    <td>商品名称</td>
                    <td><input type="text" name="name"></td>
                </tr>
                
                <tr>
                    <td>商品描述</td>
                    <td><input type="text" name="note"></td>
                </tr>
                
                <tr>
                    <td>商品价格</td>
                    <td><input type="text" name="price"></td>
                </tr>
                
                <tr>
                    <td>商品数量</td>
                    <td><input type="text" name="amount"></td>
                </tr>
                
                <tr>
                    <td>上传图片</td>
                    <td><input type="file" accept="image/jpeg" name="photo"></td>
                </tr>
                
            </table>
                <input type="submit" name="提交">
                <input type="reset" name="重置">

        </form>
    </center>
    </body>
</html>
