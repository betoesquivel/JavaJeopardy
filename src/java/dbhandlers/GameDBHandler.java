/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandlers;

import beans.GameProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuisAlberto
 */
public class GameDBHandler {

    public Connection connection;
    public Statement statement;
    public GameDBHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public List<GameProfile> getProfiles() {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            String query = "select * from gameprofile;";
            
            ResultSet rs = statement.executeQuery(query);
            List<GameProfile> profiles= new ArrayList<>();
        while (rs.next())
        {
           GameProfile prof= new GameProfile();
           prof.setId(Integer.parseInt(rs.getString("id")));
           prof.setName(rs.getString("name"));
           profiles.add(prof);
        }
            statement.close();
            return profiles;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
