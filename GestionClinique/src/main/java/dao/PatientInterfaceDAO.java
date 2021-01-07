package dao;

import java.sql.SQLException;
import java.util.List;
import metier.patient;
import metier.rendezvous;


public interface PatientInterfaceDAO {
	
int savePat(patient p) throws SQLException;	 
	
int deletePat(int id) throws SQLException;
	
int updatePat(patient p) throws SQLException;
	
//recuperation du receptionniste par id
patient getPat(int id) throws SQLException;

patient SelectPatient(String cin,String mail) throws SQLException;

int UpdatePatient(patient p) throws SQLException;


String selectRdv(int id) throws SQLException; 

patient LoginPat(String cin,String mail) throws SQLException;

//List des receptionniste sur la BD
List <patient> listPat() throws SQLException;	

}
