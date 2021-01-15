package com.github.mbeier1406.scanner.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang3.StringUtils;

import com.github.mbeier1406.scanner.Location;

/**
 * Einfacher Validator für einen Scannerstandort.
 * @author mbeier
 */
@FacesValidator("LocationValidator")
public class LocationValidator implements Validator {

	/** Format eines Strings, das einen Raum als Scannerstandort repräsentiert ist {@value} (Beispiel: <i>Raum 2</i>) */
	public static final String FORMAT = "Raum<Bezeichnung> <Nummer>";

	/**
	 * Prüft einenin der UI eingegebenen String für eine Raumbezeichnung.
	 * @throws ValidatorException falls das {@linkplain #FORMAT Format} nicht eingehalten wird.
	 * @see LocationValidator
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Location raum = (Location) value;
		if ( !raum.getRaum().startsWith("Raum") || raum.getNummer() <= 0 ) {
			FacesMessage msg = new FacesMessage("Format ist "+FORMAT+": erhalten '"+(String) value+"'");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
