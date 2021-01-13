package com.github.mbeier1406.scanner;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * Testrepository mit vor-definierten Scannern.
 * @author mbeier
 */
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
		scanner.setStarted("heute");
		scanner.setPrice(12.33);
		scanner.setUsers(new String[]{"User1"});
		SCANNER_LISTE.add(scanner);
		scanner = new Scanner();
		scanner.setId(2);
		scanner.setLanguage("en");
		scanner.setMessage("Scanner II");
		scanner.setName("Scanner 2");
		scanner.setNumber("1-2");
		scanner.setStarted("heute mittag");
		scanner.setPrice(528.11);
		scanner.setUsers(new String[]{"User1", "User2"});
		SCANNER_LISTE.add(scanner);
		scanner = new Scanner();
		scanner.setId(3);
		scanner.setLanguage("it");
		scanner.setMessage("Scanner III");
		scanner.setName("Scanner 3");
		scanner.setNumber("1-3");
		scanner.setStarted("gestern");
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

}
