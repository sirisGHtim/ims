<%-- 
    Document   : addstudent
    Created on : Mar 12, 2018, 12:26:51 PM
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
          <a href="">Student</a>
        </li>
        <li class="breadcrumb-item active">Add</li>
      </ol>
      <div class="row">
        <div class="col-9" style="font-size: 1.5em;">
          Add new student
          </div>
      </div> 
    <div class="card card-register mx-auto col-md-9">
      <div class="card-header">New student information </div>
     
      <div class="card-body">
          <div class="col-md-9">
          <form action="${pageContext.request.contextPath}/admin/student/add" method="POST">
           
             
          <div class="form-group">
            <div class="form-row">
              <label for="inputname">Name</label>
              <input class="form-control" name="name" id="inputname" type="text" 
                     placeholder="Enter student name">
            </div>
          </div>
              
          <div class="form-group">
              <div class="form-row">
            <label for="inputcountry">Country</label>
            <select class="form-control" name="country" id="inputcountry">
                <option value="nepal">Nepal</option>
                <option value="india">India</option>
                <option value="bhutan">Bhutan</option>
                <option value="bangladesh">Bangladesh</option>
            </select>
          </div>
          </div>
              
          <div class="form-group">
            <div class="form-row">
             
                <label for="inputgender">Gender</label>
                <div class="form-control" id="inputgender">
                <input name="gender" id="inputgender1" type="radio" value="male"> Male &nbsp;
                <input name="gender" id="inputgender2" type="radio" value="female"> Female &nbsp; 
                </div>
            </div>
          </div>
              
              <div class="form-group">
            <div class="form-row">
              <label for="inputhobbies">Hobby</label>
                <div class="form-control" id="inputhobies">
                <input name="hobbies" id="inputhobbies1" type="checkbox" value="music"> Music &nbsp;
                <input name="hobbies" id="inputhobbies2" type="checkbox" value="coding"> Coding &nbsp;
                <input name="hobbies" id="inputhobbies3" type="checkbox" value="sports"> Sports &nbsp;
                </div>
            </div>
          </div>
              
            <div class="form-group">
            <div class="form-row">
             <div class="col-md-9">
            <input class="btn btn-primary btn-block" type="submit" value="Save" >
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

