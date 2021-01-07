package web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import metier.patient;


public class PatientModel {
	
	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private int telephone;
	private String mail;
	private String sexe;
	
	private patient p;
	private List<patient> listPatient = new ArrayList<patient>();
	
	public PatientModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientModel(int id,String cin, String nom, String prenom, int telephone, String mail, String sexe) {
		this(cin,nom,prenom,telephone,mail,sexe);
		this.id = id;
		this.setP(new patient(id,cin,nom,prenom,telephone,mail,sexe));
	}
	
	public PatientModel(String cin,String nom, String prenom, int telephone, String mail, String sexe) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.sexe = sexe;
		this.setP(new patient(cin,nom,prenom,telephone,mail,sexe));
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public patient getP() {
		return p;
	}

	public void setP(patient p) {
		this.p = p;
	}
	
	public List<patient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<patient> listPatient) {
		this.listPatient = listPatient;
	}

	@Override
	public String toString() {
		return "PatientModel [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", mail=" + mail + ", sexe=" + sexe + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
