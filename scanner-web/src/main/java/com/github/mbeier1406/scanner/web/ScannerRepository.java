package com.github.mbeier1406.scanner.web;

import javax.faces.model.DataModel;

/**
 * Schnittstelle zum Scanner-Repository, das Informationen zu allen definierten Scannern enthält.
 * @author mbeier
 * @param <T>
 * @see Scanner
 */
public interface ScannerRepository<T> {

	/**
	 * Liefert die Liste der definierten Scanner.
	 * @return die definierten Scanner
	 */
	public DataModel<T> getScannerList();

}
