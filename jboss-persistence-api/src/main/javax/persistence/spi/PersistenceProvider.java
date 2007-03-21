//$Id: PersistenceProvider.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence.spi;

import java.util.Map;
import javax.persistence.EntityManagerFactory;

/**
 * Interface implemented by the persistence provider.
 * This interface is used to create an EntityManagerFactory.
 * It is invoked by the container in Java EE environments and
 * by the Persistence class in Java SE environments.
 */
public interface PersistenceProvider {
	/**
	 * Called by Persistence class when an EntityManagerFactory
	 * is to be created.
	 *
	 * @param emName The name of the persistence unit
	 * @param map	A Map of properties for use by the
	 *               persistence provider. These properties may be used to
	 *               override the values of the corresponding elements in
	 *               the persistence.xml file or specify values for
	 *               properties not specified in the persistence.xml
	 *               (and may be null if no properties are specified).
	 * @return EntityManagerFactory for the persistence unit,
	 *         or null if the provider is not the right provider
	 */
	public EntityManagerFactory createEntityManagerFactory(String emName, Map map);

	/**
	 * Called by the container when an EntityManagerFactory
	 * is to be created.
	 *
	 * @param info Metadata for use by the persistence provider
	 * @param map  A Map of integration-level properties for use
	 *             by the persistence provider (may be null if no properties
	 *             are specified).
	 * @return EntityManagerFactory for the persistence unit
	 *         specified by the metadata
	 */
	public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info, Map map);
}