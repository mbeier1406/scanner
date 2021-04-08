package com.github.mbeier1406.scanner.domain;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * JPA EntityManager-Klasse für die JUnit-Tests.
 * Verwendet je nach Paramter im  eine lokale In-Memory-Datenbank.
 * @author mbeier
 */
public abstract class EntityManagerBase {

	public static final Logger LOGGER = LogManager.getLogger(EntityManagerBase.class);

	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	/* persistence-unit name="..." */
	protected static String persistenceUnit = "scanner-local-test";

	@BeforeClass
	public static void init() throws FileNotFoundException, SQLException {
		LOGGER.info("persistenceUnit="+persistenceUnit);
		emf = Persistence.createEntityManagerFactory(persistenceUnit);
		em = emf.createEntityManager();
		em.getProperties().entrySet().stream().forEach(e -> LOGGER.info("em: "+e.getKey()+"="+e.getValue()));
	}

	@AfterClass
	public static void closeDatabase() {
		em.clear();
		em.close();
		emf.close();
	}
}
