package com.github.mbeier1406.scanner.domain;

import java.util.Optional;

/**
 * Standard DAO-Pattern für Persistenz.
 * @author mbeier
 * @param <T> Eine Klasse aus dem Scannerprojekt, z. B. {@linkplain Scanner}
 */
public interface ScannerDao<T> {

	/**
	 * Liefert das Objekt zur vorgegebenen internen ID.
	 * @param id die interne ID des Objektes
	 * @return Optional mit dem ausgelesenen Objekt.
	 */
	public Optional<T> get(long id);

	/**
	 * Speichert ein Objekt aus dem Scannerprojekt.
	 * @param t Zu speichernde Klasse, z. B. {@linkplain Scanner}
	 */
	public void save(T t);

}
