/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import DB.ItProduct;
import java.lang.reflect.InvocationTargetException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Иван Петров
 */
public class ItProductDB1 {
    
//    private static String url = "jdbc:mysql://localhost/ItProductDB?serverTimezone=Europe/Moscow&useSSL=false"; //jdbc:mysql://localhost/groupsdb?serverTimezone=Europe/Moscow&useSSL=false
//    private static String username = "Ivan";
//    private static String password = "12345678";
    private static String driver = "com.mysql.jdbc.Driver";

    public static ArrayList<ItProduct> select() throws ClassNotFoundException, NamingException {
        
            
        ArrayList<ItProduct> itproducts = new ArrayList<ItProduct>();
        try{
            Class.forName(driver).getDeclaredConstructor().newInstance();
            
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/itproduct");
            Connection conn = ds.getConnection();
//                Connection conn = DriverManager.getConnection(url, username, password);
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM itproduct");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    ItProduct itproduct = new ItProduct(id, name, price);
                    itproducts.add(itproduct);
                }
//            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return itproducts;
    }
    public static ItProduct selectOne(int id) {
         
        ItProduct itproduct = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM itproduct WHERE id=?";
                
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    
                    if(resultSet.next()){
 
                        int itproductId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String price = resultSet.getString(3);
                        itproduct = new ItProduct(itproductId, name, price);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return itproduct;
    }
    public static int insert(ItProduct itproduct) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO itproduct (name, price) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, itproduct.getName());
                    preparedStatement.setInt(2, itproduct.getPrice());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     public static int update(ItProduct itproduct) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE itproduct SET name = ?, price = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, itproduct.getName());
                    preparedStatement.setInt(2, itproduct.getPrice());
                    preparedStatement.setInt(3, itproduct.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM itproduct WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
