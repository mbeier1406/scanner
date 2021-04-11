package com.github.mbeier1406.scanner.domain;

import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Optional;
import java.util.stream.LongStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Tests für {@linkplain ScannerDao}.
 * @author mbeier
 */
public class ScannerDaoTest {

	public static final Logger LOGGER = LogManager.getLogger(ScannerDaoTest.class);

	/** Im einfachsten Fall mit dem Mock */
	public ScannerDao<Scanner> scannerDaoMock = new ScannerDaoMock();

	/**
	 * <p>Tests mit dem {@linkplain ScannerDaoMock}</p>
	 * Vier Scanner sind verfügbar, wenn mehr abgefragt werden, müssen sie {@linkplain Optional#empty()} liefern.
	 */
	@Test
	public void testeAnzahlEintraege() {
		assertThat(LongStream
			.range(1, 6)
			.mapToObj(this.scannerDaoMock::get)
			.filter(not(o -> o.equals(Optional.empty())))
			.peek(LOGGER::info)
			.count(), equalTo(4L));
	}

	/** Loeschen eines nicht-vorhandenen Scanners muss eine {@linkplain java.util.NoSuchElementException} liefern */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testeLoeschenNichtVorhandenes() throws Exception {
		this.scannerDaoMock.delete(new Scanner());
	}

	/** Loeschen eines vorhandenen Scanners muss eine kuerzere Liste liefern */
	@Test
	public void testeLoeschenVorhandenes() throws Exception {
		this.scannerDaoMock.delete(scannerDaoMock.get(1L).get());
		assertThat("Es werden nur noch drei Objekte erwartet!",
				((ScannerDaoMock) this.scannerDaoMock).anzahlObjekte(),
				equalTo(3));
	}

}
