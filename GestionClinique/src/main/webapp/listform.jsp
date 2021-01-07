<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
    %>
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Admin : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#B1F607">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/reservation.png" width=100 height=100>
<form action="list" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:#F63A07;color:white;font-size:35;">la liste des Patients de la Clinique</caption>
		<tr>
		<th style="th">ID</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Telephone</th>
		<th>Mail</th>
		<th>Sexe</th>
		<th>Service</th>
		</tr>
		<c:forEach var="patient" items="${list}">
		<tr>
		<td><c:out value="${patient.id}"/></td>
		<td><c:out value="${patient.nom}"/></td>
		<td><c:out value="${patient.prenom}"/></td>
		<td><c:out value="${patient.telephone}"/></td>
		<td><c:out value="${patient.mail}"/></td>
		<td><c:out value="${patient.sexe}"/></td>
		<td>
		<!--<a href="afficher?id=${patient.id}">Modifier</a> -->
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="delete?id=<c:out value="${patient.id}"/>">Supprimer</a>
		</td>
		</tr>
		</c:forEach>
		</table>
	</div>
</form><br>
<div align="center"><a href="index.jsp">Le Menu</a><br></div>
</body>
</html>







