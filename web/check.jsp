<%-- 
    Document   : modify
    Created on : Aug 1, 2016, 3:21:07 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cn.vo.*,cn.factory.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查询商品信息</title>
    </head>
    <body>
    <center>
        <h1>查询商品信息</h1>
        <form action="check.jsp" method="get">
        输入商品id:<input type="text" name="kw">
        <input type="submit" value="查找">
        </form>
        
        
        <%
            if(request.getParameter("kw")!=null)
            {
             System.out.println(request.getParameter("kw"));
             System.out.println(request.getParameter("kw").equals("1"));
            
            Product product=null;
            product=DAOFactory.getIProductDAOInstance().getPid(Integer.parseInt(request.getParameter("kw")));
            
            if(product!=null)
            {
            %>
            <form>
            <table>
                <tr>
                    <td>商品id</td>
                    <td><input type="text" name="pid" value="<%=product.pid%>"></td>
                </tr>
                <tr>
                    <td>商品名称</td>
                    <td><input type="text" name="name" value="<%=product.name%>"></td>
                </tr>
                
                <tr>
                    <td>商品描述</td>
                    <td><input type="text" name="note" value="<%=product.note%>"></td>
                </tr>
                
                <tr>
                    <td>商品价格</td>
                    <td><input type="text" name="price" value="<%=product.price%>"></td>
                </tr>
                
                <tr>
                    <td>商品数量</td>
                    <td><input type="text" name="amount" value="<%=product.amount%>"></td>
                </tr>
                
                <tr>
                    <img src="<%=product.photo%>" style="width:200px;height:150px;">
                </tr>
            </table>

        </form>
            
                    <%
                        }
                        else
{
    %>
    <h2>没有该商品信息</h2>
    <%
}
}
                    %>
    </center> 
    </body>
</html>
