/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.dao;
import java.util.LinkedList;
import cn.vo.Product;

/**
 *
 * @author blocks
 */
public interface IProductDAO {
    
    
    public String getByUPass(String uname,String upass) throws Exception;
    
    public LinkedList<Product> getAll()throws Exception;
    
    public Product getPid(int pid) throws Exception;
    
    public boolean doInsert(Product product) throws Exception;
    
    public boolean doUpdate(Product product,int former) throws Exception;
    
    public boolean doDelete(int id) throws Exception;
    
    
}
