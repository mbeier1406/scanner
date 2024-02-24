package com.github.mbeier1406.scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ActionListener;

/**
 * Demonstriert die Nutzung von ActionListenern.<p/>
 * Genutzt in <code>/scanner/src/main/webapp/index.xhtml</code>.
 * @author mbeier
 */
public class ScannerActionListener implements ActionListener {

	public static final Logger LOGGER = LogManager.getLogger(ScannerActionListener.class);

	/** Gibt die ID des Elements aus, das den Event erzeugt hat (hier: "speichern") */
	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
    	System.out.println("Komponente: \""+event.getComponent().getId()+"\"");
	}

}
