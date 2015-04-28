/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.GameProfile;
import beans.Question;
import dbhandlers.AssetDBHandler;
import dbhandlers.GameDBHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LuisAlberto
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {

        GameDBHandler gameDB;
        AssetDBHandler assetDB;
    public void init() throws ServletException {
        gameDB = new GameDBHandler();
        assetDB = new AssetDBHandler();
    }
    /**


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
        String action = request.getParameter("action");
        String url = "error.jsp";
        if(action.equals("start")){
            List<GameProfile> profiles = gameDB.getProfiles();
            request.setAttribute("profiles", profiles);
            url="jeopardy.jsp";
        }else if(action.equals("profile")){
            String e1 = request.getParameter("team1Name");
            String [] eP=request.getParameterValues("team1");
            String e2 = request.getParameter("team2Name");
            String [] eP2=request.getParameterValues("team2");
            int[] ids=gameDB.saveTeam(e1,eP,e2,eP2);
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<Question> questions= assetDB.getGameProfileQuestions(id);
            request.setAttribute("questions", questions);
            request.setAttribute("gI", ids[0]);
            request.setAttribute("t1I", ids[1]);
            request.setAttribute("t2I", ids[2]);
            url="game.jsp";
        }else if(action.equals("end")){
            String score1= request.getParameter("score1");
            String score2= request.getParameter("score2");
            String team1= request.getParameter("team1Id");
            String team2= request.getParameter("team2Id");
            String gameId= request.getParameter("gameId");
            Integer.parseInt(gameId);
            gameDB.saveGame(Integer.parseInt(gameId),Integer.parseInt(team1),Integer.parseInt(team2),Integer.parseInt(score1),Integer.parseInt(score2));
            url="home.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
