<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="cn.factory.*,cn.vo.*" %>
<!DOCTYPE html>

<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>结算</title>
    </head>
    <body>
    <center>
        
        <%
            double totalprice=0;
            
            Cookie[] ck=request.getCookies();
        %>
        
        <table>
               <tr>
                   <td>
                       商品id
                   </td>
                   <td>
                       商品名称
                   </td>
                   <td>
                       商品详情
                   </td>
                   <td>
                       商品价格
                   </td>
                   <td>购买数量</td>
               </tr>
        
        <%
                int len=ck.length;
                for(int i=0;i<len;i++)
                {
                    String theName=ck[i].getName();
                    if(theName.startsWith("J"))
                    {
                        continue;
                    }

                    Product fc=new Product();
                    fc=DAOFactory.getIProductDAOInstance().getPid(Integer.parseInt(theName));
                    
                    totalprice+=fc.price*Integer.parseInt(ck[i].getValue());
                    
           %>
           
           <tr>
                   <td>
                       <%=fc.pid%>
                   </td>
                   <td>
                       <%=fc.name%>
                   </td>
                   <td>
                       <%=fc.note%>
                   </td>
                   <td>
                       <%=fc.price%>
                   </td>
                   <td>
                       <%=ck[i].getValue()%>
                   </td>
               </tr>
          
               
               <%
                   }
               %>
               </table>  
               <div style="float:right">
                   商品总价<%=totalprice%>
               </div> 
    </center>
    </body>

</html>