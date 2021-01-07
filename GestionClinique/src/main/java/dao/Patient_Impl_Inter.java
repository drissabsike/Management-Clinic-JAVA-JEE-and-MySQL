package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.patient;

public class Patient_Impl_Inter implements PatientInterfaceDAO {

	private String sql;
	private static patient patient;
	private static PreparedStatement ps;
	private Connection con;
	
	public void connectDB() throws SQLException{
		//lien couplage plus-tôt
		con=new DataBaseConnection().getConnection();
	}
	
	//ajout d'un patient
	public int savePat(patient p) throws SQLException {
		int status = 0 ;
		sql = "insert into patient(cin,nom,prenom,telephone,mail,sexe) values(?,?,?,?,?,?)";
		connectDB();
		ps= con.prepareStatement(sql);
		ps.setString(1, p.getCin());
		ps.setString(2, p.getNom());
		ps.setString(3, p.getPrenom());
		ps.setInt(4, p.getTelephone());
		ps.setString(5, p.getMail());
		ps.setString(6, p.getSexe());
		status=ps.executeUpdate();
		return status;
	}

	//suppresion s'un patient par id
	public int deletePat(int id) throws SQLException {
		connectDB();
		int status = 0;
		sql = "delete from patient where id="+id;
		ps=con.prepareStatement(sql);
		status=ps.executeUpdate();
		return status;
	}

	//modification de patient
	public int updatePat(patient p) throws SQLException {
			int status = 0 ;
			sql = "UPDATE patient SET cin=? , nom=? , prenom=? , telephone=? , mail=? , sexe=? WHERE id=?";
			connectDB();
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getCin());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			ps.setInt(4, p.getTelephone());
			ps.setString(5, p.getMail());
			ps.setString(6, p.getSexe());
			ps.setInt(7, p.getId());
			status=ps.executeUpdate();
			return status;
	}

	//affichager d'un patient par leur id
	public patient getPat(int id) throws SQLException {
		connectDB();
		sql="select * from patient where id="+id;
		patient pa = null;
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
	pa = new patient(id,rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("telephone"),rs.getString("mail"),rs.getString("sexe"));
		}
		ps.close();
		con.close();
		return pa;
	}
	
	//affichager des patients
	public List<patient> listPat() throws SQLException {
		connectDB();
		sql ="SELECT * FROM patient";
		List <patient>listPatient =new ArrayList<patient>();
		ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			patient = new patient();
			patient.setId(Integer.parseInt(rs.getString("id")));
			patient.setCin(rs.getString("cin"));
			patient.setNom(rs.getString("nom"));
			patient.setPrenom(rs.getString("prenom"));
			patient.setTelephone(Integer.parseInt(rs.getString("telephone")));
			patient.setMail(rs.getString("mail"));
			patient.setSexe(rs.getString("sexe"));
			listPatient.add(patient);
		}
		ps.close();
		con.close();
		return listPatient;
	}
	


	public patient LoginPat(String cin, String mail) throws SQLException {
		//affichager d'un patient par leur cin et mail
			connectDB();
			sql="SELECT * FROM patient WHERE cin=? AND mail=?";
			patient pa = null;
			ps = con.prepareStatement(sql);
			ps.setString(1, cin);
			ps.setString(2, mail);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps);
			if(rs.next()) {
		pa = new patient(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("telephone"),rs.getString("mail"),rs.getString("sexe"));
			}else {
				pa=null;
				//System.out.println("auccun resultat ");
			}
			ps.close();
			con.close();
			return pa;
		}

	public patient SelectPatient(String cin, String mail) throws SQLException {
		connectDB();
		sql="SELECT * FROM patient WHERE cin=? AND mail=?";
		patient pa = null;
		ps = con.prepareStatement(sql);
		ps.setString(1, cin);
		ps.setString(2, mail);
		ResultSet rs = ps.executeQuery();
		//System.out.println(ps);
		if(rs.next()) {
	pa = new patient(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("telephone"),rs.getString("mail"),rs.getString("sexe"));
		}else {
			pa=null;
			//System.out.println("auccun resultat ");
		}
		ps.close();
		con.close();
		return pa;
	}


	public int UpdatePatient(patient p) throws SQLException {
		int status = 0 ;
		sql = "UPDATE patient SET nom=? , prenom=? , telephone=? , mail=? , sexe=? WHERE cin=?";
		connectDB();
		ps=con.prepareStatement(sql);
		ps.setString(1, p.getNom());
		ps.setString(2, p.getPrenom());
		ps.setInt(3, p.getTelephone());
		ps.setString(4, p.getMail());
		ps.setString(5, p.getSexe());
		ps.setString(6, p.getCin());
		status=ps.executeUpdate();
		return status;
	}

	public String selectRdv(int id) throws SQLException {
		connectDB();
		sql="SELECT * FROM rendezvous WHERE id="+id;
		String r = "";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs);
		if(rs.next()) {  
		r=("cin: "+rs.getString("cin")+" nom et prenom "+rs.getString("nom_prenom")+" desc :"+rs.getString("description")+" date :"+rs.getString("date_rdv"));
		}
		ps.close();
		con.close();
		return r;
	}

	
	}
	
	

