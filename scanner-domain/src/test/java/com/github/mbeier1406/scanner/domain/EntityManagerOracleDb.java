package com.github.mbeier1406.scanner.domain;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

/**
 * Initialisiert einer externen Oracle-DB für Junit-Tests.
 * @author mbeier
 * @see EntityManagerBase
 */
public class EntityManagerOracleDb extends EntityManagerBase {

	public static final Logger LOGGER = LogManager.getLogger(EntityManagerOracleDb.class);

	/** Der Name der Persistenzeinheit aus {@code persistence.xml} ist {@value} */
	public static final String ORACLE_PERSISTENCE_UNIT = "scanner-oracle-test";

	static { persistenceUnit = ORACLE_PERSISTENCE_UNIT; };

	/** EntityManager {@linkplain EntityManagerBase#em} initialisieren */
	@BeforeClass
	public static void initDb() throws FileNotFoundException, SQLException {
		init();
	}

}
