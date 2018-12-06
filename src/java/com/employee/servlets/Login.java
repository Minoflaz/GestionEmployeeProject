/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.servlets;

import com.employee.model.Employee;
import com.employee.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "Login", urlPatterns = {"/"})
public class Login extends HttpServlet {
    
    private final String loginPage = "/WEB-INF/login.jsp";
    private final String employeeList = "/WEB-INF/employeeList.jsp";
    private final String employeeDetail = "/WEB-INF/employeeDetail.jsp";

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
        User user = (User)session.getAttribute("user");
        
        String page = this.loginPage;
        
        ArrayList<Employee> employees =  new ArrayList<>();
        
        employees.add(new Employee("Nouvellon","Thomas","090393039","0330303039","0393339","3 rue de la boustipaille","Paris","75012","nouvellon@lol.fr"));
        employees.add(new Employee("Saidani","Alexis","09393389","09333999","039339309","3 rue de la bertide","Paris","75013","saidani@lol.fr"));
        employees.add(new Employee("Chapelle","Pierrick","09393389","09333999","039339309","3 rue de la vaillot","Paris","75020","chapelle@lol.fr"));

        request.setAttribute("employees", employees);
        
        if(request.getParameterMap().containsKey("action") && request.getParameter("action").equals("disconnect")) {
            session.invalidate();
            //response.sendRedirect("/");
            this.getServletContext().getRequestDispatcher( page ).forward( request, response );
        }
        
        //If user is connected
        if(user != null) {
            if( request.getParameterMap().containsKey("employeeId")) {
                page = this.employeeDetail;
            }
            else {
                page = this.employeeList;
            }
        }
        
        this.getServletContext().getRequestDispatcher( page ).forward( request, response );
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
        User user = (User)session.getAttribute("user");
        
        String page = this.loginPage;
        
        ArrayList<Employee> employees =  new ArrayList<>();

        employees.add(new Employee("Nouvellon","Thomas","090393039","0330303039","0393339","3 rue de la boustipaille","Paris","75012","nouvellon@lol.fr"));
        employees.add(new Employee("Saidani","Alexis","09393389","09333999","039339309","3 rue de la bertide","Paris","75013","saidani@lol.fr"));
        employees.add(new Employee("Chapelle","Pierrick","09393389","09333999","039339309","3 rue de la vaillot","Paris","75020","chapelle@lol.fr"));

        request.setAttribute("employees", employees);
        
        //If user is connected
        if(user != null) {
            page = this.employeeList;
        }
        else {            
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            
            if(login.equals("login") && password.equals("pass")) {
                session.setAttribute("message", "Bravo you got into the site bro");
                user = new User(login,password);
                session.setAttribute("user",user);
                
                page = this.employeeList;
            }
            else {
                request.setAttribute("message", "Wrong credentials");
            } 
        }
        
        this.getServletContext().getRequestDispatcher( page ).forward( request, response );
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
