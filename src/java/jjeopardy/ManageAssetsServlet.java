/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.Category;
import beans.Question;
import beans.Class;
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
public class ManageAssetsServlet extends HttpServlet {

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
        ArrayList<Class> classes = assetDB.getClasses();
        
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
        
        String action = (String) map.get("action");
        
        int id = -1;
        if (action.equalsIgnoreCase("delete")){
            id = deleteRow(map);
        }else {
            id = updateRow(map);
        }

        response.setContentType("application/json");
        PrintWriter out = new PrintWriter(response.getWriter());
        out.print(String.format("{\"id\":%d}",id));
        out.close();
        
        
    }

    public int updateRow(Map<String, Object> map) throws IOException{
        String classType = (String) map.get("type");
        String objectJSON = (String) map.get("object");
        int id = -1;
        //Check class of object sent
        switch(classType){
            case "Question":
                Question receivedQuestion = JSON.std.beanFrom(Question.class, objectJSON);
                id = receivedQuestion.getId();
                if (id == -1) {
                    id = assetDB.createQuestion(receivedQuestion);
                }else {
                    assetDB.updateQuestion(receivedQuestion);
                }
                break;
            case "Category":
                Category receivedCategory = JSON.std.beanFrom(Category.class, objectJSON);
                id = receivedCategory.getId();
                if (id == -1) {
                    id = assetDB.createCategory(receivedCategory);
                }else {
                    assetDB.updateCategory(receivedCategory);
                }
                break;
            case "Class":
                Class receivedClass = JSON.std.beanFrom(Class.class, objectJSON);
                id = receivedClass.getId();
                if (id == -1) {
                    id = assetDB.createClass(receivedClass);
                }else {
                    assetDB.updateClass(receivedClass);
                }
                break;
        }
        
        return id;
    }
    
    public int deleteRow(Map<String, Object> map) throws IOException{
        String classType = (String) map.get("type");
        int id = (int) map.get("object");
        //Check class of object sent
        switch(classType){
            case "Question":
                if (id != -1) {
                    assetDB.deleteQuestion(id);
                }
                break;
            case "Category":
                if (id != -1) {
                    assetDB.deleteCategory(id);
                }
                break;
            case "Class":
                if (id != -1) {
                    assetDB.deleteClass(id);
                }
        }
        
        return id;
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
