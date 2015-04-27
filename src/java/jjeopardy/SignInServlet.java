/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeopardy;

import beans.Mailer;
import dbhandlers.AccountDBHandler;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author betoesquivel
 */
public class SignInServlet extends HttpServlet {

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
        String url = "signin_success.jsp";
        
        
        String username = request.getParameter("username");
        
        //String uuid = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();
        password= password.substring(0, 5);
        String email = request.getParameter("email");
        
        if (username != null && password != null && email != null) {
            accountDB.createUser(username, password, email);
            
            Mailer.send(email, "Jeopardy", password);
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
