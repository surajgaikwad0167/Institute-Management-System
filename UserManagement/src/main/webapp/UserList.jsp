<%@page import="com.usermanagement.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<body>
 <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Institute Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Students</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
        </br>
        <h1><center>INSTITUTE MANAGEMENT PROJECT</center></h1>
       
        <div class="container">
         <hr class="border border-danger border-2 opacity-50"></hr>
        <div>
        <a href="add" class="btn btn-success" href="list">ADD STUDENT</a>
         </div><br>
        <table class="table table-success table-striped">
        <thead>
        <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>CITY</th>
        <th>ACTIONS</th>
         
        </tr>
        </thead>
        <tbody>
       <b:forEach items="${userlist}" var="u">
       <tr>
       <td><b:out value="${u.id}"></b:out></td>
       <td><b:out value="${u.name}"></b:out></td>
       <td><b:out value="${u.email}"></b:out></td>
       <td><b:out value="${u.city}"></b:out></td>
       <td><a href="edit?id=<b:out value="${u.id}"></b:out>">edit</a>&nbsp;/&nbsp;<a href="delete?id=<b:out value="${u.id}"></b:out>">delete</a></td>

       </tr>
       
       </b:forEach>
       
       
        </tbody>
       </div>
</table>
</body>
</html>
