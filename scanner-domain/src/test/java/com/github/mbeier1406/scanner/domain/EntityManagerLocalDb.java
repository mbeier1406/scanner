package com.github.mbeier1406.scanner.domain;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

/**
 * Initialisiert eine lokale DB für Junit-Tests.
 * @author mbeier
 * @see EntityManagerBase
 */
public abstract class EntityManagerLocalDb extends EntityManagerBase {

	public static final Logger LOGGER = LogManager.getLogger(EntityManagerLocalDb.class);

	/** Der Name der Persistenzeinheit aus {@code persistence.xml} ist {@value} */
	public static final String LOCAL_PERSISTENCE_UNIT = "scanner-local-test";

	static { persistenceUnit = LOCAL_PERSISTENCE_UNIT; };

	/** EntityManager {@linkplain EntityManagerBase#em} initialisieren */
	@BeforeClass
	public static void initDb() throws FileNotFoundException, SQLException {
		init();
	}

}
