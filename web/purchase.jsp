<%-- 
    Document   : purchase
    Created on : Jul 23, 2016, 2:21:40 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>天空之城</title>
    </head>
    <body>
        <%
            if(session.getAttribute("mid")!=null|| !(request.getParameter("uname")!=null && request.getParameter("upass")!=null))
            {
                System.out.println((String)session.getAttribute("mid"));
                System.out.println(request.getParameter("uname"));
                System.out.println(request.getParameter("upass"));
            }else
            {
                response.sendRedirect("login.jsp");
            }
            
            if(request.getParameter("item")!=null)
            {
                Cookie[] ck=request.getCookies();
                int len=ck.length;
                
                for(int i=0;i<len;i++)
                {
                    System.out.println(ck[i].getName());
                    System.out.println(ck[i].getValue());
                    
                }
                
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
        
        <%!
            public static final String DBDRIVER="org.mariadb.jdbc.Driver";
            public static final String DBURL="jdbc:mariadb://localhost:3306/mldn";
            public static final String DBUSER="blocksmz";
            public static final String DBPASS="MRZHAo0928";

            class goods{
            
            int id;
            String name;
            String note;
            double price;
            int amount;
            }
        %>
        
        <%
            LinkedList<goods> cont=new LinkedList<goods>();
            int count=0;
            Connection con=null;
            PreparedStatement stmt=null;
            ResultSet rs=null;
            
        %>
        
        <%
            try{
                
                Class.forName(DBDRIVER);
                con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
                
                String sql1="select name from member where mid='"+request.getParameter("uname")+"' and password='"+request.getParameter("upass")+"'";
                
                stmt=con.prepareStatement(sql1);
                rs=stmt.executeQuery();
                
                if(rs==null)
                {
                    response.sendRedirect("login.jsp");
                }
                
                if(rs.next())
                {
                    session.setAttribute("mid",rs.getString(1)); 
                }
                
                
                String sql2="select pid,name,note,price,amount from product";
                
                stmt=con.prepareStatement(sql2);
                
                rs=stmt.executeQuery();
                
                
                
                while(rs.next())
                {
                    goods foradd=new goods();
                    foradd.id=rs.getInt(1);
                    foradd.name=rs.getString(2);
                    foradd.note=rs.getString(3);
                    foradd.price=rs.getDouble(4);
                    foradd.amount=rs.getInt(5);
                    
                    cont.add(foradd);
                    count++;
            
                }
                
                rs.close();
                stmt.close();
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
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
            System.out.println("npage:"+npage);
            System.out.println("start:"+start);
            System.out.println("end:"+end);
            System.out.println("after:"+after);
            System.out.println("count:"+count);
           

        %>
        <div style="width:100%;height:80%;">
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
                goods np=cont.get(npage*5+ncount);
                
                 System.out.println("ncount:"+ncount);
                 ncount++;
        %>

       
            <tr>
                <td><%=np.id%></td>
                <td><%=np.name%></td>
                <td><%=np.note%></td>
                <td><%=np.price%></td>
                <td><%=np.amount%></td>
                <td><a style="float:right;" href="purchase.jsp?item=<%=np.id%>&tpage=<%=npage%>">加入购物车</a></td>
            </tr>
        
        <%
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
