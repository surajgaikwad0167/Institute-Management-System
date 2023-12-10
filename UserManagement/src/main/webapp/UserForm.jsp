<%@page import="com.usermanagement.bean.UserBean"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<body>
 <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">UserManagement</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Users</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
       <u:if test="${user==null}">
       <form action="insert" method="post">
       </u:if>
         <u:if test="${user!=null}">
       <form action="update" method="post">
       </u:if>
 
<div class="card-body">
<div class="container" align="center" style="padding-top:100px;">
<div class="card" style="width:25rem;height:25rem">

   <u:if test="${user==null}">
<h1><center><b><u>ADD USER</u></b></center></h1><br>
 </u:if>
 
   <u:if test="${user!=null}">
<h1><center><b><u>EDIT USER</u></b></center></h1><br>
 </u:if>
<div class="mb-3"> 
  <input type="hidden" class="form-control" id="id" name="id" value="${user.id}" style="width:300px" required>
</div>
<div class="mb-3">
  <label for="name" class="form-label">User Name :</label>
  <input type="text" class="form-control" id="name" name="name" value="${user.name}" style="width:300px" required>
</div>
<div class="mb-3">
  <label for="email" class="form-label">Email :</label>
  <input type="email" class="form-control" id="email" name="email"  value="${user.email}"  style="width:300px" required>
</div>
<div class="mb-3">
  <label for="city" class="form-label">City :</label>
  <input type="text" class="form-control" id="city" name="city"  value="${user.city}"  style="width:300px" required>
</div>
<br>
 <div class="col-12">
    <button type="submit" class="btn btn-success" style="width:300px">SAVE</button>
  </div>
 </div>
 </div>
 </div>
  </form>
</body>
</html>