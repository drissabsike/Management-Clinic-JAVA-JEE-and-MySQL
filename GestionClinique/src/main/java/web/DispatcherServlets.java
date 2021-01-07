package web;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataBaseConnection;
import dao.Medcin_Imp_Inter_M;
import dao.Patient_Impl_Inter;
import dao.receptionniste_impl_interf;
import metier.patient;
import metier.receptionniste;


@WebServlet("/")
public class DispatcherServlets extends HttpServlet {
Patient_Impl_Inter dao;
PatientModel model;

Medcin_Imp_Inter_M dao2;
MedcinModel model2;

receptionniste_impl_interf dao3;
RecepModel model3;

String notification="";
String urlServlet="";
private Connection con;

public void connectDB() throws SQLException{
	//lien couplage plus-tôt
 con=new DataBaseConnection().getConnection();
}

@Override
 public void init() throws ServletException{
	 dao = new Patient_Impl_Inter();
	 dao2 = new Medcin_Imp_Inter_M();
	 dao3 = new receptionniste_impl_interf();
	 
	 model = new PatientModel();
	 model2 = new MedcinModel();
	 model3 = new RecepModel();
	 
 }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  urlServlet = request.getServletPath();
	try{
	  switch(urlServlet) {
	  case "/ajout": ajoutePatient(request,response);break;
	  case "/ajoutM": ajouteMED(request,response);break;
	  case "/ajout_rdv" : ajouteRDV(request,response);break;
	  case "/Ajout_rec": ajouteRec(request,response);break;
	  case "/edit": updateServlet(request,response);break;
	  case "/profile": afficherProfile(request,response);break;
	  case "/addFacture": SaveFacture(request,response);break;
	  case "/ajouteCon": SaveCons(request,response);break;
	  case "/ajouteCDM" : SaveDM(request,response);break;
	  default :listServlet(request,response);
	  }
	  	}catch(Exception e) {
	  System.out.println("erreur sur la methode doPost :"+e.getMessage());
  }
}




private void SaveFacture(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
	System.out.println("je suis dans la methode SaveFacture");
	 String nom = request.getParameter("nom");
	 String prenom = request.getParameter("prenom");
	 String cin = request.getParameter("cin");
	 String telephone = request.getParameter("telephone");
	 String desc = request.getParameter("desc");
	 String prix =request.getParameter("prix");
	 String cartnumber =request.getParameter("cartnumber");
	 int cvv =Integer.parseInt(request.getParameter("cvv"));
	 String expire =request.getParameter("expire");
	 connectDB();
	 String sql = "INSERT INTO facture (nom,prenom,cin,telephone,description,prix,cart_umber,cvv,expires) values (?,?,?,?,?,?,?,?,?)";
	 PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
	 statement.setString(1,nom);
	 statement.setString(2,prenom);
	 statement.setString(3,cin);
	 statement.setString(4,telephone);
	 statement.setString(5,desc);
	 statement.setString(6,prix);
	 statement.setString(7,cartnumber);
	 statement.setInt(8,cvv);
	 statement.setString(9,expire);
	 statement.executeUpdate();
		System.out.println("La Facture a ete Enregitrer !");
		response.sendRedirect("success.jsp");
}

private void ajouteRec(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	System.out.println("dans la servlet /ajout recep avec url "+urlServlet);
	String cin = request.getParameter("cin");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	int telephone = Integer.parseInt(request.getParameter("telephone"));
	String address = request.getParameter("address");
	String mail = request.getParameter("mail");
	model3 = new RecepModel(cin, nom, prenom, telephone, address, mail);
	dao3.saveRep(model3.getE());
	System.out.println("Receptionniste de cin"+cin+" ete ajoutte avec success !!");
	notification="Receptionniste de CIN "+cin+" est ajoutee avec success !";
	response.sendRedirect("listRec.jsp");
}

private void ajouteMED(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	System.out.println("dans la servlet /ajout medcin avec url "+urlServlet);
	String cin = request.getParameter("cin");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String address = request.getParameter("address");
	int telephone = Integer.parseInt(request.getParameter("telephone"));
	String mail = request.getParameter("mail");
	String specialite = request.getParameter("specialite");
	model2 = new MedcinModel(cin, nom, prenom, address, telephone, mail, specialite);
	dao2.saveMed(model2.getM());
	System.out.println("Medcin de cin"+cin+" ete ajoutte avec success !!");
	notification="Medcin de CIN "+cin+" est ajoutee avec success !";
	response.sendRedirect("listMedcins.jsp");
	
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	urlServlet = request.getServletPath();
	try{
	  switch(urlServlet) {
	  case "/afficher": afficherServlet(request,response);break;
	  case "/show": affichervoiture(request,response);break;
	  case "/delete": deleteServlet(request,response);break;
	  case "/deleteM": deleteM(request,response);break;
	  case "/deleteR": deleteRecp(request,response);break;
	  case "/deleteRDV": deleteRDV(request,response);break;
	  case "/ActivateRDV": updateRDV(request,response);break;
	  case "/Imprimer": Imprimer(request,response);break;
	  default :listServlet(request,response);
	  }
	  	}catch(Exception e) {
	  System.out.println("erreur sur la methode doGET :"+e.getMessage());
  }
}


