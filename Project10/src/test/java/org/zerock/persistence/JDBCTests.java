package org.zerock.persistence;
import static org.junit.Assert.fail;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {

			Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:log4jdbc:oracle:thin:@localhost:1521:XE",
				//"jdbc:oracle:thin:@localhost:1521:XE",
				"scott",
				"tiger"
				)){
			log.info(conn);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
}