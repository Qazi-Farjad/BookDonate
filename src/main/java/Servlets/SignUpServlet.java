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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farjad
 */
public class SignUpServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        String addr = "N/A";
        String city = "N/A";
        String country = "N/A";
        String organization = "N/A";
        
        UsersDAO userDAO = new UsersDAO();
        System.out.println("Debug point 1");
        User chk = userDAO.GetUserByEmail(email);
        if( chk == null){
            User us = new User(name, organization, email, password, city, country);
            
            userDAO.AddUser(us);
            chk = userDAO.GetUserByEmail(email);
            System.out.println("Debug point 1");
            try{

                HttpSession session = request.getSession();

                session.setAttribute("user", chk);
                session.setMaxInactiveInterval(60*60*24);
                System.out.println("Debug point 2");
                String encodedURL = response.encodeRedirectURL("MainLanding.jsp");
                response.sendRedirect(encodedURL);
                System.out.println("Debug point 3");
                
            }catch(Exception e){
                System.err.println("Error:" + e);
            }
        }
        else{
            //TODO Add a proper error page
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SearchServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error in SignUp </h1>");
                out.println("</body>");
                out.println("</html>");
            
            }
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
