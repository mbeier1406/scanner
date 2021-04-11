package com.github.mbeier1406.scanner.domain;

import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Standard-DAO für {@linkplain ScannerDao} als JPA-Implementierung
 * @author mbeier
 * @see Scanner
 */
public class ScannerDaoJpa implements ScannerDao<Scanner> {

	public static final Logger LOGGER = LogManager.getLogger(ScannerDaoJpa.class);

	/** Der EntityManager */
	public EntityManager em;

	/**
	 * Initialisierung des {@linkplain #em}.
	 * @param persistenceUnit
	 */
	public ScannerDaoJpa(String persistenceUnit) {
		LOGGER.info("persistenceUnit={}", persistenceUnit);
		em = Persistence
			.createEntityManagerFactory(persistenceUnit)
			.createEntityManager();
		em.getProperties().entrySet().stream().forEach(e -> LOGGER.info("em: "+e.getKey()+"="+e.getValue()));
	}

	/** {@inheritDoc} */
	@Override
	public Optional<Scanner> get(long id) {
		LOGGER.trace("id={}", id);
		return Optional.ofNullable(em.find(Scanner.class, id));
	}

	/** {@inheritDoc} */
	@Override
	public void save(Scanner scanner) {
		try {
			LOGGER.trace("scanner={}", scanner);
			transaction(entityManager -> entityManager.persist(scanner));
		}
		catch ( Exception e ) {
			LOGGER.error("scanner={}", scanner, e);
			throw e;
		}
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Scanner scanner) throws Exception {
		try {
			LOGGER.trace("scanner={}", scanner);
			transaction(entityManager -> entityManager.remove(scanner));
		}
		catch ( Exception e ) {
			LOGGER.error("scanner={}", scanner, e);
			throw e;
		}
	}

	/**
	 * Führt eine Operation auf dem EntityManager {@linkplain #em} innerhalb einer Transaktion aus.
	 * @param operation Eine Operation wie {@linkplain EntityManager#persist(Object)}
	 */
	private void transaction(Consumer<EntityManager> operation) {
		try {
			em.getTransaction().begin();
			operation.accept(em);
			em.getTransaction().commit();
		}
		catch ( Exception e ) {
			em.getTransaction().rollback();
			throw e;
		}
	}

}
