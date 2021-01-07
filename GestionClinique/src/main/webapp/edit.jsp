<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier le patient</title>
</head>
<body>
<div align="center">
<form action="edit" method="post"> 
<table border="1" cellpadding=5>
<caption><h1>Formulaire d'affichage le patient de id ${patient.id}</h1></caption>
	<tr>
	<th>CIN: </th>
	<td><input type="text" name="cin" size="45" value="${patient.cin}"/></td>
	</tr>
	<tr>
	<th>Nom: </th>
	<td><input type="text" name="nom"  size="45" value="${patient.nom}"/></td>
	</tr>
	<tr>
	<th>Prenom: </th>
	<td><input type="text" name="prenom"  size="45" value="${patient.prenom}"/></td>
	</tr>
	<tr>
	<th>Telephone: </th>
	<td><input type="number" name="telephone"  size="45" value="${patient.telephone}"/></td>
	</tr>
	<tr>
	<th>Mail: </th>
	<td><input type="text" name="mail"  size="45" value="${patient.mail}"/></td>
	</tr>
	<tr>
	<th>Sexe: </th>
	<td><input type="text" name="sexe"  size="45" value="${patient.sexe}"/></td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Modifier"/>
		</td>
	</tr>
</table>
</form>
</div>
<div align="right"><a href="list">Revenir vers la list des Patient</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="ajout.jsp">Ajouter un patient</a>
</div>
</body>
</html>


