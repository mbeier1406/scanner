package com.github.mbeier1406.scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Repräsentiert einen Scanner mit allen zugehörigen Informationen.
 * @author mbeier
 */
@ManagedBean
@RequestScoped
public class Scanner {

	private String name;
	private String id;
	private String started;
	private String number;
	private String[] user;

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
	public String[] getUser() {
		return user;
	}
	public void setUser(String[] user) {
		this.user = user;
	}

	public String save() {
		// TODO: abspeichern..
		return "index";
	}

}
