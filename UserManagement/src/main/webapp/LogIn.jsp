<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body >

<form action="validate" method="post">
<div class="card-body">
<div class="container" align="center" style="padding-top:100px;">
<div class="card" style="width:25rem;height:25rem">
<h1><center><b><u>Log In</u></b></center></h1><br>
 
<div class="name">
  <label for="name" class="form-label"></label>
  <input type="text" class="form-control" id="name" name="name" placeholder="Email Address" style="width:300px" required>
</div>
<div class="pass">
  <label for="pass" class="form-label"></label>
  <input type="password" class="form-control" id="pass" name="pass" placeholder="Enter password"  style="width:300px" required>
</div>
<br>
 <div class="col-12">
    <button type="submit" class="btn btn-success" style="width:300px">Log In</button>
  </div>
 </div>
 </div>
 </div>
  </form>
</body>
</html>
