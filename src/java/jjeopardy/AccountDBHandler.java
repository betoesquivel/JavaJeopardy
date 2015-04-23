/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

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
    
    public AccountDBHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void storeUser(User user) {
        try {
            Statement statement = connection.createStatement();
            String userid = user.getUserId();
            String password = user.getPassword();
            String email = user.getEmail();
            String query = "insert into users (userid, password, email) values ('" + userid + "','" + password + "','" + email + "')";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User getUser(String userid) {
        User user = new User();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT userid, password, email FROM users where userid='"+userid+"'");
            if(result.next()) {
                user.setUserId(result.getString("userid"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
}
