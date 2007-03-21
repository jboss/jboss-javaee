//$Id: PersistenceUnitTransactionType.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence.spi;

/**
 * This enum class defines whether the entity managers created by the EntityManagerFactory will be
 * JTA or resource-local entity managers.
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 */
public enum PersistenceUnitTransactionType {
	/**
	 * JTA entity manager
	 */
	JTA,
	/**
	 * Resource-local entity manager
	 */
	RESOURCE_LOCAL
}
