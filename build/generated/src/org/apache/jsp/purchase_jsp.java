package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class purchase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>天空之城</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            LinkedList<goods> cont=new LinkedList<goods>();
            int count=0;
            Connection con=null;
            PreparedStatement stmt=null;
            ResultSet rs=null;
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");

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
            
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");

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
           

        
      out.write("\n");
      out.write("        <div style=\"width:100%;height:80%;\">\n");
      out.write("         <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    商品id\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    商品名称\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    商品详情\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    商品价格\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    商品数量\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    购买数量\n");
      out.write("                </td>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(np.id);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(np.name);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(np.note);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(np.price);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(np.amount);
      out.write("</td>\n");
      out.write("                <td><a style=\"float:right;\" href=\"purchase.jsp?item=");
      out.print(np.id);
      out.write("&tpage=");
      out.print(npage);
      out.write("\">加入购物车</a></td>\n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("     <div style=\"height:20%;width:100%;\">   \n");
      out.write("    <center>\n");
      out.write("        <div>\n");
      out.write("            <a href=\"purchase.jsp?tpage=");
      out.print(start);
      out.write("\">首页</a>\n");
      out.write("            <a href=\"purchase.jsp?tpage=");
      out.print(before);
      out.write("\">上一页</a>\n");
      out.write("            <a href=\"purchase.jsp?tpage=");
      out.print(after);
      out.write("\">下一页</a>\n");
      out.write("            <a href=\"purchase.jsp?tpage=");
      out.print(end);
      out.write("\">尾页</a>\n");
      out.write("        </div>\n");
      out.write("    </center>\n");
      out.write("        <div style=\"float:right;\">\n");
      out.write("        <form action=\"checkout.jsp\" method=\"post\">\n");
      out.write("            <input type=\"submit\" value=\"结算\">\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("     </div>  \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
