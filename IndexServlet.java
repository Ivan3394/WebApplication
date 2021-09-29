/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.ItProduct;
import DB.ItProductDB1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private static String url = "jdbc:mysql://localhost:3306/ItProductDB?serverTimezone=Europe/Moscow&useSSL=false"; //jdbc:mysql://localhost/groupsdb?serverTimezone=Europe/Moscow&useSSL=false
    private static String username = "Ivan";
    private static String password = "12345678";

    @Resource(name = "jdbc/itproduct")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            InitialContext ctx;
//            ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/itproduct");
//            Connection conn = ds.getConnection();
//            
////            con = DriverManager.getConnection (url, username, password);
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from itproduct");
//            while(rs.next()) {
//                    out.println(rs.getInt("id"));
//                    out.println(rs.getString("name"));
//                    out.println(rs.getInt("price"));
//                out.println("<br>");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NamingException ex) {
//            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            throw new ServletException(/*"Servlet Could not display records.",*/ e);
//        }catch (ClassNotFoundException e) {
//            throw new ServletException(/*"JDBC Driver not found.",*/ e);
//        } catch (NamingException ex) {
//            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
            ArrayList<ItProduct> itproducts = ItProductDB1.select();
            req.setAttribute("itproducts", itproducts);
            
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}