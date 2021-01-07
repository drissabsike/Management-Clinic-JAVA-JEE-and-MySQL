package dao;

import java.sql.SQLException;
import java.util.List;

import metier.receptionniste;

public interface receptionniste_interf_dao {
	int saveRep(receptionniste r) throws SQLException;	 
	
	int deleteRep(int id) throws SQLException;
	
	int deleteRDV(int id) throws SQLException;
	
	int UpdateRDV(int id) throws SQLException;
		
	int updateRep(receptionniste r) throws SQLException;
		
	//recuperation du patient par id
	receptionniste getRep(int id) throws SQLException;

	receptionniste SelectRep(String cin,String mail) throws SQLException;


	receptionniste LoginRep(String cin,String mail) throws SQLException;

	//List des patients sur la BD
	List <receptionniste> listRep() throws SQLException;	

}
