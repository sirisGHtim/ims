/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.StudentDao;
import com.ims.modal.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author stim
 */
@WebServlet({"/admin/student/add","/admin/student/display","/admin/student/edit"})
public class StudentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IMS error</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet operation at " + msg + "</h1>");
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
        String url = request.getRequestURI();
        String cp = request.getContextPath();
        
        if(url.equals(cp+"/admin/student/add")){
            request.getRequestDispatcher("/addstudent.jsp").forward(request, response);
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
        
        String url = request.getRequestURI();
        String cp  = request.getContextPath();
        
        if(url.equals(cp+"/admin/student/add")){
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            String gender = request.getParameter("gender");
//            String[] hobby = request.getParameterValues("hobbies");
//            String hobbies = "";
//            for(int i=0;i<hobby.length;i++){
//                if(i==0){
//                    hobbies = hobby[0];
//                }
//                else{
//                    hobbies +=", "+hobby[i];
//                }
//            }

// alternative approach
            String hobbies = Arrays.toString(request.getParameterValues("hobbies"));


            System.out.println(name);
            System.out.println(country);
            System.out.println(gender);
            System.out.println(hobbies);
            
            Student s = new Student(name,country,gender,hobbies);
            
            if(StudentDao.addStudent(s)){
                response.sendRedirect(cp+"/admin/student/add");
            }else{
                processRequest(request,response,"Student information could not be save into database!");
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
