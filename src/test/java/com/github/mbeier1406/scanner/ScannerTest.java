package com.github.mbeier1406.scanner;

import org.apache.logging.log4j.CloseableThreadContext;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests für die Klasse {@linkplain Scanner}.
 * @author mbeier
 */
public class ScannerTest {

	/** Das zu testende Objekt */
	public Scanner scanner;

	@Before
	public void init() {
		scanner = new Scanner();
	}

	/** Prüft nur die Log4J-Konfiguration in {@linkplain /scanner/src/test/resources/log4j2-test.xml} */
	@Test
	public void testeLogger() {
		try ( CloseableThreadContext.Instance ctx = CloseableThreadContext.put("key",  "value")) {
			Scanner.LOGGER.info("scanner={}", scanner);
		}
	}

}
