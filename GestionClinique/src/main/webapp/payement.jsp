<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<head>
<meta charset="UTF-8">
<style><%@include file="/css/payStyle.css"%></style>
</head>
<%
if(session.getAttribute("cin")==null && session.getAttribute("id")==null ){
	response.sendRedirect("login.jsp");		
}

int id =(int)session.getAttribute("id");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
String req="select patient.cin ,patient.nom ,patient.prenom ,patient.telephone ,consultation.Description ,consultation.prix from consultation ,patient WHERE consultation.cin=patient.cin and consultation.id=?";
PreparedStatement ps = con.prepareStatement(req);
ps.setInt(1,id);
ResultSet rs = ps.executeQuery();
while(rs.next()) { %>
<h2 class="glyphicon glyphicon-log-in">Payement Online</h2>
<body>
 <form method="POST" action="addFacture">
    <div class="form-container">
      <div class="personal-information">
        <h1>Information de Payment</h1>
      </div> 
          <input id="column-left" type="text" readonly name="nom" value="<%=rs.getString("nom")%>"/>
          <input id="column-right" type="text"  readonly  name="prenom" value="<%=rs.getString("prenom")%>"/>
          <input id="input-field" type="text" readonly name="cin" value="<%=rs.getString("cin")%>"/>
          <input id="column-left" type="text"  readonly name="telephone" value="<%=rs.getString("telephone")%>" required/>
          <input id="input-field" type="text"  readonly name="desc"  value="<%=rs.getString("Description")%>"/>
           <div class="personal-information">
        <h1>Information de La Carte Bancaire</h1>
      </div>
       	<label><b>Card Number:</b></label>  <input id="input-field" type="text"  name="cartnumber" />
        <label><b>CVV2 :</b></label><input id="input-field"  type="text"  name="cvv"  required/>
        <label><b>Expires :</b></label><input id="input-field" type="text"  name="expire"  /> 
       	<label><b>Prix Total :</b></label><input id="input-field" readonly type="text" name="prix" value="<%=rs.getString("prix")%>"/>
      <input  id="input-button" name="submit" type="submit" value="Valide"/>
    </div>
    </form>
<% } %>
<script type="text/javascript">
    $('form').card({
    container: '.card-wrapper',
});
  </script>

