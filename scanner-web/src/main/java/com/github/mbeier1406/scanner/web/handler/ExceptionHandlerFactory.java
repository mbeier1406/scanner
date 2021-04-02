package com.github.mbeier1406.scanner.web.handler;

/**
 * Die in {@code webapp/WEB-INF/faces-config.xml} definierte HandlerFactory für Exceptions.
 * @author mbeier
 * @see com.github.mbeier1406.scanner.web.handler.ExceptionHandler
 */
public class ExceptionHandlerFactory extends javax.faces.context.ExceptionHandlerFactory {

    private javax.faces.context.ExceptionHandlerFactory exceptionHandlerFactory;

    public ExceptionHandlerFactory() {
    }

    public ExceptionHandlerFactory(javax.faces.context.ExceptionHandlerFactory exceptionHandlerFactory) {
        this.exceptionHandlerFactory = exceptionHandlerFactory;
    }

	@Override
	public javax.faces.context.ExceptionHandler getExceptionHandler() {
		return new com.github.mbeier1406.scanner.web.handler.ExceptionHandler(exceptionHandlerFactory.getExceptionHandler());
	}

}
