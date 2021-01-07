package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.medcin;
import metier.patient;

public class Medcin_Imp_Inter_M implements MedicinInterface_Dao {
	private String sql;
	private static medcin m;
	private static PreparedStatement ps;
	private Connection con;
	
	public void connectDB() throws SQLException{
		//lien couplage plus-tôt
		con=new DataBaseConnection().getConnection();
	}
	
	
	@Override
	public int saveMed(medcin m) throws SQLException {
		int status = 0 ;
		sql = "insert into medcin(cin,nom,prenom,address,telephone,mail,specialite) values(?,?,?,?,?,?,?)";
		connectDB();
		ps= con.prepareStatement(sql);
		ps.setString(1, m.getCin());
		ps.setString(2, m.getNom());
		ps.setString(3, m.getPrenom());
		ps.setString(4, m.getAddress());
		ps.setInt(5, m.getTelephone());
		ps.setString(6, m.getMail());
		ps.setString(7, m.getSpecialite());
		status=ps.executeUpdate();
		return status;
	}

	@Override
	public int deleteMedt(int id) throws SQLException {
		connectDB();
		int status = 0;
		sql = "delete from medcin where id="+id;
		ps=con.prepareStatement(sql);
		status=ps.executeUpdate();
		return status;
	}

	@Override
	public int updateMed(medcin m) throws SQLException {
		int status = 0 ;
		sql = "UPDATE medcin SET nom=? , prenom=? , address=?, telephone=?  , mail=?  WHERE cin=?";
		connectDB();
		ps=con.prepareStatement(sql);
		ps.setString(1, m.getNom());
		ps.setString(2, m.getPrenom());
		ps.setString(3, m.getAddress());
		ps.setInt(4, m.getTelephone());
		ps.setString(5, m.getMail());
		ps.setString(6, m.getCin());
		status=ps.executeUpdate();
		return status;
	}

	@Override
	public medcin getMed(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public medcin Selectmedicn(String cin, String mail) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Updatemedicn(medcin m) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public medcin LoginMedcin(String cin, String mail) throws SQLException {
		connectDB();
		sql="SELECT * FROM medcin WHERE cin=? AND mail=?";
		medcin m = null;
		ps = con.prepareStatement(sql);
		ps.setString(1, cin);
		ps.setString(2, mail);
		ResultSet rs = ps.executeQuery();
		System.out.println(ps);
		if(rs.next()) {
	m = new medcin(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("address"),rs.getInt("telephone"),rs.getString("mail"),rs.getString("specialite"));
		System.out.println("cein: "+rs.getString("cin"));
		}else {
			m=null;
			System.out.println("auccun resultat ");
		}
		ps.close();
		con.close();
		return m;
	}

	@Override
	public List<medcin> listMed() throws SQLException {
		connectDB();
		sql ="SELECT * FROM medcin";
		List <medcin> listMed =new ArrayList<medcin>();
		ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			m = new medcin();
			m.setId(Integer.parseInt(rs.getString("id")));
			m.setCin(rs.getString("cin"));
			m.setNom(rs.getString("nom"));
			m.setPrenom(rs.getString("prenom"));
			m.setAddress(rs.getString("address"));
			m.setTelephone(Integer.parseInt(rs.getString("telephone")));
			m.setMail(rs.getString("mail"));
			m.setSpecialite(rs.getString("specialite"));
			listMed.add(m);
		}
		ps.close();
		con.close();
		return listMed;
	}

}
