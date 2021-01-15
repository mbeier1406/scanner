package com.github.mbeier1406.scanner;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull(message="Scannername muss angegeben werden!")
	@Size(min=5, max=10, message="Scannername soll 5-10 Zeichen lang sein!")
	private String name;
	private String product;
	private int id;
	private Date started;
	private String number;
	private String[] users;
	private String message;
	private double price;
	private Location location;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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
		return "create";
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

	/**
	 * Validiert die Scannernummer, die in {@code /create.xhtml} eingegeben wird.
	 * Format ist <code>&lt;Major&gt;-&lt;Minor&gt;</code>.
	 * <b>ACHTUNG</b>: verwendet nicht <i>i18n</i> durch fest codierte Fehlermeldung.
	 * @param context Anwendungskontext
	 * @param component die UI Komponente
	 * @param value der eingegebenen String
	 * @throws ValidatorException falls essich bei dem Objekt um einen ungültigen String handelt
	 * @see {@link #setName(String)}
	 */
	public void validateNumber(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		try { 
			String str = (String) value;
			// TODO: Validierung
			if ( !str.startsWith("1-") )
				throw new Exception();
		}
		catch ( Exception e ) {
			FacesMessage msg = new FacesMessage("Scannernummer im Format <Major>-<Minor> angeben!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
