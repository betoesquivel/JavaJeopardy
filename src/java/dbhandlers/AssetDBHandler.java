/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandlers;

import beans.Category;
import beans.Question;
import beans.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles access to all game assets: Questions, Categories, Classes, GameProfiles
 * @author betoesquivel
 */
public class AssetDBHandler {
    public Connection connection;
    public Statement statement;
    
    public AssetDBHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int createQuestion(Question q) {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            String query = "insert into Question (question, answer, difficulty, categoryId) values ('%s', '%s', %d, %d);";
            statement.executeUpdate(String.format(query, q.getQuestion(), q.getAnswer(), q.getLevel(), q.getFkCategory()),
            Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int createCategory(Category c) {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            String query = "insert into Category (name, classId) values ('%s', %d);";
            statement.executeUpdate(String.format(query, c.getName(), c.getFkClass()),
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } 
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int createClass(Class c) {
        try {
            statement = connection.createStatement();
            String query = "insert into Class (name) values ('%s');";
            statement.executeUpdate(String.format(query, c.getName()),
            Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs != null && rs.next()) {
                return rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void updateQuestion(Question q) {
        try {
            statement = connection.createStatement();
            int id = q.getId();
            String question = q.getQuestion();
            String answer = q.getAnswer();
            int difficulty = q.getLevel();
            int categoryId = q.getFkCategory();
            
            String query = "UPDATE Question SET question='%s', answer='%s', difficulty=%d, categoryId=%d WHERE id=%d";
            statement.executeUpdate(String.format(query, question, answer, difficulty, categoryId, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateCategory(Category c) {
        try {
            statement = connection.createStatement();
            int id = c.getId();
            String name = c.getName();
            int classId = c.getFkClass();
            
            String query = "UPDATE Category SET name='%s', classId=%d WHERE id=%d";
            statement.executeUpdate(String.format(query, name, classId, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateClass(Class c) {
        try {
            statement = connection.createStatement();
            int id = c.getId();
            String name = c.getName();
            
            String query = "UPDATE Class SET name='%s' WHERE id=%d";
            statement.executeUpdate(String.format(query, name, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteQuestion(int id) {
        try {
            statement = connection.createStatement();
            
            String query = "DELETE FROM Question WHERE id=%d";
            statement.executeUpdate(String.format(query, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteCategory(int id) {
        try {
            statement = connection.createStatement();
            
            String query = "DELETE FROM Category WHERE id=%d";
            statement.executeUpdate(String.format(query, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteClass(int id) {
        try {
            statement = connection.createStatement();
            
            String query = "DELETE FROM Class WHERE id=%d";
            statement.executeUpdate(String.format(query, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Question> getQuestions(){
        Question q;
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            statement = connection.createStatement();
            String query = "SELECT id, question, answer, difficulty, categoryId FROM Question;";
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                int id = result.getInt("id");
                String question = result.getString("question");
                String answer = result.getString("answer");
                int difficulty = result.getInt("difficulty");
                int categoryId = result.getInt("categoryId");

                q = new Question(id, question, answer, difficulty, categoryId);
                questions.add(q);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    public ArrayList<Category> getCategories(){
        Category c;
        ArrayList<Category> categories = new ArrayList<Category>();
        try {
            statement = connection.createStatement();
            String query = "SELECT id, name, classId FROM Category;";
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int classId = result.getInt("classId");

                c = new Category(id, name, classId);
                categories.add(c);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    public ArrayList<Class> getClasses(){
        Class c;
        ArrayList<Class> classes = new ArrayList<Class>();
        try {
            statement = connection.createStatement();
            String query = "SELECT id, name FROM Class;";
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");

                c = new Class(id, name);
                classes.add(c);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }
    
}
