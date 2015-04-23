/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.User;
import dbhandlers.AccountDBHandler;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author betoesquivel
 */
public class LoginServlet extends HttpServlet {
    
    AccountDBHandler accountDB;
    public void init() throws ServletException {
        accountDB = new AccountDBHandler();
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
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        String url = "login.jsp";
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = null;
        
        session = request.getSession();
        if (accountDB == null) {
            url = "login.jsp";
        }else if ( (user = accountDB.validateUsernamePassword(username, password) ) == null) {
            url = "signin.jsp";
        }else {
            session.setAttribute("user", user);
            url = "Home";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        
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
