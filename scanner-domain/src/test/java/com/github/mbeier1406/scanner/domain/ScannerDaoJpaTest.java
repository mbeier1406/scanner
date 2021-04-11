package com.github.mbeier1406.scanner.domain;

import static com.github.mbeier1406.scanner.domain.EntityManagerOracleDb.ORACLE_PERSISTENCE_UNIT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests für die Klasse {@link ScannerDaoJpa}.
 * @author mbeier
 * @see ScannerDao
 */
public class ScannerDaoJpaTest {

	public static final Logger LOGGER = LogManager.getLogger(ScannerDaoJpaTest.class);

	/** Das zu testende Objekt */
	public ScannerDao<Scanner> scannerDao;

	/** Initialisierung {@linkplain #scannerDao} */
	@Before
	public void init() {
		scannerDao = new ScannerDaoJpa(ORACLE_PERSISTENCE_UNIT);
	}

	@Test
	public void test() {
		
	}

}
