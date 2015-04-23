/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandlers;

import beans.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hlg
 */
public class AccountDBHandler {
    
    public Connection connection;
    public Statement statement;
    
    public AccountDBHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void createUser(String username, String password, String email) {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            String query = "insert into User (username, password, email) values ('%s', '%s', '%s');";
            statement.executeUpdate(String.format(query, username, password, email));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateUser(User user) {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            int id = user.getId();
            String password = user.getPassword();
            String email = user.getEmail();
            String query = "UPDATE User set password='%s', email='%s' WHERE id=%d";
            statement.executeUpdate(String.format(query, password, email, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUser(User user) {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            int id = user.getId();
            String password = user.getPassword();
            String email = user.getEmail();
            String query = "DELETE FROM User WHERE id=%d";
            statement.executeUpdate(String.format(query, id));
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User getUserById(int id) {
        User user = new User();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT id, password, email FROM users where id="+id+"");
            if(result.next()) {
                user.setId(result.getInt("id"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public User getUserByUsername(String username) {
        User user = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT id, password, email FROM User where username = '%s'";
            ResultSet result = statement.executeQuery(String.format(query, username));
            if(result.next()) {
                int foundId = result.getInt("id");
                String foundUsername = result.getString("username");
                String foundPassword = result.getString("password");
                String foundEmail = result.getString("email");
                user = new User(foundId, foundUsername, foundPassword, foundEmail);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public User validateUsernamePassword(String username, String password) {
        User user = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT id, password, email FROM User where username = '%s' AND password = '%s'";
            ResultSet result = statement.executeQuery(String.format(query, username, password));
            if(result.next()) {
                int foundId = result.getInt("id");
                String foundUsername = result.getString("username");
                String foundPassword = result.getString("password");
                String foundEmail = result.getString("email");
                user = new User(foundId, foundUsername, foundPassword, foundEmail);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
