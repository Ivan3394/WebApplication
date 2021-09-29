/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.ItProduct;
import DB.ItProductDB1;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    @Resource(name = "jdbc/itproduct")
    private DataSource ds;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
            ArrayList<ItProduct> itproducts = ItProductDB1.select();
            req.setAttribute("itproducts", itproducts);
            
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
