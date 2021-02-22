package com.github.mbeier1406.scanner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests für {@linkplain SampleScannerRepository}.
 * @author mbeier
 */
public class SampleScannerRepositoryTest {

	/** Das zu testende Objekt */
	public SampleScannerRepository sampleScannerRepository;

	@Before
	public void init() {
		sampleScannerRepository = new SampleScannerRepository();
	}

	/** Testliste der Scanner soll nicht leer sein */
	@Test
	public void testeListeDerScanner() {
		assertThat(sampleScannerRepository.getScannerList(), notNullValue());
		assertThat(sampleScannerRepository.getScannerList().getRowCount(), greaterThan(0));
	}

}
