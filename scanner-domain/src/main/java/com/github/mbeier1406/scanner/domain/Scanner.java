package com.github.mbeier1406.scanner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author mbeier
 */
@Entity
public class Scanner {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private String name;
	private String product;
	private int scannerId;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getScannerId() {
		return scannerId;
	}
	public void setScannerId(int scannerId) {
		this.scannerId = scannerId;
	}

	@Override
	public String toString() {
		return "Scanner [id=" + id + ", name=" + name + ", product=" + product + ", scannerId=" + scannerId + "]";
	}

}
