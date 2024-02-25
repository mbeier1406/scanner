package com.github.mbeier1406.scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

/**
 * Demonstriert die Nutzung eines {@linkplain PhaseListener}.
 * @see /scanner/src/main/webapp/WEB-INF/faces-config.xml
 */
public class ScannerPhaseListener implements PhaseListener {

	public static final Logger LOGGER = LogManager.getLogger(ScannerPhaseListener.class);

	private static final long serialVersionUID = 3568202434319914174L;

	@Override
	public void beforePhase(PhaseEvent event) {
		LOGGER.trace("Enter {}...", event.getPhaseId());
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		LOGGER.trace("Exit {}...", event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.INVOKE_APPLICATION;
	}

}
