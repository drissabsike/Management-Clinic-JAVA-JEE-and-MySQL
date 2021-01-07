package dao;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test_junit {
	
	Patient_Impl_Inter dao;

	@BeforeEach
	public void initBD() {
		dao=new Patient_Impl_Inter();
	}

	@Test
	void testLoginPat() throws SQLException {
		String cin="A521753";
		String mail="oumaya@gmail.com";
		System.out.println(dao.LoginPat(cin, mail));
	}

}
