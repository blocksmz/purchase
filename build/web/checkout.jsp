<%-- 
    Document   : checkout
    Created on : Jul 23, 2016, 9:43:25 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>结算</title>
    </head>
    <body>
    <center>
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
            
            Connection con=null;
            PreparedStatement stmt=null;
            ResultSet rs=null;
            
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
            try{
                
                Class.forName(DBDRIVER);
                con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
                String sql="";
                
                int len=ck.length;
                for(int i=0;i<len;i++)
                {
                    String theName=ck[i].getName();
                    if(theName.startsWith("J"))
                    {
                        continue;
                    }
                    
                    sql="select pid,name,note,price,amount from product where pid="+theName;
                    stmt=con.prepareStatement(sql);
                    rs=stmt.executeQuery();
                    
                    goods fc=new goods();
                    
                    while(rs.next())
                    {
                         fc.id=rs.getInt(1);
                         fc.name=rs.getString(2);
                         fc.note=rs.getString(3);
                         fc.price=rs.getDouble(4);
                         fc.amount=rs.getInt(5);
                    }

                    totalprice+=fc.price*Integer.parseInt(ck[i].getValue());
                    
           %>
           
           <tr>
                   <td>
                       <%=fc.id%>
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



                    rs.close();
                    stmt.close();
                    con.close();
                }   
                catch(Exception e)
               { e.printStackTrace();}



                
            %> 
               </table>  
               <div style="float:right">
                   商品总价<%=totalprice%>
               </div> 
    </center>
    </body>
</html>
