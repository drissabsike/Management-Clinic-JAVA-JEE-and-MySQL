package dao;

import java.sql.SQLException;
import java.util.List;

import metier.medcin;

public interface MedicinInterface_Dao {

	
	int saveMed(medcin m) throws SQLException;	 
	
	int deleteMedt(int id) throws SQLException;
		
	int updateMed(medcin m) throws SQLException;
		
	//recuperation du medcin par id
	medcin getMed(int id) throws SQLException;

	medcin Selectmedicn(String cin,String mail) throws SQLException;

	int Updatemedicn(medcin m) throws SQLException;

	medcin LoginMedcin(String cin,String mail) throws SQLException;

	//List des medcins sur la BD
	List <medcin> listMed() throws SQLException;	
}

