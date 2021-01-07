package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.receptionniste_impl_interf;
import metier.receptionniste;

@WebServlet("/modifierRep")
public class RecepServlet extends HttpServlet{
	receptionniste_impl_interf dao;
	RecepModel model;
	String notification="";
	String urlServlet="";
	
	@Override
	 public void init() throws ServletException{
		 dao = new receptionniste_impl_interf();
		 model = new RecepModel();
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		urlServlet = request.getServletPath();
		try{
			ModifierRece(request,response);
		 	}catch(Exception e) {
		  System.out.println("erreur sur la methode doPost :"+e.getMessage());
	  }
	
}
	//Modification
	private void ModifierRece(HttpServletRequest req, HttpServletResponse res) throws SQLException ,IOException , ServletException {
		//test
		System.out.println("Dans la servlet /update Modifier Rece  avec url "+urlServlet);
		model.setE((receptionniste) req.getSession().getAttribute("receptionniste"));
		String cin =req.getParameter("cin");
		String nom =req.getParameter("nom");
		String prenom =req.getParameter("prenom");
		int telephone = Integer.parseInt(req.getParameter("telephone"));
		String address =req.getParameter("address");
		String mail =req.getParameter("mail");
		model = new RecepModel(cin, nom, prenom, telephone, address, mail);
		dao.updateRep(model.getE());
		System.out.println("receptionniste de CIN"+cin+"est Modifier avec success !");
		req.getRequestDispatcher("showR.jsp").forward(req, res);
		}
}
