<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un patient</title>
</head>
<body>
<div align="center">
<form action="ajout" method="post"> 
<table border="1" cellpadding=5>
	<caption><h1>Formulaire d'ajout des Patients</h1></caption>
	
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
	<th>Mail: </th>
	<td><input type="text" name="mail" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Le Sexe: </th>
	<td><select name="sexe" required="required">
	  <option selected>-----Select-----</option>
	  <option value="male" >male</option>
	  <option value="femelle">femelle</option>
	</select></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Ajouter"/>
		</td>
	</tr>

</table>
</form>
</div><br>
<div align="center">
<a href="login.jsp"><span class="glyphicon glyphicon-log-in">Login!</span></a></div>
</body>
</html>