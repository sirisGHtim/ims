<%-- 
    Document   : editcourse
    Created on : Mar 9, 2018, 1:00:21 PM
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
        <jsp:include  page="header.jsp"/>
        
        <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="">Course</a>
        </li>
        <li class="breadcrumb-item active">Edit</li>
      </ol>
      <div class="row">
        <div class="col-9" style="font-size: 1.5em;">
          Edit course
          </div>
      </div> 
    <div class="card card-register mx-auto col-md-9">
      <div class="card-header">Change Course Information </div>
     
      <div class="card-body">
          <div class="col-md-9">
          <form action="${pageContext.request.contextPath}/admin/course/update" method="POST">
           
           <div class="form-group">
            <div class="form-row">
              <label for="inputTitle">Course ID</label>
              <input class="form-control" name="cid" id="inputId" type="text" 
                     value="${coursedata.get(0).id}" readonly>
            </div>
          </div>
              
          <div class="form-group">
            <div class="form-row">
              <label for="inputTitle">Title</label>
              <input class="form-control" name="ctitle" id="inputTitle" type="text" 
                     value="${coursedata.get(0).title}">
            </div>
          </div>
              
          <div class="form-group">
              <div class="form-row">
            <label for="inputPrice">Price</label>
            <input class="form-control" name="cprice" id="inputPrice" type="text"
                   value="${coursedata.get(0).price}">
          </div>
          </div>
              
          <div class="form-group">
            <div class="form-row">
             
                <label for="inputDuration">Duration</label>
                <input class="form-control" name="cduration" id="inputDuration" type="text"
                       value="${coursedata.get(0).duration}">
              
            </div>
          </div>
            <div class="form-group">
            <div class="form-row">
             <div class="col-md-9">
            <input class="btn btn-primary btn-block" type="submit" value="Update" >
              </div>
            </div>
            </div>
             
            </form>
          </div>
      </div>
    </div>
       
    </div>
       <jsp:include  page="footer.jsp"/>
        </div>
    </body>
</html>


