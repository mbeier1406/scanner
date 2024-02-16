package com.github.mbeier1406.scanner.beans;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class Scanner {

	public static final Logger LOGGER = LogManager.getLogger(Scanner.class);

	private String name, location, activeSince, id;
	private String[] emailAdress;
	public Scanner(String name, String location, String activeSince, String id, String[] emailAdress) {
		super();
		this.name = name;
		this.location = location;
		this.activeSince = activeSince;
		this.id = id;
		this.emailAdress = emailAdress;
	}
	public String save() {
		// TODO: Implementierung fehlt
		LOGGER.info("scanner={}", toString());
		return "index";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getActiveSince() {
		return activeSince;
	}
	public void setActiveSince(String activeSince) {
		this.activeSince = activeSince;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String[] emailAdress) {
		this.emailAdress = emailAdress;
	}
	@Override
	public String toString() {
		return "Scanner [name=" + name + ", location=" + location + ", activeSince=" + activeSince + ", id=" + id
				+ ", emailAdress=" + Arrays.toString(emailAdress) + "]";
	}
}
