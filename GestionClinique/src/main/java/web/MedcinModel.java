package web;

import java.util.ArrayList;
import java.util.List;

import metier.medcin;
import metier.patient;

public class MedcinModel {
	
	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private String address;
	private int telephone;
	private String mail;
	private String specialite;
	
	private medcin m;
	private List<medcin> listMed = new ArrayList<medcin>();
	
	public MedcinModel() {
		super();
	}
	
	
	public MedcinModel(int id, String cin, String nom, String prenom, String address, int telephone, String mail,String specialite) {
		this(cin,nom,prenom,address,telephone,mail,specialite);
		this.id = id;
		this.setM((new medcin(id,cin,nom,prenom,address,telephone,mail,specialite)));
	}


	public MedcinModel(String cin, String nom, String prenom, String address, int telephone, String mail,String specialite) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.telephone = telephone;
		this.mail = mail;
		this.specialite = specialite;
		this.setM((new medcin(cin,nom,prenom,address,telephone,mail,specialite)));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public medcin getM() {
		return m;
	}

	public void setM(medcin m) {
		this.m = m;
	}

	public List<medcin> getListMed() {
		return listMed;
	}

	public void setListMed(List<medcin> listMed) {
		this.listMed = listMed;
	}


	@Override
	public String toString() {
		return "MedcinModel [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", address=" + address
				+ ", telephone=" + telephone + ", mail=" + mail + ", specialite=" + specialite + "]";
	}
	
	
	
	
}
