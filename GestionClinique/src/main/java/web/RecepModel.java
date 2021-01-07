package web;

import java.util.ArrayList;
import java.util.List;

import metier.receptionniste;

public class RecepModel {
	
	private int id;
	private String	cin;
	private String nom;
	private String prenom;
	private int telephone;
	private String address;
	private String mail;
	
	private receptionniste e;
	private List<receptionniste> listRep = new ArrayList<receptionniste>();
	
	public RecepModel() {
		super();
	}

	public RecepModel(int id,String cin, String nom, String prenom, int telephone, String address, String mail) {
		this(cin,nom,prenom,telephone,address,mail);
		this.id = id;
		this.setE(new receptionniste(id,cin,nom,prenom,telephone,address,mail));
	}
	

	public RecepModel(String cin, String nom, String prenom, int telephone, String address, String mail) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.address = address;
		this.mail = mail;
		this.setE(new receptionniste(cin,nom,prenom,telephone,address,mail));
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

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public receptionniste getE() {
		return e;
	}

	public void setE(receptionniste e) {
		this.e = e;
	}

	public List<receptionniste> getListRep() {
		return listRep;
	}

	public void setListRep(List<receptionniste> listRep) {
		this.listRep = listRep;
	}

	
	
	
}
