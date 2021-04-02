package com.github.mbeier1406.scanner.web.validator;

import javax.faces.validator.ValidatorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.github.mbeier1406.scanner.web.validator.LocationValidator;

/**
 * Tests für die Klasse {@linkplain LocationValidator}.
 * @author mbeier
 */
public class LocationValidatorTest {

	public static final Logger LOGGER = LogManager.getLogger(LocationValidatorTest.class);

	/** Das zu testende Objekt ist {@linkplain LocationValidator} */
	public LocationValidator locationValidator = new LocationValidator();

	/** Fehler, wenn nur ein String in der Raumbezeichnung vorhanden ist */
	@Test(expected = ValidatorException.class)
	public void testeZuWenigStrings() {
		locationValidator.validate(null,  null,  "EinString");
	}

	/** Fehler, wenn zu viele Strings in der Raumbezeichnung vorhanden sind */
	@Test(expected = ValidatorException.class)
	public void testeZuVieleStrings() {
		locationValidator.validate(null,  null,  "Drei Strings vorhanden");
	}

	/** Fehler, wenn zweiter String keine Zahl ist */
	@Test(expected = ValidatorException.class)
	public void testeKeineRumNummer() {
		locationValidator.validate(null,  null,  "Raum zwei");
	}

	/** Korrekte Bezeichnung darf keinen Fehler erzeugen */
	@Test
	public void testeKorrekteRumNummer() {
		locationValidator.validate(null,  null,  "Raum 2");
	}

}
