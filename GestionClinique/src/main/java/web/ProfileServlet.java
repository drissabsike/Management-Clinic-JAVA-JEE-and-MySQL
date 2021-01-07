package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Patient_Impl_Inter;
import metier.patient;

@WebServlet("/modifier")
public class ProfileServlet extends HttpServlet{
	Patient_Impl_Inter dao;
	PatientModel model;
	String notification="";
	String urlServlet="";
	
	@Override
	 public void init() throws ServletException{
		 dao = new Patient_Impl_Inter();
		 model = new PatientModel();
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		urlServlet = request.getServletPath();
		try{
			ModifierPatient2(request,response);
		 	}catch(Exception e) {
		  System.out.println("erreur sur la methode doPost :"+e.getMessage());
	  }
	
}
	//Modification
	private void ModifierPatient2(HttpServletRequest req, HttpServletResponse res) throws SQLException ,IOException , ServletException {
		//test
		System.out.println("Dans la servlet /update patient 2 avec url "+urlServlet);
		model.setP((patient)req.getSession().getAttribute("patient"));
		String cin =req.getParameter("cin");
		String nom =req.getParameter("nom");
		String prenom =req.getParameter("prenom");
		int telephone = Integer.parseInt(req.getParameter("telephone"));
		String mail =req.getParameter("mail");
		String sexe =req.getParameter("sexe");
		model = new PatientModel(cin, nom, prenom, telephone, mail, sexe);
		dao.UpdatePatient((model.getP()));
		System.out.println("Patient de CIN"+cin+"est Modifier avec success !");
		req.getSession().setAttribute("patient",dao.SelectPatient(cin, mail));
		model.setP(dao.SelectPatient(cin, mail));
		req.getRequestDispatcher("showp.jsp").forward(req, res);
		}
	
	private void listServlet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,SQLException, IOException {
		// methode listServlet
			//test
			String cin =request.getParameter("cin");
			String mail =request.getParameter("nom");
			System.out.println("c'est l'action list avec url "+urlServlet);
			request.getSession().setAttribute("patient",dao.SelectPatient(cin, mail));
			model.setP(dao.SelectPatient(cin, mail));
			request.getRequestDispatcher("profile.jsp").forward(request, response);
	}
	
}
