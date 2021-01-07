package dao;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.receptionniste;

class recerp_test {
	receptionniste_impl_interf dao;

	@BeforeEach
	public void initBD() {
		dao=new receptionniste_impl_interf();
	}
	

	@Test
	void test() throws SQLException {
	/*	receptionniste r = new receptionniste("test","test","test",123456,"test rabat","testR@gmail.com");
		dao.saveRep(r);
		System.out.println("add success !!");*/
	}
	
	@Test
	void testSelectRec() throws SQLException {
		receptionniste r = new receptionniste("test","absike","idriss",12365478,"test rabat","testR@gmail.com");
		dao.updateRep(r);
		
	}

}
