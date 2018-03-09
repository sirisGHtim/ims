/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.CourseDao;
import com.ims.modal.CourseModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stim
 */
public class CourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IMS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Status report at " 
                    + request.getContextPath() + "</h1>");
            out.println("<h1>" + msg + "</h1>");
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
      
        if(request.getRequestURI()
               .equals(request.getContextPath()+"/admin/course/add")){
           RequestDispatcher rd = request.getRequestDispatcher("/addcourse.jsp");
           rd.forward(request, response);
       }else if(request.getRequestURI()
               .equals(request.getContextPath()+"/admin/course/display")){
           // fetch all course information from database
           ArrayList<CourseModel> al = CourseDao.selectAll();
           
            
           request.setAttribute("coursedata", al);
           RequestDispatcher rd = request.getRequestDispatcher("/displaycourse.jsp");
           rd.forward(request, response);
       }
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
        if(request.getRequestURI().equals(request.getContextPath()+"/admin/course/add")){
           String title = request.getParameter("ctitle");
           float price = Float.parseFloat(request.getParameter("cprice"));
           String duration = request.getParameter("cduration");
           
           System.out.println(title+" "+price+" "+duration);
           
        //       Create a model object and insert these values in its fields
       CourseModel cm = new CourseModel(title,price,duration);
       
       // send this modal object to dai inorder to be saved
       if(CourseDao.insert(cm)){
       // redirect to addcourse page
       response.sendRedirect(request.getContextPath()
               +"/admin/course/add");
       }
       else {
           processRequest(request, response, 
                   "Data insertion failed");
       }
       }
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
