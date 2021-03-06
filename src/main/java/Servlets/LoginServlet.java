/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.UsersDAO;
import POJOS.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farjad
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
    
        
        UsersDAO user = new UsersDAO();
        User uai = user.GetUserByEmail(email);
        
        System.out.println("Debug point 1");
        PrintWriter out= response.getWriter();
        out.println("<font color=red>Pass: "+ uai.getPassword() + "</font>");
        
        try{
            out.println("<font color=red>Debug Point 1.5</font>");
            if(uai.getPassword().equals(password)){
                
                out.println("<font color=red>Debug Point 1</font>");
                
                HttpSession session = request.getSession();

                session.setAttribute("user", uai);
                session.setMaxInactiveInterval(60*60*24);

                String encodedURL = response.encodeRedirectURL("MainLanding.jsp");
                response.sendRedirect(encodedURL);
            }else{
                
                //RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                out.println("<font color=red>Debug Point 2</font>");
                out.println("<font color=red>Either user name or password is wrong.</font>");
                //rd.include(request, response);
            }
            
        }catch(Exception e){
            System.err.println("Error:" + e);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
