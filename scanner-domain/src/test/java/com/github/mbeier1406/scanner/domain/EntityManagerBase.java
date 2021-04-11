package com.github.mbeier1406.scanner.domain;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;

/**
 * JPA EntityManager-Klasse für die JUnit-Tests.
 * Verwendet standardmäßig die lokale In-Memory-Datenbank, kann aber
 * per {@linkplain #init()} über den Parameter mit dem entsprechenden
 * Persistence-unit-Name auch angepasst werden.
 * @author mbeier
 */
public abstract class EntityManagerBase {

	public static final Logger LOGGER = LogManager.getLogger(EntityManagerBase.class);

	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	/* persistence-unit name="..." */
	/** Name der Persistenzdefinition aus der {@code persistence.xml}  */
	protected static String persistenceUnit = "scanner-oracle-test";

	/**
	 * Initialisiert den EntityManager für die Junit-Tests.
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public static void init() throws FileNotFoundException, SQLException {
		LOGGER.info("persistenceUnit="+persistenceUnit);
		emf = Persistence.createEntityManagerFactory(persistenceUnit);
		em = emf.createEntityManager();
		em.getProperties().entrySet().stream().forEach(e -> LOGGER.info("em: "+e.getKey()+"="+e.getValue()));
	}

	/** Schließt den EntityManager und die Faxtory. */
	@AfterClass
	public static void closeDatabase() {
		em.clear();
		em.close();
		emf.close();
	}
}
