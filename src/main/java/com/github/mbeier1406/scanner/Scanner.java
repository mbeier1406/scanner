package com.github.mbeier1406.scanner;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * Definiert die Daten für einen Scanner.
 */
@Named
@RequestScoped
public class Scanner {

	/** Name des Scanners */
    private String name;

    public Scanner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }

}

