package com.github.mbeier1406.scanner.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Mock-Implementierung für das {@linkplain ScannerDao}.
 * @author mbeier
 */
public class ScannerDaoMock implements ScannerDao<Scanner> {

	@SuppressWarnings("serial")
	private Map<Long, Scanner> scannerListe = new HashMap<Long, Scanner>() {{
		put(1L, new Scanner("Scanner1", "Typ1", 111));
		put(2L, new Scanner("Scanner2", "Typ2", 222));
		put(3L, new Scanner("Scanner3", "Typ3", 333));
		put(4L, new Scanner("Scanner4", "Typ4", 444));
	}};

	/** Liefert sie "Größe" der "Datenbank" */
	public int anzahlObjekte() {
		return this.scannerListe.size();
	}

	/** {@inheritDoc} */
	@Override
	public Optional<Scanner> get(long id) {
		return Optional.ofNullable(this.scannerListe.get(id));
	}

	/** {@inheritDoc} */
	@Override
	public void save(Scanner t) {
		this.scannerListe.put(t.getId(), t);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Scanner t) throws Exception {
		this.scannerListe.remove(this.scannerListe.keySet().stream().filter(key -> t.equals(this.scannerListe.get(key))).findFirst().get());
	}

}
