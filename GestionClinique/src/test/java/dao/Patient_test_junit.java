package dao;

import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.patient;


class Patient_test_junit {
	Patient_Impl_Inter dao;

	@BeforeEach
	public void initBD() {
		dao=new Patient_Impl_Inter();
	}
	
	@Test
	void testselectRdv() throws SQLException {
		System.out.println(dao.selectRdv(1));
	}
	
	
	@Test
	void testSavePat() throws SQLException {
		patient pat = new patient("Nawal","Shimi","kenitra",12593,"Nawal@gmail.com","F");
		dao.savePat(pat);
		System.out.println("Patient ete ajoutee avec success !");
	}

	@Test
	void testDeletePat() throws Exception {
		//dao.deletePat(2);
		//System.out.println("Patient ete supprimer avec success !");
	}

	@Test
	void testGetPat() throws SQLException {
		System.out.println(dao.getPat(1));
	}

	@Test
	void testListPat() throws SQLException {
	for(patient p: dao.listPat() ) {
			System.out.println(p.toString());
		}
	}

}
