/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.servlets;

import com.employee.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alexis
 */
@WebServlet(name = "Employees", urlPatterns = {"/Employees"})
public class Employees extends HttpServlet {
    
    private final String loginPage = "/WEB-INF/login.jsp";
    private final String employeeList = "/WEB-INF/employeeList.jsp";

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Employees</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Employees at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        HttpSession session = request.getSession();
        
        String message = (String) session.getAttribute("message");
        request.setAttribute("message", message);
        
        ArrayList<User> users =  new ArrayList<>();
        
        users.add(new User("Nouvellon","Thomas","090393039","0330303039","0393339","3 rue de la boustipaille","Paris","75012","nouvellon@lol.fr"));
        users.add(new User("Saidani","Alexis","09393389","09333999","039339309","3 rue de la bertide","Paris","75013","saidani@lol.fr"));
        users.add(new User("Chapelle","Pierrick","09393389","09333999","039339309","3 rue de la vaillot","Paris","75020","chapelle@lol.fr"));
        
        request.setAttribute("users", users);
        
        this.getServletContext().getRequestDispatcher( this.employeeList ).forward( request, response );
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
