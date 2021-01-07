<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter une Receptionniste</title>
</head>
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Admin : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#96FADA">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/reservation.png" width=100 height=100>
<form action="Ajout_rec" method="post"> 
<table border="1" cellpadding=5>
	<caption><h1>Pour Ajouter Une receptionniste veuillez utilisé  le Formulaire suivant :</h1></caption>
	
	<tr>
	<th>CIN: </th>
	<td><input type="text" name="cin" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Nom: </th>
	<td><input type="text" name="nom" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Prenom: </th>
	<td><input type="text" name="prenom" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Telephone</th>
	<td><input type="text" name="telephone" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Address: </th>
	<td><input type="text" name="address" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Mail: </th>
	<td><input type="text" name="mail" size="45" required="required"/></td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Ajouter"/>
		</td>
	</tr>

</table>
</form>
</div>
<div align="right"><a href="index.jsp">Revenir vers le Menu</a><br></div>
</body>
</html>