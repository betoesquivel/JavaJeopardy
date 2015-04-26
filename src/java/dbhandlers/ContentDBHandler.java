/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandlers;

import beans.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlg
 */
public class ContentDBHandler {
    
    public Connection connection;
    public Statement statement;
    
    public ContentDBHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Category getCategoryById(int id) {
        Category c = new Category();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Category where id="+id+"");
            if(result.next()) {
                c.setId(result.getInt("id"));
                c.setName(result.getString("name"));
                c.setFkClass(Integer.parseInt(result.getString("classId")));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public Category getCategoryByName(String name) {
        Category c = new Category();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
            Statement statement = conn.createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM Category where name='"+name+"'");
            if(result.next()) {
                c.setId(result.getInt("id"));
                c.setName(result.getString("name"));
                c.setFkClass(Integer.parseInt(result.getString("classId")));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categoriesList = new ArrayList<Category>();
        boolean existeUno = false;
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM Category";
            ResultSet results = statement.executeQuery(query);
            
            while(results.next()) {
                existeUno = true;
                int id = results.getInt("id");
                String name = results.getString("name");
                int fkClassId = results.getInt("classId");
                Category c = new Category(id, name, fkClassId);
                categoriesList.add(c);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!existeUno) {
       
            Category c = new Category(1, "query no regreso datos", 3);
            categoriesList.add(c);
        }
        
        return categoriesList;
    } 
    
}
