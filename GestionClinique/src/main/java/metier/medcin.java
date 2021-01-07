package metier;

public class medcin {
		
	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private String address;
	private int telephone;
	private String mail;
	private String specialite;
	
	
	public medcin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public medcin(int id, String cin, String nom, String prenom, String address, int telephone, String mail,
			String specialite) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.telephone = telephone;
		this.mail = mail;
		this.specialite = specialite;
	}


	public medcin(String cin, String nom, String prenom, String address, int telephone, String mail,
			String specialite) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.telephone = telephone;
		this.mail = mail;
		this.specialite = specialite;
	}


	public medcin(String nom, String prenom, String address, int telephone, String mail, String specialite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.telephone = telephone;
		this.mail = mail;
		this.specialite = specialite;
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


	@Override
	public String toString() {
		return "medcin [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", address=" + address
				+ ", telephone=" + telephone + ", mail=" + mail + ", specialite=" + specialite + "]";
	}
	
	
}
