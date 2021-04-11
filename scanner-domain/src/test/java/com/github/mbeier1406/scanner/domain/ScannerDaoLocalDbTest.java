package com.github.mbeier1406.scanner.domain;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Prüfen, ob die Persistenzdefinition funktioniert.
 * Verwendet wird eine lokale DB, die bei jedem Test neu initialisiert wird.
 * @author mbeier
 * @see EntityManagerLocalDb
 */
public class ScannerDaoLocalDbTest extends EntityManagerLocalDb {

	public static final Logger LOGGER = LogManager.getLogger(ScannerDaoLocalDbTest.class);


	/** Der Scanner, mit dem getestet wird */
	public final Scanner scanner = new Scanner("Scanner1", "SCN-1", 112);

	/** Einen {@linkplain Scanner} in die DB eintragen */
	@Before
	public void initDatabase() {
		try {
			em.getTransaction().begin();
			em.persist(scanner);
			em.getTransaction().commit();
		}
		catch ( Throwable t ) {
			LOGGER.error("", t);
			throw t;
		}
	}

	/** Prüfen, ob der Scanner {@linkplain #scanner} in der DB gefunden wird */
	@Test
	public void testeScannerLesen() {
		Scanner scn = em.find(Scanner.class, scanner.getId());
		LOGGER.info("scn={}", scn);
		assertThat("", scn, allOf(
				hasProperty("name", equalTo(scanner.getName())),
				hasProperty("product", equalTo(scanner.getProduct())),
				hasProperty("scannerId", equalTo(scanner.getScannerId()))));
	}

}
