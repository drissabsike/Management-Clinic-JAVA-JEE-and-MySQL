package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_medcin_Junit {
	Medcin_Imp_Inter_M dao;
	
	@BeforeEach
	public void initBD() {
		dao=new Medcin_Imp_Inter_M();
	}

	@Test
	void testConnectDB() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveMed() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteMedt() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMed() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMed() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectmedicn() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatemedicn() {
		fail("Not yet implemented");
	}

	@Test
	void testLoginMedcin() throws SQLException {
		//fail("Not yet implemented");
		dao.LoginMedcin("test","ayoub@gmail.com");
	}

	@Test
	void testListMed() {
		fail("Not yet implemented");
	}

}