private void Imprimer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	 PrintWriter out = response.getWriter();
	 connectDB();
	 PreparedStatement ps = con.prepareStatement("select * from consultation WHERE id=?");
     ps.setInt(1, id);
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out1=response.getWriter();
     out1.println("<html>");
     out1.print("<center><table width=25% border=1></center>");
     out1.print("<center><h1>Recu De Votre Consultation</h1></center>");
     ResultSet rs = ps.executeQuery();
     ResultSetMetaData rsmd = rs.getMetaData();
     while (rs.next()) {
    	 out1.print("<tr>");
         out1.print("<td>" + rsmd.getColumnName(1) + "</td>");
         out1.print("<td>" + rs.getInt(1) + "</td></tr>");
         out1.print("<tr><td>" + rsmd.getColumnName(2) + "</td>");
         out1.print("<td>" + rs.getString(2)+ "</td></tr>");
         out1.print("<tr><td>" + rsmd.getColumnName(3) + "</td>");
         out1.print("<td>" + rs.getString(3)+ "</td></tr>");
         out1.print("<tr><td>" + rsmd.getColumnName(4) + "</td>");
         out1.print("<td>" + rs.getInt(4)+"dh"+"</td></tr>");
         out1.print("<tr><td>" + rsmd.getColumnName(5) + "</td>");
         out1.print("<td>" + rs.getString(5)+ "</td></tr>");
     }
     out1.print("</table><br>");
     out1.print("<button onclick='window.print()'>Print this page</button>");
     out1.println("</html>");
     out1.close();
  }



private void updateRDV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	System.out.println("C'est l'action delete Recep avec url "+urlServlet);
	int id=Integer.parseInt(request.getParameter("id"));
	dao3.UpdateRDV(id);
	System.out.println("RDV est admis avec success !!");
	notification="DV est admis avec success !!";
	response.sendRedirect("show_rdv.jsp");
}

private void deleteRDV(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	System.out.println("C'est l'action delete Recep avec url "+urlServlet);
	int id=Integer.parseInt(request.getParameter("id"));
	dao3.deleteRDV(id);
	System.out.println("RDV est admis avec success !!");
	notification="DV est admis avec success !!";
	response.sendRedirect("show_rdv.jsp");
}

private void deleteRecp(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	System.out.println("C'est l'action delete Recep avec url "+urlServlet);
	int id=Integer.parseInt(request.getParameter("id"));
	dao3.deleteRep(id);
	System.out.println("Recep est supprimer avec success !!");
	notification="Medcin est supprimer avec success !!";
	response.sendRedirect("listRec.jsp");
	
}

private void deleteM(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
	//test
			System.out.println("C'est l'action delete medcin avec url "+urlServlet);
			int id=Integer.parseInt(request.getParameter("id"));
			dao2.deleteMedt(id);
			System.out.println("Medcin est supprimer avec success !!");
			notification="Medcin est supprimer avec success !!";
			response.sendRedirect("listMedcins.jsp");
	}
	


private void affichervoiture(HttpServletRequest request, HttpServletResponse response)throws ServletException ,SQLException, IOException  {
	System.out.println("C'est l'action afficher un patient !");
	int id=Integer.parseInt(request.getParameter("id"));
	request.getSession().setAttribute("patient",dao.getPat(id));
	model.setP(dao.getPat(id));
	request.getRequestDispatcher("show.jsp").forward(request, response);
}

