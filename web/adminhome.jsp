<%-- 
    Document   : adminhome
    Created on : Feb 19, 2018, 12:50:38 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
          <a href="">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Blank Page</li>
      </ol>
        </div>
     
     
      <div class="row">
        <div class="col-12">
          <h1>Blank</h1>
          <p>This is an example of a blank page that you can use as a starting point for creating new ones.</p>
        </div>
      </div>
    </div>
       <jsp:include  page="footer.jsp"/>
        </div>
    </body>
</html>
