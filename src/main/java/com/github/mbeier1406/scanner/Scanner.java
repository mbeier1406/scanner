package com.github.mbeier1406.scanner;

import java.util.Arrays;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * Definiert die Daten für einen Scanner.
 */
@Named
@RequestScoped
public class Scanner {

	/** Name des Scanners */
    private String name;

    /** Datum Betriebsbeginn */
    private String inBetriebSeit;

	/** Interne Nummer */
    private String nummer;

    /** Wer bei Änderungen benchrichtigt werdne muss */
    private String[] emailadressen;

    public Scanner() {
    }

    public String save() {
    	System.out.println("Speichern...");
    	return "index";
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInBetriebSeit() {
		return inBetriebSeit;
	}

	public void setInBetriebSeit(String inBetriebSeit) {
		this.inBetriebSeit = inBetriebSeit;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String[] getEmailadressen() {
		return emailadressen;
	}

	public void setEmailadressen(String[] emailadressen) {
		this.emailadressen = emailadressen;
	}

	@Override
	public String toString() {
		return "Scanner [name=" + name + ", inBetriebSeit=" + inBetriebSeit + ", nummer=" + nummer + ", emailadressen="
				+ Arrays.toString(emailadressen) + "]";
	}

}

