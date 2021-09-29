/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Иван Петров
 */
public class ItProduct implements Serializable {
    
//    private Long id;
//    private String name;
//    private BigDecimal price;
    
    
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private int price;
    
    public ItProduct() { }
    
    public ItProduct(String name, int price) {
        
        this.name = name;
        this.price = price;
    }
    
    public ItProduct(int id, String name, int price) {
        
        this.id = id;
        this.name = name;
        this.price = price;
    }

    ItProduct(int itproductId, String name, String price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ItProduct(String name, String price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
}
