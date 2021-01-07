package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import metier.patient;
import metier.receptionniste;

public class receptionniste_impl_interf implements receptionniste_interf_dao {

	private String sql;
	private static receptionniste r;
	private static PreparedStatement ps;
	private Connection con;
	
	public void connectDB() throws SQLException{
		//lien couplage plus-tôt
		con=new DataBaseConnection().getConnection();
	}
	
	
	@Override
	public int saveRep(receptionniste r) throws SQLException {
		int status = 0 ;
		sql = "insert into receptionniste(cin,nom,prenom,telephone,address,mail) values(?,?,?,?,?,?)";
		connectDB();
		ps= con.prepareStatement(sql);
		ps.setString(1,r.getCin());
		ps.setString(2, r.getNom());
		ps.setString(3, r.getPrenom());
		ps.setInt(4, r.getTelephone());
		ps.setString(5, r.getAddress());
		ps.setString(6, r.getMail());
		status=ps.executeUpdate();
		return status;
	}

	@Override
	public int deleteRep(int id) throws SQLException {
		connectDB();
		int status = 0;
		sql = "delete from receptionniste where id="+id;
		ps=con.prepareStatement(sql);
		status=ps.executeUpdate();
		return status;
	}

	@Override  
	public int updateRep(receptionniste r) throws SQLException {
		int status = 0 ;
		sql = "UPDATE receptionniste SET nom=? , prenom=? , telephone=? , address=? , mail=?  WHERE cin=?";
		connectDB();
		ps=con.prepareStatement(sql);
		ps.setString(1, r .getNom());
		ps.setString(2, r.getPrenom());
		ps.setInt(3, r.getTelephone());
		ps.setString(4, r.getAddress());
		ps.setString(5, r.getMail());
		ps.setString(6, r.getCin());
		status=ps.executeUpdate();
		return status;
	}

	@Override
	public receptionniste getRep(int id) throws SQLException {
		connectDB();
		sql="select * from receptionniste where id="+id;
		receptionniste rep = null;
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
rep = new receptionniste(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("telephone"),rs.getString("address"),rs.getString("mail"));
		}
		ps.close();
		con.close();
		return rep;
	}

	@Override
	public receptionniste SelectRep(String cin, String mail) throws SQLException {
		connectDB();
		sql="SELECT * FROM receptionniste WHERE cin=? AND mail=?";
		receptionniste rep = null;
		ps = con.prepareStatement(sql);
		ps.setString(1, cin);
		ps.setString(2, mail);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			rep = new receptionniste(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("telephone"),rs.getString("address"),rs.getString("mail"));
			System.out.println("cin: "+rs.getString("cin"));
		}else {
			rep=null;
			//System.out.println("auccun resultat ");
		}
		ps.close();
		con.close();
		return rep;
	}

	@Override
	public receptionniste LoginRep(String cin, String mail) throws SQLException {
		//affichager d'un receptionniste par leur cin et mail
		connectDB();
		sql="SELECT * FROM receptionniste WHERE cin=? AND mail=?";
		receptionniste rep = null;
		ps = con.prepareStatement(sql);
		ps.setString(1, cin);
		ps.setString(2, mail);
		ResultSet rs = ps.executeQuery();
		System.out.println(ps);
		if(rs.next()) {
rep = new receptionniste(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("telephone"),rs.getString("address"),rs.getString("mail"));
		System.out.println("nom :"+rs.getString("nom"));
		}else {
			rep=null;
			System.out.println("auccun resultat ");
		}
		ps.close();
		con.close();
		return rep;
	}

	@Override
	public List<receptionniste> listRep() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int deleteRDV(int id) throws SQLException {
		connectDB();
		int status = 0;
		sql = "delete from rendezvous where id="+id;
		ps=con.prepareStatement(sql);
		status=ps.executeUpdate();
		return status;
	}


	@Override
	public int UpdateRDV(int id) throws SQLException {
		connectDB();
		int status = 0;
		sql = "update rendezvous set activate=1 where id="+id;
		ps=con.prepareStatement(sql);
		status=ps.executeUpdate();
		return status;
	}

}
