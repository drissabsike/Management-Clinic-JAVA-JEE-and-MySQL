package metier;

public class receptionniste {
	
	private int id;
	private String	cin;
	private String nom;
	private String prenom;
	private int telephone;
	private String address;
	private String mail;
	
	public receptionniste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public receptionniste(int id, String cin, String nom, String prenom, int telephone, String address,String mail) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.address = address;
		this.mail = mail;
	}

	public receptionniste(String cin, String nom, String prenom, int telephone, String address, String mail) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.address = address;
		this.mail = mail;
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

	@Override
	public String toString() {
		return "receptionniste [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
				+ telephone + ", address=" + address + ", mail=" + mail + "]";
	}


}
