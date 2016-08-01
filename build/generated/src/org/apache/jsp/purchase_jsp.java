package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import cn.vo.Product;
import cn.factory.DAOFactory;

public final class purchase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>天空之城</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
                
                
      out.write("\n");
      out.write("                \n");
      out.write("                 ");
      if (true) {
        _jspx_page_context.forward("login.jsp");
        return;
      }
      out.write("\n");
      out.write("                ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("        ");

            LinkedList<Product> cont=null;
            int count=0;
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            if(session.getAttribute("mid")==null)
            {
                String name=null;
                name=DAOFactory.getIProductDAOInstance().getByUPass(request.getParameter("uname"),request.getParameter("upass"));
                if(name==null)
                {
        
      out.write("\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("login.jsp");
        return;
      }
      out.write("\n");
      out.write("        ");

//                    <!--response.sendRedirect("login.jsp");-->
                }
                else{
                    session.setAttribute("mid",name);
                }
            }
            
            
            cont=DAOFactory.getIProductDAOInstance().getAll();
            count=cont.size();

        
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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div style=\"width:100%;height:80%;\">\n");
      out.write("         <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>商品参考</td>\n");
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
                Product np=cont.get(npage*5+ncount);
                
                 System.out.println("ncount:"+ncount);
                 ncount++;
        
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("            <tr>\n");
      out.write("                <td><img src=\"");
      out.print(np.photo);
      out.write("\" style=\"height:150px;width:200px;\"></td>\n");
      out.write("                <td>");
      out.print(np.pid);
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
      out.print(np.pid);
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
