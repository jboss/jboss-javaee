/* $Id: PersistenceException.java 11282 2007-03-14 22:05:59Z epbernard $
 * JBoss, Inc
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package javax.persistence;

/**
 * Thrown by the persistence provider when a problem occurs. All instances of PersistenceException
 * except for instances of NoResultException and NonUniqueResultException will cause the current
 * transaction, if one is active, to be marked for rollback.
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 */
public class PersistenceException extends RuntimeException {
	/**
	 * Constructs a new PersistenceException exception with null as its detail message.
	 */
	public PersistenceException() {
	}

	/**
	 * Constructs a new PersistenceException exception with the specified detail message.
	 *
	 * @param message the detail message
	 */
	public PersistenceException(String message) {
		super( message );
	}

	/**
	 * Constructs a new PersistenceException exception with the specified detail message and cause
	 *
	 * @param message the detail message
	 * @param cause the cause
	 */
	public PersistenceException(String message, Throwable cause) {
		super( message, cause );
	}

	/**
	 * Constructs a new PersistenceException exception with the specified cause
	 *
	 * @param cause the cause
	 */
	public PersistenceException(Throwable cause) {
		super( cause );
	}
}
