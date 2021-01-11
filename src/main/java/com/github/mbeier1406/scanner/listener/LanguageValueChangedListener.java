package com.github.mbeier1406.scanner.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Wenn die Sprachauswahl geändert wurde.
 * @author mbeier
 */
public class LanguageValueChangedListener implements ValueChangeListener {

	public static final Logger LOGGER = LogManager.getLogger(LanguageValueChangedListener.class);

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		LOGGER.info("Neue Sprache: {}", event.getNewValue());
	}

}
