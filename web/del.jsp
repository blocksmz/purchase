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
        <title>删除商品</title>
    </head>
    <body>
    <center>
        <h1>删除商品</h1>
        <form action="del.jsp" method="get">
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
            boolean flag=DAOFactory.getIProductDAOInstance().doDelete(product.pid);
            
            if(flag==true)
            {
         %>
         <h2>删除成功</h2>
         <%
            }
            else
            {
        %>
            <h2>删除失败</h2>
        <%
            }
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
