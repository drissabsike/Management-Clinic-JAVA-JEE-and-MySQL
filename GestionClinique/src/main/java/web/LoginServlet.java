package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Medcin_Imp_Inter_M;
import dao.Patient_Impl_Inter;
import dao.receptionniste_impl_interf;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	Patient_Impl_Inter dao;
	receptionniste_impl_interf dao2;
	Medcin_Imp_Inter_M dao3;
	
	PatientModel model;
	RecepModel model2;
	MedcinModel model3;
	
	String notification="";
	String urlServlet="";
	
	@Override
	 public void init() throws ServletException{
		 dao = new Patient_Impl_Inter();
		 dao2 = new receptionniste_impl_interf();
		 dao3 = new Medcin_Imp_Inter_M();
		 
		 model = new PatientModel();
		 model2 = new RecepModel();
		 model3 = new MedcinModel();
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
        String cin = request.getParameter("cin");
   try {
	   //Medcin login
	   if(dao3.LoginMedcin(cin, mail)!=null) {
       	System.out.println("C'est la methode LoginMedcin!");
			request.getSession().setAttribute("Medcin_page",dao3.LoginMedcin(cin, mail));
			model3.setM(dao3.LoginMedcin(cin, mail));
			HttpSession session =request.getSession();
	    	session.setAttribute("mail",mail);
	    	session.setAttribute("cin",cin);
	    	getServletContext().getRequestDispatcher("/Medcin_page.jsp").forward(request, response);
       }
        //receptionniste login
        if(dao2.LoginRep(cin, mail)!=null) {
        	System.out.println("C'est la methode LoginRep!");
			request.getSession().setAttribute("recep_page",dao2.LoginRep(cin, mail));
			model2.setE(dao2.LoginRep(cin, mail));
			HttpSession session =request.getSession();
	    	session.setAttribute("mail",mail);
	    	session.setAttribute("cin",cin);
	    	getServletContext().getRequestDispatcher("/recep_page.jsp").forward(request, response);
        }
        //admin login
        if (mail.equals("admin@gmail.com") && cin.contentEquals("123456")) {
       	 HttpSession session =request.getSession();
    	 session.setAttribute("mail",mail);
    	 getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
       	}
        //patient login
        if(dao.LoginPat(cin, mail)==null) {
				request.getRequestDispatcher("erreur/erreur.jsp").forward(request, response);
			}else{
				System.out.println("C'est la methode loginPatient!");
				request.getSession().setAttribute("patient",dao.LoginPat(cin, mail));
				model.setP(dao.LoginPat(cin, mail));
				HttpSession session =request.getSession();
		    	session.setAttribute("mail",mail);
		    	session.setAttribute("cin",cin);
		    	getServletContext().getRequestDispatcher("/patient.jsp").forward(request, response);
			}
	} catch (SQLException e) {
			System.out.println("LoginServlet Erreur :"+e.getMessage());
		}
       		
       	
        
	}
	

}
