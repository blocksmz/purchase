<%-- 
    Document   : process
    Created on : Jul 31, 2016, 8:35:08 PM
    Author     : blocks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.fileupload.disk.*" %>
<%@page import="org.apache.commons.fileupload.servlet.*" %>
<%@page import="org.apache.commons.fileupload.*" %>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="cn.vo.*,cn.factory.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>处理页</title>
    </head>
    <body>
        <%
            
            int pid=0;
            String name="",note="";
            double price=0;
            int amount=0;
            String photo="nophoto.jpg";
            String former=null;
            String fpic=null;
        %>
        
        
        <%
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            upload.setFileSizeMax(3145728);
            List<FileItem> items=upload.parseRequest(request);
            
            Iterator<FileItem> iter=items.iterator();
            
            while(iter.hasNext())
            {
                FileItem item=iter.next();
                
                String fieldName=item.getFieldName();
                
                System.out.println(fieldName);
                
                
                
                if(fieldName.equals("pid"))
                {
                    pid=Integer.parseInt(item.getString());
                }
                else if(fieldName.equals("name"))
                {
                    name=item.getString();
                }
                else if(fieldName.equals("note"))
                {
                    note=item.getString();
                }
                else if(fieldName.equals("price"))
                {
                    price=Double.parseDouble(item.getString());
                }
                else if(fieldName.equals("amount"))
                {
                    amount=Integer.parseInt(item.getString());
                }
                else if(fieldName.equals("photo"))
                {
                    if(item.getName()=="")
                    {
                        continue;
                    }
                    File saveFile=null;
                    InputStream input=null;
                    OutputStream output=null;
                    input=item.getInputStream();
                    
                    System.out.println("getName is \"\" :"+(item.getName()==""));
                    
                    System.out.println("getName is null:"+(item.getName()==null));
                    
                    System.out.println(item.get());
                    
                    saveFile=new File(this.getServletContext().getRealPath("/")+item.getName());
                    photo=item.getName();
                  
                        Date now=new Date();
                        saveFile=new File(this.getServletContext().getRealPath("/")+now.getTime()+"_"+item.getName());
                        photo=now.getTime()+"_"+item.getName();

                    
                    output=new FileOutputStream(saveFile);
                    
                    byte[] data=new byte[512];
                    int temp=0;
                    
                    while((temp=input.read(data))!=-1)
                    {
                        output.write(data);
                    }
                    
                    input.close();
                    output.close();
                }
                else if(fieldName.equals("fer"))
                {
                    former=item.getString();
                }
                else if(fieldName.equals("fpic"))
                {
                    fpic=item.getString();
                }
                
                
            }
            


            Product product=null;
            product=new Product();
            
            if(photo.equals("nophoto.jpg"))
            {
                photo=fpic;
            }
            
            product.setPid(pid);
            product.setName(name);
            product.setNote(note);
            product.setPrice(price);
            product.setAmount(amount);
            product.setPhoto(photo);
            
            boolean res=false;
            
            if(request.getParameter("mod")==null)
            {
            
            res=DAOFactory.getIProductDAOInstance().doInsert(product);
            }
            else if(request.getParameter("mod").equals("1"))
            {
                System.out.println("fer:"+former);
                res=DAOFactory.getIProductDAOInstance().doUpdate(product,Integer.parseInt(former));
                
            }
            %>
        
            <%
                if(res==false)
                {
             %>
             <h1>商品资料更新出错，请联系管理员!</h1>
             <%
                }
else{
            %>
            <h1>商品资料更新成功!</h1>
            <%
            }
            
            %>
            
    </body>
</html>
