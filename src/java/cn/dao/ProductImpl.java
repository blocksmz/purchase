/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.dao;
import cn.dao.IProductDAO;
import cn.vo.Product;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;

/**
 *
 * @author blocks
 */
public class ProductImpl implements IProductDAO {
    
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    
    public ProductImpl(Connection conn)
    {
        this.conn=conn;
    }
    

    @Override
    public String getByUPass(String uname,String upass)throws Exception
    {
        String name=null;
        String sql="select name from member where mid=? and password=?";
        this.pstmt=conn.prepareStatement(sql);
        
        pstmt.setString(1, uname);
        pstmt.setString(2, upass);
        
        ResultSet rs=this.pstmt.executeQuery();
        if(rs.next())
        {
            name=rs.getString(1);
        }
        
        rs.close();
        pstmt.close();
        return name;
       
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public LinkedList<Product> getAll()throws Exception
    {
        LinkedList<Product> con=new LinkedList<Product>();
        String sql="select pid,name,note,price,amount,photo from product";
        pstmt=this.conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        
        while(rs.next())
        {
            
            Product foradd=new Product();
            foradd.pid=rs.getInt(1);
            foradd.name=rs.getString(2);
            foradd.note=rs.getString(3);
            foradd.price=rs.getDouble(4);
            foradd.amount=rs.getInt(5);
            foradd.photo=rs.getString(6);
                    
            con.add(foradd);
            
            
        }
        rs.close();
        pstmt.close();
        
        
        return con;

    }
    
    public Product getPid(int pid) throws Exception
    {
        Product product=null;
        String sql="select * from product where pid=?";
        
        this.pstmt=conn.prepareStatement(sql);
        
        pstmt.setInt(1, pid);
        ResultSet rs=this.pstmt.executeQuery();
        if(rs.next())
        {
            product=new Product();
            product.pid=rs.getInt(1);
            product.name=rs.getString(2);
            product.note=rs.getString(3);
            product.price=rs.getDouble(4);
            product.amount=rs.getInt(5);
            product.photo=rs.getString(6);
        }
        
        rs.close();
        pstmt.close();
        return product;
        
        
    }
    
    public boolean doInsert(Product product) throws Exception
    {
        boolean flag=false;
        
        String sql="insert into product(pid,name,note,price,amount,photo)values(?,?,?,?,?,?)";
        
        pstmt=conn.prepareStatement(sql);
        
        pstmt.setInt(1, product.pid);
        pstmt.setString(2, product.name);
        pstmt.setString(3, product.note);
        pstmt.setDouble(4, product.price);
        pstmt.setInt(5, product.amount);
        pstmt.setString(6,product.photo);
        
        if(pstmt.executeUpdate()>0)
        {
            flag=true;
        }
        
        if(pstmt!=null)
        {
        
             pstmt.close();
        }
        
        return flag;
        
    }
    
    public boolean doUpdate(Product product,int former) throws Exception
    {
        boolean flag=false;
        
        String sql="update product set pid=?,name=?,note=?,price=?,amount=?,photo=? where pid=?";
        
        pstmt=conn.prepareStatement(sql);
        
        pstmt.setInt(1, product.pid);
        pstmt.setString(2, product.name);
        pstmt.setString(3, product.note);
        pstmt.setDouble(4, product.price);
        pstmt.setInt(5, product.amount);
        pstmt.setString(6,product.photo);
        pstmt.setInt(7, former);
        
        if(pstmt.executeUpdate()>0)
        {
            flag=true;
        }
        
        if(pstmt!=null)
        {
        
             pstmt.close();
        }
        
        return flag;
        
        
        
        
    }
    
    
    public boolean doDelete(int id) throws Exception
    {
        boolean flag=false;
        
        String sql="delete from product where pid=?";
        
        pstmt=conn.prepareStatement(sql);
        
        pstmt.setInt(1, id);
        
        if(pstmt.executeUpdate()>0)
        {
            flag=true;
        }
        
        if(pstmt!=null)
        {
        
             pstmt.close();
        }
        
        return flag;
        
        
    }
}
