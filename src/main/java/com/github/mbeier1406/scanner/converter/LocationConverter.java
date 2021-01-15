package com.github.mbeier1406.scanner.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.github.mbeier1406.scanner.Location;

/**
 * Wandelt einen String in einen Scannerstandort um und umgekehrt.
 * Wird für die UI in {@code /scanner/src/main/webapp/create.xhtml} benötigt.
 * @author mbeier
 * @see Location
 */
@FacesConverter("LocationConverter")
public class LocationConverter implements Converter {

	/** Wandelt einen String in eine {@linkplain Location} um */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return new Location(value);
	}

	/** Wandelt  eine {@linkplain Location} int einen String um */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Location) value).getLocation();
	}

}
