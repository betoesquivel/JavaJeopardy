/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.Category;
import beans.Question;
import com.fasterxml.jackson.jr.ob.JSON;
import dbhandlers.AssetDBHandler;
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

    AssetDBHandler assetDB;
    public void init() throws ServletException {
        assetDB = new AssetDBHandler();
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
        ArrayList<beans.Class> classes = assetDB.getClasses();
        
        String questionsJSON = JSON.std.asString(questions);
        String categoriesJSON = JSON.std.asString(categories);
        String classesJSON = JSON.std.asString(classes);
        
        request.setAttribute("questionsJSON", questionsJSON);
        request.setAttribute("categoriesJSON", categoriesJSON);
        request.setAttribute("classesJSON", classesJSON);
        
        String url = "manage_assets.jsp";
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
        String questionsJSON = (String) map.get("questions");
        ArrayList<Question> questions = (ArrayList<Question>)JSON.std.listOfFrom(
                Question.class, questionsJSON);
        
        int id = -1;

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
