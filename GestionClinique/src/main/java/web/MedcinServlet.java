package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Medcin_Imp_Inter_M;
import metier.medcin;
import metier.receptionniste;

@WebServlet("/ModifierMed")
public class MedcinServlet extends HttpServlet{
Medcin_Imp_Inter_M dao;
MedcinModel model;
String notification="";
String urlServlet="";

@Override
public void init() throws ServletException{
	 dao = new Medcin_Imp_Inter_M();
	 model = new MedcinModel();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	urlServlet = request.getServletPath();
	try{
		ModifierMed(request,response);
	 	}catch(Exception e) {
	  System.out.println("erreur sur la methode doPost dans la servletde medcin :"+e.getMessage());
 }
}

private void ModifierMed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	System.out.println("Dans la servlet /update Modifier Medcin  avec url "+urlServlet);
	model.setM((medcin) request.getSession().getAttribute("medcin"));
	String cin =request.getParameter("cin");
	String nom =request.getParameter("nom");
	String prenom =request.getParameter("prenom");
	String address =request.getParameter("address");
	int telephone = Integer.parseInt(request.getParameter("telephone"));
	String mail =request.getParameter("mail");
	String specialite=request.getParameter("specialite");
	model = new MedcinModel(cin, nom, prenom, address, telephone, mail, specialite);
	dao.updateMed(model.getM());
	System.out.println("receptionniste de CIN"+cin+"est Modifier avec success !");
	request.getRequestDispatcher("medcineProfile.jsp").forward(request, response);
	
}
}