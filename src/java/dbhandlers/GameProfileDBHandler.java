/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandlers;

import beans.Category;
import beans.GameProfile;
import beans.Question;
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
public class GameProfileDBHandler {
    
    public Connection connection;
    public Statement statement;
    
    public GameProfileDBHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public GameProfile createGameProfile(GameProfile game) {
        try {
            Statement statement = connection.createStatement();
            String name = game.getName();
            int userId = game.getId();
            String query = "insert into GameProfile (name, userId) values ('" + name + "'," + userId + ")";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()) {
                game.setId(rs.getInt(1));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(GameProfileDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return game;
    }
    
    public void createQuestionsGameProfile(GameProfile game, ArrayList<Question> questions) {
        Question q;
        for(int i=0; i<questions.size(); i++) {
            q = questions.get(i);
            try {
                statement = connection.createStatement();
                String query = "INSERT INTO QuestionGameProfile (questionId, gameProfileId) values (" + q.getId() + "," + game.getId() + ")";
                statement.executeUpdate(query);
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(GameProfileDBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Logger.getLogger(GameProfileDBHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GameProfileDBHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GameProfileDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!existeUno) {
       
            Category c = new Category(1, "query no regreso datos", 3);
            categoriesList.add(c);
        }
        
        return categoriesList;
    } 
    
}