//Les Methodes utiliser sur les cases
	
	//supprimer une voiture
    private void deleteServlet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,SQLException, IOException {
    	//test
		System.out.println("C'est l'action delete avec url "+urlServlet);
		int id=Integer.parseInt(request.getParameter("id"));
		dao.deletePat(id);
		System.out.println("Patient est supprimer avec success !!");
		notification="Patient est supprimer avec success !!";
		response.sendRedirect("list");
}
 
	private void afficherServlet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,SQLException, IOException {
	//test
		System.out.println("C'est l'action Modification un patient !");
		int id=Integer.parseInt(request.getParameter("id"));
		request.getSession().setAttribute("patient",dao.getPat(id));
		model.setP(dao.getPat(id));	
		request.getRequestDispatcher("edit.jsp").forward(request, response);
}

	
	private void listServlet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,SQLException, IOException {
	// methode listServlet
		//test
		System.out.println("c'est l'action list avec url "+urlServlet);
		model.setListPatient(dao.listPat());
		request.setAttribute("list",model.getListPatient());
		request.setAttribute("notification",notification);
		request.getRequestDispatcher("listform.jsp").forward(request, response);
}
	
	
	//Modification
	private void updateServlet(HttpServletRequest req, HttpServletResponse res) throws SQLException ,IOException , ServletException {
		//test
		System.out.println("Dans la servlet /update avec url "+urlServlet);
		model.setP((patient)req.getSession().getAttribute("patient"));
		int id=model.getP().getId();
		String cin =req.getParameter("cin");
		String nom =req.getParameter("nom");
		String prenom =req.getParameter("prenom");
		int telephone = Integer.parseInt(req.getParameter("telephone"));
		String mail =req.getParameter("mail");
		String sexe =req.getParameter("sexe");
		model = new PatientModel(id,cin, nom, prenom, telephone, mail, sexe);
		dao.updatePat(model.getP());
		System.out.println("Patient de CIN"+cin+"est Modifier avec success !");
		notification="Patient de CIN "+cin+" est Modifier avec success !";
		res.sendRedirect("list");
}
	
	
	//L'ajout
	private void ajoutePatient(HttpServletRequest request, HttpServletResponse response) throws SQLException ,IOException , ServletException {
		//test
		System.out.println("dans la servlet /ajout avec url "+urlServlet);
		String cin = request.getParameter("cin");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int telephone = Integer.parseInt(request.getParameter("telephone"));
		String mail = request.getParameter("mail");
		String sexe = request.getParameter("sexe");
		model = new PatientModel(cin, nom, prenom, telephone, mail, sexe);
		dao.savePat(model.getP());
		System.out.println("Patient de cin"+cin+" ete ajoutte avec success !!");
		notification="Patient de CIN "+cin+" est ajoutee avec success !";
		response.sendRedirect("login.jsp");
	}
	private void afficherProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
        String cin = request.getParameter("cin");
		try {
			if(dao.SelectPatient(cin, mail)==null) {
				request.getRequestDispatcher("erreur/erreur.jsp").forward(request, response);
			}else{
				System.out.println("C'est la methode SelectPatient!");
				request.getSession().setAttribute("patient",dao.SelectPatient(cin, mail));
				model.setP(dao.SelectPatient(cin, mail));
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void ajouteRDV(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 String cin = request.getParameter("cin");
		 String nom_prenom = request.getParameter("fullname");
		 String description = request.getParameter("description");
		 String date_rdv = request.getParameter("daterdv");
		 connectDB();
		 String sql = "INSERT INTO rendezvous (cin,nom_prenom,description,date_rdv) values (?,?,?,?)";
		 PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		 statement.setString(1,cin);
		 statement.setString(2,nom_prenom);
		 statement.setString(3,description);
		 statement.setString(4,date_rdv);
		 statement.executeUpdate();
			System.out.println("Le Rdv a ete ajouter !");
			response.sendRedirect("select_rdv_p.jsp");
	}
	

private void SaveCons(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	 String date_cons = request.getParameter("date_cons");
	 String Description = request.getParameter("Description");
	 float prix =Float.parseFloat(request.getParameter("prix"));
	 String cin = request.getParameter("cin");
	 connectDB();
	 String sql = "INSERT INTO consultation (date_cons , Description , prix , cin) values (?,?,?,?)";
	 PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
	 statement.setString(1,date_cons);
	 statement.setString(2,Description);
	 statement.setFloat(3,prix);
	 statement.setString(4,cin);
	 statement.executeUpdate();
		System.out.println("La consultation a ete ajouter !");
		response.sendRedirect("Medcin_page.jsp");
	
}
private void SaveDM(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	System.out.println("ici la methode d'ajouter un dossier medical");
	 String cin = request.getParameter("cin");
	 String nom = request.getParameter("nom");
	 String prenom = request.getParameter("prenom");
	 int telephone =Integer.parseInt(request.getParameter("telephone"));
	 String maladie = request.getParameter("maladie");
	 String mediceaux = request.getParameter("mediceaux");
	 String medcin_nom = request.getParameter("medcin_nom");
	 String specialite = request.getParameter("specialite");	
	 connectDB();
	 String sql = "INSERT INTO dossier_medical(cin,nom,prenom,telephone,maladie,mediceaux,medcin_nom,specialite) values (?,?,?,?,?,?,?,?)";
	 PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
	 statement.setString(1,cin);
	 statement.setString(2,nom);
	 statement.setString(3,prenom);
	 statement.setInt(4,telephone);
	 statement.setString(5,maladie);
	 statement.setString(6,mediceaux);
	 statement.setString(7,medcin_nom);
	 statement.setString(8,specialite);
	 statement.executeUpdate();
		System.out.println("La dossier_medical a ete ajouter !");
		response.sendRedirect("Medcin_page.jsp");
	
}

}
