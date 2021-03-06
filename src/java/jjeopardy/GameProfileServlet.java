/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.Category;
import beans.Question;
import beans.Class;
import beans.GameProfile;
import beans.User;
import com.fasterxml.jackson.jr.ob.JSON;
import dbhandlers.AssetDBHandler;
import dbhandlers.GameProfileDBHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author betoesquivel
 */
public class GameProfileServlet extends HttpServlet {

    GameProfileDBHandler gameProfileDB;
    AssetDBHandler assetDB;
    public void init() throws ServletException {
        assetDB = new AssetDBHandler();
        gameProfileDB = new GameProfileDBHandler();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String input = JSON.std.asString(map);
        
        ArrayList<Question> questions = assetDB.getQuestions();
        ArrayList<Category> categories = assetDB.getCategories();
        ArrayList<Class> classes = assetDB.getClasses();

        String questionsJSON = JSON.std.asString(questions);
        String categoriesJSON = JSON.std.asString(categories);
        String classesJSON = JSON.std.asString(classes);
        
        request.setAttribute("questionsJSON", questionsJSON);
        request.setAttribute("categoriesJSON", categoriesJSON);
        request.setAttribute("classesJSON", classesJSON);
        
        String url = "create_game_profile.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Map<String,Object> map = JSON.std.mapFrom(INPUT);
        
        //Get json data parameter
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        try{
            json = br.readLine();
        }catch(IOException e){
            System.out.println(e);
        }
        //Parse to a map
        Map<String, Object> map = JSON.std.mapFrom(json);
        String name = (String) map.get("name");
        ArrayList<String> questions = (ArrayList<String>) map.get("questions");
        
        GameProfile newProfile = new GameProfile();
        User user = (User) request.getSession().getAttribute("user");
        newProfile.setName(name);
        newProfile.setUserId(user.getId());
        newProfile = gameProfileDB.createGameProfile(newProfile);
        
        gameProfileDB.createQuestionsGameProfile(newProfile, questions);
        
        int id = newProfile.getId();

        response.setContentType("application/json");
        PrintWriter out = new PrintWriter(response.getWriter());
        out.print(String.format("{\"id\":%d}",id));
        out.close();
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
