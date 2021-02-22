package com.github.mbeier1406.scanner.handler;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 * Der ExceptionHandler liest die aufgetretene Exception in die externe Request-Map ein
 * und navigiert zur Seite {@code /error/exception.xhtml}, wo die Exception angezeigt wird.
 * @author mbeier
 * @see com.github.mbeier1406.scanner.handler.ExceptionHandlerFactory
 */
public class ExceptionHandler extends ExceptionHandlerWrapper {

    private javax.faces.context.ExceptionHandler exceptionHandler;

    public ExceptionHandler(javax.faces.context.ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public javax.faces.context.ExceptionHandler getWrapped() {
        return exceptionHandler;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();
        while ( queue.hasNext() ) {
            ExceptionQueuedEvent item = queue.next();
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext)item.getSource();
            try {
                Throwable throwable = exceptionQueuedEventContext.getException();
                FacesContext context = FacesContext.getCurrentInstance();
                Map<String, Object> requestMap = context.getExternalContext().getRequestMap();
                NavigationHandler nav = context.getApplication().getNavigationHandler();
                requestMap.put("fehler", throwable.getMessage());
                requestMap.put("stack", throwable.getStackTrace());
                nav.handleNavigation(context, null, "/error/exception");
                context.renderResponse();
            } finally {
                queue.remove();
            }
        }
	}

}
