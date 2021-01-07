package metier;

public class patient {
	
	private int id;
	private String cin;
	private String  nom;
	private String prenom;
	private int telephone;
	private String mail;
	private String sexe;
	
	public patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public patient(String cin, String nom, String prenom, int telephone, String mail, String sexe) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.sexe = sexe;
	}
	
	
	
	public patient(String nom, String prenom, int telephone, String mail, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.sexe = sexe;
	}

	public patient(int id, String cin, String nom, String prenom, int telephone, String mail, String sexe) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.sexe = sexe;
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

	@Override
	public String toString() {
		return "patient [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", mail=" + mail + ", sexe=" + sexe + "]";
	}
	
	
}
