package com.github.mbeier1406.scanner.domain;

import static com.github.mbeier1406.scanner.domain.EntityManagerLocalDb.LOCAL_PERSISTENCE_UNIT;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Optional;

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

	public Scanner scanner = new Scanner("ScannerName", "ScannerProduct", 123);

	/** Initialisierung {@linkplain #scannerDao} und der lokalen DB in {@linkplain EntityManagerLocalDb} */
	@Before
	public void init() throws Exception {
		scannerDao = new ScannerDaoJpa(LOCAL_PERSISTENCE_UNIT);
	}

	/**
	 * Workflow für {@linkplain ScannerDao} testen:
	 * <ol>
	 * <li>Den Scanner in {@linkplain #scanner} speichern</li>
	 * <Li>Abrufen und prüfen des Entity</li>
	 * <li>Lösschen des Scanner</i>
	 * <li>Erneute Abfrage liefert einen leeren {@linkplain Optional}
	 * </ol>
	 * @throws Exception bei technischen Fehlern
	 */
	@Test
	public void test() throws Exception {
		scannerDao.save(scanner);
		Optional<Scanner> scanner2 = scannerDao.get(scanner.getId());
		LOGGER.info("scanner2={}", scanner2);
		assertThat(scanner, equalTo(scanner2.get()));
		LOGGER.info("lösche scanner={}", scanner);
		scannerDao.delete(scanner);
		scanner2 = scannerDao.get(scanner.getId());
		assertThat(scanner2, equalTo(Optional.empty()));
	}

}
