package com.github.mbeier1406.scanner;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * Testrepository mit vor-definierten Scannern.
 * @author mbeier
 */
@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class SampleScannerRepository implements ScannerRepository<Scanner> {

	private static final ArrayList<Scanner> SCANNER_LISTE;
	private DataModel<Scanner> scannerDataModel;

	static {
		SCANNER_LISTE = new ArrayList<>();
		Scanner scanner = new Scanner();
		scanner.setId(1);
		scanner.setLanguage("de");
		scanner.setMessage("Scanner I");
		scanner.setName("Scanner 1");
		scanner.setNumber("1-1");
		scanner.setStarted(new Date());
		scanner.setPrice(12.33);
		scanner.setUsers(new String[]{"User1"});
		SCANNER_LISTE.add(scanner);
		scanner = new Scanner();
		scanner.setId(2);
		scanner.setLanguage("en");
		scanner.setMessage("Scanner II");
		scanner.setName("Scanner 2");
		scanner.setNumber("1-2");
		scanner.setStarted(new Date(2020-1900, 12, 27));
		scanner.setPrice(528.11);
		scanner.setUsers(new String[]{"User1", "User2"});
		SCANNER_LISTE.add(scanner);
		scanner = new Scanner();
		scanner.setId(3);
		scanner.setLanguage("it");
		scanner.setMessage("Scanner III");
		scanner.setName("Scanner 3");
		scanner.setNumber("1-3");
		scanner.setStarted(new Date(2021-1900, 1, 7));
		scanner.setPrice(4.67);
		scanner.setUsers(new String[]{"User2"});
		SCANNER_LISTE.add(scanner);
	}

	/** {@inheritDoc} */
	@Override
	public DataModel<Scanner> getScannerList() {
		if ( scannerDataModel == null )
			scannerDataModel = new ListDataModel<Scanner>(SCANNER_LISTE);
		return scannerDataModel;
	}

	/**
	 * Wird verwendet, wenn ein neuer Scanner angelegt wird
	 * @see #prepareNewScanner()
	 */
	private Scanner tmpScanner;

	public Scanner getTmpScanner() {
		return tmpScanner;
	}
	public void setTmpScanner(Scanner tmpScanner) {
		this.tmpScanner = tmpScanner;
	}

	/**
	 * Legt einen temporären {@linkplain Scanner} zur Erfassung in der
	 * {@code /scanner/src/main/webapp/create.xhtml}-Seite an und navigiert dort hin.
	 * @return die Seite, mit der weiter navigiert wird
	 */
	public String prepareNewScanner() {
		tmpScanner = new Scanner();
		return "create";
	}

	/**
	 * Fügt den in der Create-Seite eingefügten Scanner in die Liste {@linkplain #SCANNER_LISTE}
	 * ein, falls er dort noch nicht vorhanden ist.
	 * @return die Index-Seite, mit der die Navigation fortfährt
	 */
	public String saveScanner() {
		if ( !SCANNER_LISTE.contains(tmpScanner) ) {
			SCANNER_LISTE.add(tmpScanner);
			scannerDataModel = null;
		}
		tmpScanner = null;
		return "index";
	}

}
