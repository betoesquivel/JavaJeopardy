/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.User;
import dbhandlers.AccountDBHandler;
import java.io.IOException;
import java.util.ArrayList;
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
        String url = "login.jsp";
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = null;
        
        session = request.getSession();
        if (accountDB == null || isInvalidUser(username, (ArrayList<String>)session.getAttribute("invalidUsers"))) {
            url = "login.jsp";
        }else if ( (user = accountDB.validateUsernamePassword(username, password) ) == null) {
            if(session.getAttribute("loginAttempts") != null) {
                int attempts = (int) session.getAttribute("loginAttempts");
                attempts += 1;
                session.setAttribute("loginAttempts", attempts);
                session.setAttribute("statusLoginAttempt", "fail");
                if(attempts == 3) {
                    url = "accountBlocked.jsp";
                    session.setAttribute("loginAttempts", 0);
                    session.setAttribute("statusLoginAttempt", "success");
                    
                    ArrayList<String> users;
                    if ((users = (ArrayList<String>)session.getAttribute("invalidUsers")) == null ){
                        users = new ArrayList<String>();
                        users.add (username );
                    }else {
                        users.add (username );
                    }
                    
                    session.setAttribute("invalidUsers", users);
                }
            } else {
                session.setAttribute("loginAttempts", 1);
                session.setAttribute("statusLoginAttempt", "fail");
            }
        }else {
            if(accountDB.isValidAccount(username, password)) {
                session.setAttribute("statusLoginAttempt", "invalidAccount");
            } else {
                session.setAttribute("statusLoginAttempt", "success");
            }
            session.setAttribute("user", user);
            session.setAttribute("loginAttempt", 0);
            
            url = "Home";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        
    }

    public boolean isInvalidUser(String user, ArrayList<String> invalidUsers) {
        if (invalidUsers == null) {
            return false; 
        }
        for (String invalidUser : invalidUsers) {
            if (user.equalsIgnoreCase(invalidUser)){
                return true;
            }
        }
        return false;
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
