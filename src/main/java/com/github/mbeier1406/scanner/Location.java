package com.github.mbeier1406.scanner;

import com.github.mbeier1406.scanner.validator.LocationValidator;

/**
 * Repräsentiert den Standort eines {@linkplain Scanner}s.
 * @author mbeier
 */
public class Location {

	/** Name des Raums */
	private String raum;

	/** Raumnummer */
	private int nummer;

	public Location() {}

	/**
	 * Erstellt das Objekt aus einem String im Format {@linkplain LocationValidator#FORMAT}
	 * @param raum die Raumbezeichnung
	 * @throws Exception
	 */
	public Location(String raum) throws RuntimeException {
		try {
			String[] daten = raum.split("\\s");
			this.raum = daten[0];
			this.nummer = Integer.parseInt(daten[1]);
		}
		catch ( Throwable t ) {
			throw new RuntimeException("Raumbezeichnung im Format "+LocationValidator.FORMAT+"; erhalten: '"+raum+"'");
		}
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	/**
	 * Liefert die Raumbezeichnung zur Anzeige (z. B. in der UI)
	 * @return die Raumbezeichnung
	 */
	public String getLocation() {
		return raum + " " + nummer;
	}

	@Override
	public String toString() {
		return "Location [raum=" + raum + ", nummer=" + nummer + "]";
	}

}
