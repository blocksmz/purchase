<%-- 
    Document   : purchase
    Created on : Jul 23, 2016, 2:21:40 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="cn.vo.Product,cn.factory.DAOFactory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>天空之城</title>
    </head>
    <body>
        <%
            System.out.println(session.getAttribute("mid"));
            System.out.println(request.getParameter("uname"));
            System.out.println(request.getParameter("upass"));
            
            
            if(session.isNew())
            {
                response.sendRedirect("login.jsp");
            }
            
            if(session.getAttribute("mid")==null&&(request.getParameter("uname")==null || request.getParameter("upass")==null))
            {
                System.out.println("in verify snippet");
                
                %>
                
                 <jsp:forward page="login.jsp" />
                <%
                response.sendRedirect("login.jsp");
            }
            
            if(request.getParameter("item")!=null)
            {
                Cookie[] ck=request.getCookies();
                int len=ck.length;                
                
                boolean flag=false;
                for(int i=0;i<len;i++)
                {
                    if(ck[i].getName().equals(request.getParameter("item")))
                    {
                        int vl=Integer.parseInt(request.getParameter("item"));
                        vl+=1;
                        Cookie now=ck[i];
                        now.setMaxAge(60*24);
                        now.setValue(String.valueOf(vl));
                        response.addCookie(now);
                        flag=true;
                        break;
                    }                    
                }
                
                if(flag==false)
                {
                    Cookie nw=new Cookie(request.getParameter("item"),"1");
                    nw.setMaxAge(60*24);
                    response.addCookie(nw);
                }
            }
        %>
        

        <%
            LinkedList<Product> cont=null;
            int count=0;
            
        %>
        
        <%
            if(session.getAttribute("mid")==null)
            {
                String name=null;
                name=DAOFactory.getIProductDAOInstance().getByUPass(request.getParameter("uname"),request.getParameter("upass"));
                if(name==null)
                {
        %>
        <jsp:forward page="login.jsp" />
        <%
//                    <!--response.sendRedirect("login.jsp");-->
                }
                else{
                    session.setAttribute("mid",name);
                }
            }
            
            
            cont=DAOFactory.getIProductDAOInstance().getAll();
            count=cont.size();

        %>
        
        <%
            int npage=0;
            if(request.getParameter("tpage")!=null)
            {
                npage=Integer.parseInt(request.getParameter("tpage"));
            }
            
        
            int start=0;
//            int end=cont.size()/5;
            int end=count/5;
            int before=0;
            int after=npage;
            
            if(npage>0)
            {
                before=npage-1;
            }
            if(npage<end)
            {
                after=npage+1;
            }
        %>
        
        <div style="width:100%;height:80%;">
         <table>
            <tr>
                <td>商品参考</td>
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
                <td>
                    商品数量
                </td>
                <td>
                    购买数量
                </td>
                <td></td>
            </tr>
        
        
        
        <%
            int ncount=0;
//            int offset=count%5;
            while(ncount<5)
            {
                if(npage*5+ncount >=count)
                {
                    break;
                }
                Product np=cont.get(npage*5+ncount);
                
                 System.out.println("ncount:"+ncount);
                 ncount++;
        %>

       
            <tr>
                <td><img src="<%=np.photo%>" style="height:150px;width:200px;"></td>
                <td><%=np.pid%></td>
                <td><%=np.name%></td>
                <td><%=np.note%></td>
                <td><%=np.price%></td>
                <td><%=np.amount%></td>
                <td><a style="float:right;" href="purchase.jsp?item=<%=np.pid%>&tpage=<%=npage%>">加入购物车</a></td>
            </tr>
        
        <%
            System.out.println(np.name);
            System.out.println("np.photo: link"+np.photo);
            
            }
        %>
        </table>
        
      </div>
        
     <div style="height:20%;width:100%;">   
    <center>
        <div>
            <a href="purchase.jsp?tpage=<%=start%>">首页</a>
            <a href="purchase.jsp?tpage=<%=before%>">上一页</a>
            <a href="purchase.jsp?tpage=<%=after%>">下一页</a>
            <a href="purchase.jsp?tpage=<%=end%>">尾页</a>
        </div>
    </center>
        <div style="float:right;">
        <form action="checkout.jsp" method="post">
            <input type="submit" value="结算">
        </form>
        </div>
     </div>  
    </body>
</html>
