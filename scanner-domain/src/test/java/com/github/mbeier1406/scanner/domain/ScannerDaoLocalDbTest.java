package com.github.mbeier1406.scanner.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Prüfen, ob die Persistenzdefinition funktioniert.
 * @author mbeier
 */
public class ScannerDaoLocalDbTest extends EntityManagerBase {

	public static final Logger LOGGER = LogManager.getLogger(ScannerDaoLocalDbTest.class);

	/** Einen {@linkplain Scanner} in die DB eintragen */
	@Before
	public void initDb() {
		try {
			em.getTransaction().begin();
			em.persist(new Scanner(1, "Scanner1", "SCN-1", 111));
			em.getTransaction().commit();
		}
		catch ( Throwable t ) {
			LOGGER.error("", t);
			throw t;
		}
	}

	/** Prüfen, ob der Scanner gefunden wird */
	@Test
	public void testeScannerLesen() {
		Scanner scn = em.find(Scanner.class, 1L);
		LOGGER.info("scn={}", scn);
	}

}
