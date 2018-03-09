<%-- 
    Document   : displaycourse
    Created on : Mar 8, 2018, 12:27:49 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%--<%@include file="pageheader.jsp" %>--%>
        <jsp:include  page="pageheader.jsp"/>
       
        
    </head>
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        
        <div class="content-wrapper">
            <jsp:include  page="header.jsp"/>
        
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      
        <div>
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="">Course</a>
        </li>
        <li class="breadcrumb-item active">Display</li>
      </ol>
        </div>
     
     <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Course information </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Title</th>
                  <th>Price</th>
                  <th>Duration</th>
                  <th>Edit</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>ID</th>
                  <th>Title</th>
                  <th>Price</th>
                  <th>Duration</th>
                  <th>Edit</th>
                  <th>Delete</th>
                </tr>
              </tfoot>
              <tbody>
                  <c:forEach items="${coursedata}" var="course">
                <tr>
                  <td>${course.id}</td>
                  <td>${course.title}</td>
                  <td>${course.price}</td>
                  <td>${course.duration}</td>
                  <td><a href="${cp}/admin/course/edit?id=${course.id}">Edit</a></td>
                  <td><a href="${cp}/admin/course/delete?id=${course.id}">Delete</a></td>
                </tr>
                  </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
      
      
    </div>
       <jsp:include  page="footer.jsp"/>
        </div>
    </body>
</html>
