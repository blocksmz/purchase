package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>结算</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            
            Connection con=null;
            PreparedStatement stmt=null;
            ResultSet rs=null;
            
            double totalprice=0;
            
            Cookie[] ck=request.getCookies();
            

        
      out.write("\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("               <tr>\n");
      out.write("                   <td>\n");
      out.write("                       商品id\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       商品名称\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       商品详情\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       商品价格\n");
      out.write("                   </td>\n");
      out.write("                   <td>购买数量</td>\n");
      out.write("               </tr>\n");
      out.write("        \n");
      out.write("        ");

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
                    
           
      out.write("\n");
      out.write("           \n");
      out.write("           <tr>\n");
      out.write("                   <td>\n");
      out.write("                       ");
      out.print(fc.id);
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       ");
      out.print(fc.name);
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       ");
      out.print(fc.note);
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       ");
      out.print(fc.price);
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       ");
      out.print(ck[i].getValue());
      out.write("\n");
      out.write("                   </td>\n");
      out.write("               </tr>\n");
      out.write("          \n");
      out.write("           \n");
      out.write("            ");
        
                    
                    }



                    rs.close();
                    stmt.close();
                    con.close();
                }   
                catch(Exception e)
               { e.printStackTrace();}



                
            
      out.write(" \n");
      out.write("               </table>  \n");
      out.write("               <div style=\"float:right\">\n");
      out.write("                   商品总价");
      out.print(totalprice);
      out.write("\n");
      out.write("               </div> \n");
      out.write("    </center>\n");
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
