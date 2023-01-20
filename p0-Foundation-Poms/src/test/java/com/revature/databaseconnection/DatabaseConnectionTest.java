package com.revature.databaseconnection;

import com.revature.poms.config.DatabaseConnection;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class DatabaseConnectionTest {
	@Test
		public void testGetConnection() {
			assertNotNull(new DatabaseConnection().getConnection());
		}
}
