/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.dao;
import cn.dbc.DatabaseConnection;
import cn.dao.IProductDAO;
import cn.dao.ProductImpl;
import cn.vo.Product;
import java.util.LinkedList;

/**
 *
 * @author blocks
 */
public class ProductProxy implements IProductDAO{
    private DatabaseConnection dbc=null;
    private IProductDAO dao=null;
    
    public ProductProxy()
    {
        dbc=new DatabaseConnection();
        dao=new ProductImpl(dbc.getConnection());
        
        
    }
    
    @Override
    public String getByUPass(String uname,String upass) throws Exception
    {
        String name=null;
        name=dao.getByUPass(uname, upass);
        
        if(dbc!=null)
        {
            dbc.close();
        }
        
        return name;
    }
    
    
    public LinkedList<Product> getAll()throws Exception
    {
        LinkedList<Product> mid=null;
        mid=dao.getAll();
        if(dbc!=null)
        {
            dbc.close();
        }
        return mid;
        
    }
    
    
    public Product getPid(int pid) throws Exception
    {
        Product product=null;
        product=dao.getPid(pid);
        
        
        dbc.close();
        
        return product;
    }
    
    public boolean doInsert(Product product) throws Exception
    {
        boolean flag=false;
        flag=dao.doInsert(product);
        
        if(dbc!=null)
        {
            dbc.close();
        }
        
        return flag;
    }
    
    public boolean doUpdate(Product product,int former) throws Exception
    {
        boolean flag=false;
        flag=dao.doUpdate(product,former);
        
        if(dbc!=null)
        {
            dbc.close();
        }
        
        return flag;
    }
    
    public boolean doDelete(int id) throws Exception
    {
        boolean flag=false;
        
        flag=dao.doDelete(id);
        
        if(dbc!=null)
        {
            dbc.close();
        }
        
        return flag;
    }

}
