/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.factory;
import cn.dao.ProductProxy;

/**
 *
 * @author blocks
 */
public class DAOFactory {
    
    public static ProductProxy getIProductDAOInstance()
    {
        return new ProductProxy();
    }
    
    
}
