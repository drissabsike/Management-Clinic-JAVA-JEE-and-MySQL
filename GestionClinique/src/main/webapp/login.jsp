<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login</title>
</head>
<%
session.invalidate();
%>
<style>

body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: url(file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/banner_bg.png) no-repeat;
  background-size: cover;
  background-color: blue;
}
.login-box{
  width: 280px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  color: white;
}
.login-box h1{
  float: left;
  font-size: 40px;
  border-bottom: 6px solid #14EEA9;
  margin-bottom: 50px;
  padding: 13px 0;
}
.textbox{
  width: 100%;
  overflow: hidden;
  font-size: 20px;
  padding: 8px 0;
  margin: 8px 0;
  border-bottom: 1px solid #14EEA9;
}
.textbox i{
  width: 26px;
  float: left;
  text-align: center;
}
.textbox input{
  border: none;
  outline: none;
  background: none;
  color: white;
  font-size: 18px;
  width: 80%;
  float: left;
  margin: 0 10px;
}
.btn{
  width: 100%;
  background: none;
  border: 2px solid #14EEA9;
  color: white;
  padding: 5px;
  font-size: 18px;
  cursor: pointer;
  margin: 12px 0;
}




</style>
 <body>
 <form action=login method="post"> 
 <img src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/favicon.png"><b>MAOD-MEDIC</b></img>
<div class="login-box">
  <h1>Login</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" name="mail" placeholder="Username" required="required"/>
  </div>

  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" name="cin"  placeholder="Password" required="required"/>
  </div>

  <input type="submit" class="btn"  value="Login"/>
  <div align="center">
<a href="ajout.jsp"><span class="glyphicon glyphicon-log-in">Creation nouveau Compte !</span></a></div>
</div>
</form>

  </body>

</html>