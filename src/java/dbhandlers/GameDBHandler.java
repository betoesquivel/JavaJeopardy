/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandlers;

import beans.GameProfile;
import beans.Question;
import beans.Team;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            List<GameProfile> profiles = new ArrayList<>();
            while (rs.next()) {
                GameProfile prof = new GameProfile();
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
    public List<Team> results() {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            String query = "select name,SUM(score) as score, count(winner) as wins from team left join gameresults on gameresults.winner=team.id group by name;";

            ResultSet rs = statement.executeQuery(query);
            List<Team> profiles = new ArrayList<>();
            while (rs.next()) {
                Team t = new Team();
                t.setName(rs.getString("name"));
                t.setScore(rs.getInt("score"));
                t.setWins(rs.getInt("wins"));
                profiles.add(t);
            }
            statement.close();
            return profiles;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  public int saveGame(int g, int t1, int t2, int s1, int s2) {
        try {
             statement = connection.createStatement();
           int winner=0;
           if(s1>s2)
               winner=t1;
           else
               winner=t2;
           if(s1==s2){
               
            String query = "UPDATE gameresults set winner='%d' WHERE id=%d";
            statement.executeUpdate(String.format(query, 0, g));
           }else {
            String query = "UPDATE gameresults set winner='%d' WHERE id=%d";
            statement.executeUpdate(String.format(query, winner, g));
           }
            String query = "UPDATE team set score='%d' WHERE id=%d";
            statement.executeUpdate(String.format(query, s1, t1));
            query = "UPDATE team set score='%d' WHERE id=%d";
            statement.executeUpdate(String.format(query, s2, t2));
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int[] saveTeam(String e, String[] eP, String e2, String[] eP2) {
        try {
            int [] ids=new int[3];
            statement = connection.createStatement();
            Date d = new Date();
            String newstring = new SimpleDateFormat("yyyy-MM-dd").format(d);
            // el id del user no importa porque tiene Autoincrement.
            String query = "insert into gameresults (winner, date) values ('" + 0 + "', '" + newstring + "');";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int id1 = 0;
            if (rs.next()) {
                id1 = rs.getInt(1);
            }
            ids[0]= id1;
            query = "insert into team (gameId, name) values ('" + id1 + "', '" + e + "');";
            int id = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ids[1]=id;
            for (String s : eP) {
                if (s.equals("")) {
                    continue;
                }
                query = "insert into participant (teamId,name) values ( '" + id + "', '" + s + "');";
                statement.executeUpdate(query);

            }
            //2
            query = "insert into team (gameId, name) values ('" + id1 + "', '" + e2 + "');";
            id = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
             rs = statement.getGeneratedKeys();
            id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ids[2]=id;
            for (String s : eP2) {
                if (s.equals("")) {
                    continue;
                }
                query = "insert into participant (teamId,name) values ( '" + id + "', '" + s + "');";
                statement.executeUpdate(query);

            }
            statement.close();
            return ids;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Question> getQuestions(int id) {
        try {
            statement = connection.createStatement();
            // el id del user no importa porque tiene Autoincrement.
            String query = "select * from questiongameprofile LEFT OUTER JOIN question\n"
                    + "ON questiongameprofile.questionId=question.id LEFT OUTER JOIN category ON question.categoryId=category.id where gameProfileId = '%s';";

            ResultSet rs = statement.executeQuery(String.format(query, id));
            List<Question> questions = new ArrayList<>();
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setAnswer(rs.getString("answer"));
                q.setQuestion(rs.getString("question"));
                q.setLevel(rs.getInt("difficulty"));
                q.setCategory(rs.getString("name"));

                questions.add(q);
            }
            statement.close();
            return questions;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
