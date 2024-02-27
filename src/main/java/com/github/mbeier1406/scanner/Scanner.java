package com.github.mbeier1406.scanner;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIOutput;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

/**
 * Definiert die Daten für einen Scanner.
 */
@Named
@RequestScoped
public class Scanner {

	public static final Logger LOGGER = LogManager.getLogger(Scanner.class);

	/** Text, wenn der Name des Scanners geändert wird */
	private String scannerNameChange = "";

	/** Name des Scanners */
    private String name;

    /** Datum Betriebsbeginn */
    private String inBetriebSeit;

	/** Interne Nummer */
    private String nummer;

    /** Wer bei Änderungen benchrichtigt werdne muss */
    private String[] emailadressen;

    /** Spracheinstellung des Scanners */
    private String sprache = "de";

    /** Alle Sprachen der Scannersoftware */
    @SuppressWarnings("serial")
	private static Map<String, String> sprachen = new LinkedHashMap<>() {{
    	put("Deutsch", "de");
    	put("Englisch", "en");
    	put("Französisch", "fr");
    	put("Italienisch", "it");
    }};

    public Scanner() {
    }

    /** Speichern der {@linkplain Scanner}-Bean, weitermachen mit {@code index.xhtml} */
    public String saveAction() {
    	LOGGER.info("Speichern...");
    	scannerNameChange = "";
    	return "index";
    }

    /** Wird aufgerufen, wenn das Formular abgeschickt wird und der Scannername sich geändert hat */
    public void nameChangedListener(ValueChangeEvent event) {
    	LOGGER.info("Neuer Wert für Scannername: {}", event.getNewValue());
    }

    /** Wird aufgerufen, wenn das Eingabefeld für den Scannernamen verlassen wird und der Scannername sich geändert hat */
    public void nameChangedAjaxListener(AjaxBehaviorEvent event) {
    	LOGGER.info("Eingabe für \"{}\": {}", event.getComponent().getId(), ((UIOutput) event.getSource()).getValue());
    	scannerNameChange = "Name wird geändert...";
    }

    /** Wird aufgerufen, wenn der "Speichern" Command-Button gedrückt wird */
    public void checkEMailAdresses(ActionEvent event) {
    	LOGGER.info("emailadressen={}", Arrays.toString(this.emailadressen));
    }

    public String getScannerNameChange() {
		return scannerNameChange;
	}

	public void setScannerNameChange(String scannerNameChange) {
		this.scannerNameChange = scannerNameChange;
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

	public Map<String, String> getSprachen() {
		return Scanner.sprachen;
	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	@Override
	public String toString() {
		return "Scanner [scannerNameChange=" + scannerNameChange + ", name=" + name + ", inBetriebSeit=" + inBetriebSeit
				+ ", nummer=" + nummer + ", emailadressen=" + Arrays.toString(emailadressen) + "]";
	}

}

