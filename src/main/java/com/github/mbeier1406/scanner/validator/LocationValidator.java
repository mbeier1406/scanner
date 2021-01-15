package com.github.mbeier1406.scanner.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

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
		if ( value == null || !((Location) value).getRaum().startsWith("Raum") || ((Location) value).getNummer() <= 0 ) {
			throw getValidatorException(value);
		}
	}

	/**
	 * Liefert eine passende Exception zur Anzeige in der UI
	 * @param value das validierte Objekt
	 * @return die Exception
	 */
	public static final ValidatorException getValidatorException(Object value) {
		FacesMessage msg = new FacesMessage("Format ist "+FORMAT+": erhalten '"+value+"'");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		return new ValidatorException(msg);
	}

}
