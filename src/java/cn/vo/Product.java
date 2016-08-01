/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.vo;

/**
 *
 * @author blocks
 */
public class Product {
    
    public int pid;
    public String name;
    public String note;
    public double price;
    public int amount;
    public String photo="nophoto.jpg";
    
    
    public void setPid(int pid)
    {
        this.pid=pid;
    }
    
    public int getPid()
    {
        return pid;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setNote(String note)
    {
        this.note=note;
    }
    
    public String getNote()
    {
        return note;
    }
    
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setAmount(int amount)
    {
        this.amount=amount;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setPhoto(String photo)
    {
        this.photo=photo;
    }
    
    public String getPhoto()
    {
        return photo;
    }
    
}
