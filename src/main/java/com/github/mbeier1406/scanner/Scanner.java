package com.github.mbeier1406.scanner;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Repräsentiert einen Scanner mit allen zugehörigen Informationen.
 * @author mbeier
 */
@ManagedBean
@RequestScoped
public class Scanner {

	public static final Logger LOGGER = LogManager.getLogger(Scanner.class);
	
	private String name;
	private String id;
	private String started;
	private String number;
	private String[] users;
	private String message;
	private String language = "de";
	private static LinkedHashMap<String, String> languages;

	static {
		languages = new LinkedHashMap<>();
		languages.put("Deutsch", "de");
		languages.put("Englisch", "en");
		languages.put("Italienisch", "it");
		languages.put("Koreanisch", "kr");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStarted() {
		return started;
	}
	public void setStarted(String started) {
		this.started = started;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String[] getUsers() {
		return users;
	}
	public void setUsers(String[] users) {
		this.users = users;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public LinkedHashMap<String, String> getLanguages() {
		return languages;
	}

	/**
	 * Speichert die aktuelle Scannerinformation in der Datenbank.
	 * @return die XHTML-Seite , mit der die Navigation fortgesetzt wird
	 */
	public String save() {
		// TODO: abspeichern..
		return "index";
	}

	/**
	 * Wird vor {@linkplain #save()}, wenn in {@code /index.xhtml} die <i>Abspeichern</i>-Funktion ausgelöst wird.
	 * Informiert die in {@linkplain #users} ausgewählten Benutzer über die Scanneranlage bzw. -änderung.
	 * @param e der {@linkplain ActionEvent}
	 */
	public void saveListener(ActionEvent e) {
		LOGGER.info("Users: {}", Arrays.toString(this.users));
	}

	/**
	 * Protokollierung der Änderungen der ausgewählten Usern.
	 * @param e {@linkplain ValueChangeEvent} für die Listbox mit den definierten Usern
	 */
	public void usersChanged(ValueChangeEvent e) {
		LOGGER.info("Neue Adressen: {}", Arrays.toString((String[]) e.getNewValue()));
	}

	/**
	 * Setzt die {@linkplain #message} als Warnung, wenn mehr als zwei User einem Scanner zugeordnet werden.
	 * @param e der Ajax-Event
	 */
	public void usersChangedEvent(AjaxBehaviorEvent e) {
		message = "";
		if ( users.length > 2 )
			message = "Es sollten nur max. zwei Personen einem Scanner zugeodnet werden!";
	}

}
