package com.github.mbeier1406.scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;

/**
 * Wird aufgerufen, wenn die Spracheinstellung für den Scanner in der GUI
 * geändert wird (nach Abschicken des Formulars).
 */
public class ScannerSpracheValueChangeListener implements ValueChangeListener {

	public static final Logger LOGGER = LogManager.getLogger(ScannerSpracheValueChangeListener.class);

	/** Gibt die neu ausgewählte Sprache im Log aus */
	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		LOGGER.info("Neue Sprache: {}", event.getNewValue());
	}

}
