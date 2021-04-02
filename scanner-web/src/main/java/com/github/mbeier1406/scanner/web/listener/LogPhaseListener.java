package com.github.mbeier1406.scanner.web.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Protokollierung der JSF-Phasen zum Test.
 * @author mbeier
 */
public class LogPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -774432004940984826L;
	public static final Logger LOGGER = LogManager.getLogger(LogPhaseListener.class);

	@Override
	public void afterPhase(PhaseEvent event) {
//		LOGGER.trace("phase={} ({})", event.getPhaseId(), event.getFacesContext().getCurrentPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
//		LOGGER.trace("phase={} ({})", event.getPhaseId(), event.getFacesContext().getCurrentPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
